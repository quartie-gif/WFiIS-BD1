
-- Products

CREATE VIEW Products AS
SELECT P.PRODUCT_ID, P.PRODUCT_NAME, P.DESCRIPTION, W.WAREHOUSE_NAME, PW.QUANTITY, U.USER_ID
FROM Project.PRODUCTS P
LEFT JOIN Project.PRODUCTS_IN_WAREHOUSES PW ON P.PRODUCT_ID = PW.PRODUCT_ID
LEFT JOIN Project.WAREHOUSES W ON W.WAREHOUSE_ID = PW.WAREHOUSE_ID
LEFT JOIN Project.USERS U ON U.USER_ID = W.USER_ID

ORDER BY P.PRODUCT_ID;



-- Employees
CREATE VIEW Employees AS
SELECT E.EMPLOYEE_ID, FIRST_NAME, E.LAST_NAME, W.WAREHOUSE_NAME, U.USER_ID
FROM Project.EMPLOYEES E 
LEFT JOIN Project.EMPLOYEES_IN_WAREHOUSES EW ON e.EMPLOYEE_ID = ew.EMPLOYEE_ID
LEFT JOIN Project.WAREHOUSES W ON W.WAREHOUSE_ID = ew.WAREHOUSE_ID
LEFT JOIN Project.USERS U ON U.USER_ID = W.USER_ID
ORDER BY EMPLOYEE_ID;

-- Clients with contacts
CREATE VIEW Clients AS
SELECT CON.*, C.CREDIT
FROM Project.CUSTOMERS C 
LEFT JOIN Project.CONTACTS CON ON C.CUSTOMER_ID = CON.CUSTOMER_ID
ORDER BY C.CUSTOMER_ID;

-- Categories
CREATE VIEW Product_categories AS
SELECT * FROM Project.PRODUCT_CATEGORIES;

--  Warehouses
CREATE VIEW WAREHOUSES_WITH_LOCATIONS AS
SELECT W.Warehouse_ID, W.WAREHOUSE_NAME, L.*
FROM Project.WAREHOUSES W
LEFT JOIN Project.LOCATIONS L ON W.LOCATION_ID = L.LOCATION_ID
ORDER BY W.WAREHOUSE_ID;

-- Orders
CREATE VIEW Orders AS
SELECT O.*
FROM Project.ORDERS O
ORDER BY O.ORDER_ID;

-- Orders number with amount
CREATE OR REPLACE VIEW orders_with_amount AS
SELECT O.NUMBER AS NUMER_ZAMOWIENIA,
   SUM(ORDER_AMOUNTS.Amount) AS CALKOWITA_WARTOSC
FROM Project.ORDERS O
INNER JOIN (SELECT OI.ORDER_ID, SUM(OI.QUANTITY*P.PRICE) AS Amount
   FROM Project.ORDER_ITEM OI
   LEFT JOIN Project.PRODUCTS P ON P.PRODUCT_ID=OI.PRODUCT_ID
   GROUP BY ORDER_ID) AS ORDER_AMOUNTS
   ON O.ORDER_ID = ORDER_AMOUNTS.ORDER_ID
   GROUP BY O.ORDER_ID;

   

