-----------------------------------------------------------------------------------------------------
--------------------------------- INSERTS-----------------------------------------------------------
-----------------------------------------------------------------------------------------------------

-- inserting location
INSERT INTO Project.LOCATIONS(LOCATION_ID, ADDRESS, POSTAL_CODE, CITY, COUNTRY) VALUES(1,'PIASECZNA GÓRKA UL.ŻURAWIA 80', '26-026', 'MORAWICA', 'POLAND');

-- inserting employee
INSERT INTO Project.EMPLOYEES(EMPLOYEE_ID, FIRST_NAME, LAST_NAME, PHONE, EMAIL, JOB_TITLE) VALUES(1,'MACIEJ', 'PIWEK', '733-123-123', 'tmep@temp.pl', 'MAGAZYNIER');

-- inserting warehouse
INSERT INTO Project.WAREHOUSES(WAREHOUSE_ID, LOCATION_ID, WAREHOUSE_NAME) VALUES(1,1,'MAGAZYN_1');

-- inserting employees_in_warehouses
INSERT INTO Project.EMPLOYEES_IN_WAREHOUSES(WAREHOUSE_ID, EMPLOYEE_ID) VALUES(1,1);

-- inserting product_categories
INSERT INTO Project.PRODUCT_CATEGORIES(CATEGORY_ID, CATEGORY_NAME) VALUES (1, 'WELNA');

-- inserting products
INSERT INTO Project.PRODUCTS(PRODUCT_ID, CATEGORY_ID, PRODUCT_NAME, DESCRIPTION, COST, PRICE) VALUES(1,1, 'WELNA', 'ROCKWOOL 12CM', 25.25, 30.00);

-- inserting products_in_warehouses
INSERT INTO Project.PRODUCTS_IN_WAREHOUSES(WAREHOUSE_ID, PRODUCT_ID, QUANTITY) VALUES(1,1,500);

-- inserting customer
INSERT INTO Project.CUSTOMERS(CUSTOMER_ID,  CREDIT) VALUES (1, 7000.00);

-- inserting contact
INSERT INTO Project.CONTACTS(CONTACT_ID, CUSTOMER_ID, FIRST_NAME, LAST_NAME, PHONE, ADDRESS, EMAIL) VALUES (1, 1, 'KAROL' , 'NOWAK', '733-879-325', 'LEA 114a', 'TEMP@TEMP.PL');


-----------------------------------------------------------------------------------------------------
--------------------------------- UPDATES -----------------------------------------------------------
-----------------------------------------------------------------------------------------------------

UPDATE Project.WAREHOUSES
SET WAREHOUSE_NAME = 'magazyn_1'
WHERE WAREHOUSE_ID = 1;


-----------------------------------------------------------------------------------------------------
--------------------------------- SELECTS -----------------------------------------------------------
-----------------------------------------------------------------------------------------------------

-- selects all employees
SELECT E.FIRST_NAME, E.LAST_NAME, W.WAREHOUSE_NAME
FROM Project.EMPLOYEES E 
JOIN Project.EMPLOYEES_IN_WAREHOUSES EW ON e.EMPLOYEE_ID = ew.EMPLOYEE_ID
JOIN Project.WAREHOUSES W ON W.WAREHOUSE_ID = ew.WAREHOUSE_ID;

-- selects all products from magazine
SELECT P.PRODUCT_NAME, P.DESCRIPTION, W.WAREHOUSE_NAME
FROM Project.PRODUCTS P
JOIN Project.PRODUCTS_IN_WAREHOUSES PW ON P.PRODUCT_ID = PW.WAREHOUSE_ID
JOIN Project.WAREHOUSES W ON W.WAREHOUSE_ID = PW.WAREHOUSE_ID;

