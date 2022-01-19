
-----------------------------------------------------------------------------------------------------
--------------------------------- SELECTS -----------------------------------------------------------
-----------------------------------------------------------------------------------------------------

-- selects all employees
SELECT E.FIRST_NAME, E.LAST_NAME, W.WAREHOUSE_NAME
FROM Project.EMPLOYEES E 
LEFT JOIN Project.EMPLOYEES_IN_WAREHOUSES EW ON e.EMPLOYEE_ID = ew.EMPLOYEE_ID
LEFT JOIN Project.WAREHOUSES W ON W.WAREHOUSE_ID = ew.WAREHOUSE_ID;

-- selects all products from magazine
SELECT P.PRODUCT_NAME, P.DESCRIPTION, W.WAREHOUSE_NAME
FROM Project.PRODUCTS P
LEFT JOIN Project.PRODUCTS_IN_WAREHOUSES PW ON P.PRODUCT_ID = PW.PRODUCT_ID
LEFT JOIN Project.WAREHOUSES W ON W.WAREHOUSE_ID = PW.WAREHOUSE_ID
ORDER BY WAREHOUSE_NAME;


-- checks login
SELECT U.LOGIN, U.PASSWORD
FROM Project.USERS U;

-- count employees
SELECT 
   COUNT(*) 
FROM 
   (SELECT * FROM Employees)as Employees;


-- count products
SELECT 
   COUNT(*) 
FROM 
   (SELECT * FROM Products)as Products;


-- count number of orders and amount
SELECT COUNT(O.ORDER_ID) AS CAŁKOWITA_ILOŚĆ_ZAMÓWIEŃ,
   SUM(ORDER_AMOUNTS.Amount) AS CAŁKOWITA_WARTOŚĆ_SPRZEDAŻY
FROM Project.ORDERS O
INNER JOIN (SELECT OI.ORDER_ID, SUM(OI.QUANTITY*P.PRICE) AS Amount
   FROM Project.ORDER_ITEM OI
   LEFT JOIN Project.PRODUCTS P ON P.PRODUCT_ID=OI.PRODUCT_ID
   GROUP BY ORDER_ID) AS ORDER_AMOUNTS
   ON O.ORDER_ID = ORDER_AMOUNTS.ORDER_ID;
   


-- count orders containing products
   SELECT * 
   FROM Project.ORDERS O
   LEFT JOIN Project.CUSTOMERS C ON C.CUSTOMER_ID = O.CUSTOMER_ID;


