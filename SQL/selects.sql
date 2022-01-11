
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