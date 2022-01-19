-- Show triggers
select event_object_schema as table_schema,
       event_object_table as table_name,
       trigger_schema,
       trigger_name,
       string_agg(event_manipulation, ',') as event,
       action_timing as activation,
       action_condition as condition,
       action_statement as definition
from information_schema.triggers
group by 1,2,3,4,6,7,8
order by table_schema,
         table_name;

         
CREATE OR REPLACE FUNCTION Project.contact_check() RETURNS TRIGGER AS $$
    BEGIN
        IF NEW.first_name !~* '^[A-Za-z]+$' THEN
            RAISE EXCEPTION 'Niepoprawne imię!';
        END IF;
        IF NEW.last_name !~* '^[A-Za-z]+$' THEN
            RAISE EXCEPTION 'Niepoprawny nazwisko!';
        END IF;
        IF NEW.phone!~* '^\d{3}-\d{3}-\d{3}$' THEN
            RAISE EXCEPTION 'Niepoprawny telefon! Format[XXX-XXX-XXX]';
        END IF;
        IF NEW.EMAIL!~* '[a-zA-Z0-9._-]+@[a-zA-Z0-9._-]+\.[a-zA-Z0-9_-]+' THEN
            RAISE EXCEPTION 'Niepoprawny mail!';
        END IF;
        RETURN NEW;
    END;
$$ LANGUAGE 'plpgsql';  

CREATE TRIGGER customer_insert
    BEFORE INSERT OR UPDATE ON Project.CONTACTS
    FOR EACH ROW EXECUTE PROCEDURE Project.contact_check();


CREATE OR REPLACE FUNCTION Project.update_amount() RETURNS TRIGGER AS $$
    BEGIN
        UPDATE orders
        SET TOTAL_AMOUNT = TOTAL_AMOUNT + (SELECT MAX(PRICE) FROM Project.PRODUCTS P WHERE P.PRODUCT_ID = New.PRODUCT_ID) * New.quantity
        WHERE ORDER_ID = New.ORDER_ID ;
        RETURN NEW;
    END;
$$ LANGUAGE 'plpgsql';  

CREATE TRIGGER order_item_insert
    AFTER INSERT OR UPDATE ON Project.ORDER_ITEM
    FOR EACH ROW EXECUTE PROCEDURE Project.update_amount();

CREATE OR REPLACE FUNCTION Project.update_credit() RETURNS TRIGGER AS $$
    BEGIN
        UPDATE Project.CUSTOMERS
        SET CREDIT = (SELECT SUM(TOTAL_AMOUNT) FROM Project.ORDERS O WHERE O.CUSTOMER_ID = New.CUSTOMER_ID LIMIT 1)
        WHERE CUSTOMER_ID = New.CUSTOMER_ID ;
        RETURN NEW;
    END;
$$ LANGUAGE 'plpgsql';  

CREATE TRIGGER new_total_amount
    AFTER UPDATE ON Project.ORDERS
    FOR EACH ROW EXECUTE PROCEDURE Project.update_credit();

CREATE OR REPLACE FUNCTION Project.credit_after_removing_order() RETURNS TRIGGER AS $$
    BEGIN

        IF OLD.ORDER_ID = 1 THEN
            UPDATE Project.CUSTOMERS
            SET CREDIT = 0
            WHERE CUSTOMER_ID = OLD.CUSTOMER_ID ;
            return OLD;
        END IF;
        UPDATE Project.CUSTOMERS
        SET CREDIT = (SELECT SUM(TOTAL_AMOUNT) FROM Project.ORDERS O WHERE coalesce(O.CUSTOMER_ID, 0) = coalesce(OLD.CUSTOMER_ID, 0) LIMIT 1)
        WHERE CUSTOMER_ID = OLD.CUSTOMER_ID ;
        RETURN OLD;
    END;
$$ LANGUAGE 'plpgsql';  

CREATE TRIGGER after_delete_total_amount
    AFTER DELETE ON Project.ORDERS
    FOR EACH ROW EXECUTE PROCEDURE Project.credit_after_removing_order();

