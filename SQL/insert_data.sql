CREATE SCHEMA Project;

----------------------------------------------------------------------------------------------------
--------------------------------- INSERTS-----------------------------------------------------------
-----------------------------------------------------------------------------------------------------

-- users
INSERT INTO Project.USERS(USER_ID, LOGIN, PASSWORD) VALUES (1, 'root', 'root');

INSERT INTO Project.USERS(USER_ID, LOGIN, PASSWORD) VALUES (2, 'LOGIN_1', 'PASSWORD_1');
INSERT INTO Project.USERS(USER_ID, LOGIN, PASSWORD) VALUES (3, 'LOGIN_2', 'PASSWORD_2');
INSERT INTO Project.USERS(USER_ID, LOGIN, PASSWORD) VALUES (4, 'LOGIN_3', 'PASSWORD_3');
INSERT INTO Project.USERS(USER_ID, LOGIN, PASSWORD) VALUES (5, 'LOGIN_4', 'PASSWORD_4');
INSERT INTO Project.USERS(USER_ID, LOGIN, PASSWORD) VALUES (6, 'LOGIN_5', 'PASSWORD_5');
INSERT INTO Project.USERS(USER_ID, LOGIN, PASSWORD) VALUES (7, 'LOGIN_6', 'PASSWORD_6');

-- inserting location
INSERT INTO Project.LOCATIONS(LOCATION_ID, ADDRESS, POSTAL_CODE, CITY, COUNTRY) VALUES(1, 'ul. Żurawia 123', '26-026', 'MORAWICA', 'Polska');
INSERT INTO Project.LOCATIONS(LOCATION_ID, ADDRESS, POSTAL_CODE, CITY, COUNTRY) VALUES(2, 'ul. Dynarska 29', '01-493', 'Warszawa' , 'Polska');
INSERT INTO Project.LOCATIONS(LOCATION_ID, ADDRESS, POSTAL_CODE, CITY, COUNTRY) VALUES(3, 'ul. Solna 110', '61-735', 'Poznań', 'Polska');
INSERT INTO Project.LOCATIONS(LOCATION_ID, ADDRESS, POSTAL_CODE, CITY, COUNTRY) VALUES(4, 'ul. Zgierska 143', '91-001', 'Łódź', 'Polska');
INSERT INTO Project.LOCATIONS(LOCATION_ID, ADDRESS, POSTAL_CODE, CITY, COUNTRY) VALUES(5, 'ul. Mostowa 108', '42-400', 'Zawiercie', 'Polska');
INSERT INTO Project.LOCATIONS(LOCATION_ID, ADDRESS, POSTAL_CODE, CITY, COUNTRY) VALUES(6, 'ul. Śląska 102', '81-315', 'Gdynia', 'Polska');

-- inserting warehouse
INSERT INTO Project.WAREHOUSES(WAREHOUSE_ID, USER_ID, LOCATION_ID, WAREHOUSE_NAME) VALUES(1, 1, 1, 'Filar');
INSERT INTO Project.WAREHOUSES(WAREHOUSE_ID, USER_ID, LOCATION_ID, WAREHOUSE_NAME) VALUES(2, 2,2,'Alfa');
INSERT INTO Project.WAREHOUSES(WAREHOUSE_ID, USER_ID, LOCATION_ID, WAREHOUSE_NAME) VALUES(3, 3,3,'Beta');
INSERT INTO Project.WAREHOUSES(WAREHOUSE_ID, USER_ID, LOCATION_ID, WAREHOUSE_NAME) VALUES(4, 4,4,'Gamma');
INSERT INTO Project.WAREHOUSES(WAREHOUSE_ID, USER_ID, LOCATION_ID, WAREHOUSE_NAME) VALUES(5, 5,5,'Delta');
INSERT INTO Project.WAREHOUSES(WAREHOUSE_ID, USER_ID, LOCATION_ID, WAREHOUSE_NAME) VALUES(6, 6,6,'Epsilon');

-- inserting employee
INSERT INTO Project.EMPLOYEES(EMPLOYEE_ID, FIRST_NAME, LAST_NAME, PHONE, EMAIL, JOB_TITLE) VALUES(1,'Maciej', 'Nowak', '733-123-123', 'maciej.nowak@temp.pl', 'kierowca');
INSERT INTO Project.EMPLOYEES(EMPLOYEE_ID, FIRST_NAME, LAST_NAME, PHONE, EMAIL, JOB_TITLE) VALUES(2,'Karol', 'Babacki', '733-111-123', 'karol.babacki@temp.pl', 'kierowca');
INSERT INTO Project.EMPLOYEES(EMPLOYEE_ID, FIRST_NAME, LAST_NAME, PHONE, EMAIL, JOB_TITLE) VALUES(3,'Dawid', 'Krakus', '713-113-123', 'dawid.krakus@temp.pl', 'magazynier');
INSERT INTO Project.EMPLOYEES(EMPLOYEE_ID, FIRST_NAME, LAST_NAME, PHONE, EMAIL, JOB_TITLE) VALUES(4,'Jan', 'Szwed', '713-293-213', 'jan.szwed@temp.pl', 'magazynier');
INSERT INTO Project.EMPLOYEES(EMPLOYEE_ID, FIRST_NAME, LAST_NAME, PHONE, EMAIL, JOB_TITLE) VALUES(5,'Kuba', 'Kolanko', '713-143-123', 'kuba.kolanko@temp.pl', 'księgowy');


-- inserting employees_in_warehouses
INSERT INTO Project.EMPLOYEES_IN_WAREHOUSES(WAREHOUSE_ID, EMPLOYEE_ID) VALUES(1,1);
INSERT INTO Project.EMPLOYEES_IN_WAREHOUSES(WAREHOUSE_ID, EMPLOYEE_ID) VALUES(2,2);
INSERT INTO Project.EMPLOYEES_IN_WAREHOUSES(WAREHOUSE_ID, EMPLOYEE_ID) VALUES(3,3);
INSERT INTO Project.EMPLOYEES_IN_WAREHOUSES(WAREHOUSE_ID, EMPLOYEE_ID) VALUES(4,4);
INSERT INTO Project.EMPLOYEES_IN_WAREHOUSES(WAREHOUSE_ID, EMPLOYEE_ID) VALUES(5,5);
INSERT INTO Project.EMPLOYEES_IN_WAREHOUSES(WAREHOUSE_ID, EMPLOYEE_ID) VALUES(6,6);

-- inserting product_categories
INSERT INTO Project.PRODUCT_CATEGORIES(CATEGORY_ID, CATEGORY_NAME) VALUES (1, 'WELNA');
INSERT INTO Project.PRODUCT_CATEGORIES(CATEGORY_ID, CATEGORY_NAME) VALUES (2, 'GWOZDZIE');
INSERT INTO Project.PRODUCT_CATEGORIES(CATEGORY_ID, CATEGORY_NAME) VALUES (3, 'CEMENT');
INSERT INTO Project.PRODUCT_CATEGORIES(CATEGORY_ID, CATEGORY_NAME) VALUES (4, 'BLOCZEK KOMORKOWY');
INSERT INTO Project.PRODUCT_CATEGORIES(CATEGORY_ID, CATEGORY_NAME) VALUES (5, 'STYRODUR');

-- inserting products

INSERT INTO Project.PRODUCTS(PRODUCT_ID, CATEGORY_ID, PRODUCT_NAME, DESCRIPTION, COST, PRICE) VALUES(1,1, 'WELNA ROCKWOOL 12CM', 'WELNA SKALNA', 25.25, 30.00);
INSERT INTO Project.PRODUCTS(PRODUCT_ID, CATEGORY_ID, PRODUCT_NAME, DESCRIPTION, COST, PRICE) VALUES(2,1, 'WELNA ROCKWOOL 15CM','WELNA SKALNA', 30.25, 35.00);
INSERT INTO Project.PRODUCTS(PRODUCT_ID, CATEGORY_ID, PRODUCT_NAME, DESCRIPTION, COST, PRICE) VALUES(3,1, 'WELNA ROCKWOOL 16CM','WELNA SKALNA', 35.25, 40.00);
INSERT INTO Project.PRODUCTS(PRODUCT_ID, CATEGORY_ID, PRODUCT_NAME, DESCRIPTION, COST, PRICE) VALUES(4,1, 'WELNA ROCKWOOL 20CM','WELNA SKALNA', 40.25, 45.00);
INSERT INTO Project.PRODUCTS(PRODUCT_ID, CATEGORY_ID, PRODUCT_NAME, DESCRIPTION, COST, PRICE) VALUES(5,1, 'WELNA ROCKWOOL 22CM','WELNA SKALNA', 41.25, 50.00);
INSERT INTO Project.PRODUCTS(PRODUCT_ID, CATEGORY_ID, PRODUCT_NAME, DESCRIPTION, COST, PRICE) VALUES(6,1, 'WELNA ROCKWOOL 30CM','WELNA SKALNA', 44.25, 55.00);
INSERT INTO Project.PRODUCTS(PRODUCT_ID, CATEGORY_ID, PRODUCT_NAME, DESCRIPTION, COST, PRICE) VALUES(7,1, 'WELNA ROCKWOOL 35CM','WELNA SKALNA', 47.25, 60.00);

INSERT INTO Project.PRODUCTS(PRODUCT_ID, CATEGORY_ID, PRODUCT_NAME, DESCRIPTION, COST, PRICE) VALUES(8,2, 'GWOZDZIE 5CM', 'STOLARSKIE', 25.25, 30.55);
INSERT INTO Project.PRODUCTS(PRODUCT_ID, CATEGORY_ID, PRODUCT_NAME, DESCRIPTION, COST, PRICE) VALUES(9,2, 'GWOZDZIE 10CM', 'STOLARSKIE', 30.25, 35.55);
INSERT INTO Project.PRODUCTS(PRODUCT_ID, CATEGORY_ID, PRODUCT_NAME, DESCRIPTION, COST, PRICE) VALUES(10,2, 'GWOZDZIE 15CM', 'STOLARSKIE', 35.25, 40.55);
INSERT INTO Project.PRODUCTS(PRODUCT_ID, CATEGORY_ID, PRODUCT_NAME, DESCRIPTION, COST, PRICE) VALUES(11,2, 'GWOZDZIE 20CM', 'STOLARSKIE', 40.25, 45.55);
INSERT INTO Project.PRODUCTS(PRODUCT_ID, CATEGORY_ID, PRODUCT_NAME, DESCRIPTION, COST, PRICE) VALUES(12,2, 'GWOZDZIE 25CM', 'STOLARSKIE', 41.25, 50.55);
INSERT INTO Project.PRODUCTS(PRODUCT_ID, CATEGORY_ID, PRODUCT_NAME, DESCRIPTION, COST, PRICE) VALUES(13,2, 'GWOZDZIE 30CM', 'STOLARSKIE', 44.25, 55.55);
INSERT INTO Project.PRODUCTS(PRODUCT_ID, CATEGORY_ID, PRODUCT_NAME, DESCRIPTION, COST, PRICE) VALUES(14,2, 'GWOZDZIE 35CM', 'STOLARSKIE', 47.25, 60.55);


INSERT INTO Project.PRODUCTS(PRODUCT_ID, CATEGORY_ID, PRODUCT_NAME, DESCRIPTION, COST, PRICE) VALUES(15,3, 'CEMENT', 'CZARNY', 10.25, 10.10);
INSERT INTO Project.PRODUCTS(PRODUCT_ID, CATEGORY_ID, PRODUCT_NAME, DESCRIPTION, COST, PRICE) VALUES(16,3, 'CEMENT', 'CZERWONY', 20.25, 25.55);

INSERT INTO Project.PRODUCTS(PRODUCT_ID, CATEGORY_ID, PRODUCT_NAME, DESCRIPTION, COST, PRICE) VALUES(17,4, 'H+H 12CM', 'CZARNY', 10.25, 10.99);
INSERT INTO Project.PRODUCTS(PRODUCT_ID, CATEGORY_ID, PRODUCT_NAME, DESCRIPTION, COST, PRICE) VALUES(18,4, 'H+H 16CM', 'CZERWONY', 20.25, 30.55);
INSERT INTO Project.PRODUCTS(PRODUCT_ID, CATEGORY_ID, PRODUCT_NAME, DESCRIPTION, COST, PRICE) VALUES(19,4, 'H+H 18CM', 'CZERWONY', 23.25, 29.55);

INSERT INTO Project.PRODUCTS(PRODUCT_ID, CATEGORY_ID, PRODUCT_NAME, DESCRIPTION, COST, PRICE) VALUES(20,5, 'STYRODUR XPS 5CM', 'WODOODPORNY', 10.25, 10.10);
INSERT INTO Project.PRODUCTS(PRODUCT_ID, CATEGORY_ID, PRODUCT_NAME, DESCRIPTION, COST, PRICE) VALUES(21,5, 'STYRODUR XPS 5CM', 'WODOODPORNY', 22.25, 25.55);

-- inserting products_in_warehouses 1
INSERT INTO Project.PRODUCTS_IN_WAREHOUSES(WAREHOUSE_ID, PRODUCT_ID, QUANTITY) VALUES(1,1,500);
INSERT INTO Project.PRODUCTS_IN_WAREHOUSES(WAREHOUSE_ID, PRODUCT_ID, QUANTITY) VALUES(1,2,600);
INSERT INTO Project.PRODUCTS_IN_WAREHOUSES(WAREHOUSE_ID, PRODUCT_ID, QUANTITY) VALUES(1,3,500);
INSERT INTO Project.PRODUCTS_IN_WAREHOUSES(WAREHOUSE_ID, PRODUCT_ID, QUANTITY) VALUES(1,4,1200);
INSERT INTO Project.PRODUCTS_IN_WAREHOUSES(WAREHOUSE_ID, PRODUCT_ID, QUANTITY) VALUES(1,5,300);

-- inserting products_in_warehouses 2
INSERT INTO Project.PRODUCTS_IN_WAREHOUSES(WAREHOUSE_ID, PRODUCT_ID, QUANTITY) VALUES(2,6,500);
INSERT INTO Project.PRODUCTS_IN_WAREHOUSES(WAREHOUSE_ID, PRODUCT_ID, QUANTITY) VALUES(2,3,60420);
INSERT INTO Project.PRODUCTS_IN_WAREHOUSES(WAREHOUSE_ID, PRODUCT_ID, QUANTITY) VALUES(2,12,51300);
INSERT INTO Project.PRODUCTS_IN_WAREHOUSES(WAREHOUSE_ID, PRODUCT_ID, QUANTITY) VALUES(2,5,1200);
INSERT INTO Project.PRODUCTS_IN_WAREHOUSES(WAREHOUSE_ID, PRODUCT_ID, QUANTITY) VALUES(2,18,30140);

-- inserting products_in_warehouses 3
INSERT INTO Project.PRODUCTS_IN_WAREHOUSES(WAREHOUSE_ID, PRODUCT_ID, QUANTITY) VALUES(3,1,531200);
INSERT INTO Project.PRODUCTS_IN_WAREHOUSES(WAREHOUSE_ID, PRODUCT_ID, QUANTITY) VALUES(3,12,60420);
INSERT INTO Project.PRODUCTS_IN_WAREHOUSES(WAREHOUSE_ID, PRODUCT_ID, QUANTITY) VALUES(3,14,50310);
INSERT INTO Project.PRODUCTS_IN_WAREHOUSES(WAREHOUSE_ID, PRODUCT_ID, QUANTITY) VALUES(3,4,121300);
INSERT INTO Project.PRODUCTS_IN_WAREHOUSES(WAREHOUSE_ID, PRODUCT_ID, QUANTITY) VALUES(3,1,30140);

-- inserting products_in_warehouses 4
INSERT INTO Project.PRODUCTS_IN_WAREHOUSES(WAREHOUSE_ID, PRODUCT_ID, QUANTITY) VALUES(4,1,5200);
INSERT INTO Project.PRODUCTS_IN_WAREHOUSES(WAREHOUSE_ID, PRODUCT_ID, QUANTITY) VALUES(4,2,642410);

-- inserting products_in_warehouses 5
INSERT INTO Project.PRODUCTS_IN_WAREHOUSES(WAREHOUSE_ID, PRODUCT_ID, QUANTITY) VALUES(5,13,52020);
INSERT INTO Project.PRODUCTS_IN_WAREHOUSES(WAREHOUSE_ID, PRODUCT_ID, QUANTITY) VALUES(5,1,52100);
INSERT INTO Project.PRODUCTS_IN_WAREHOUSES(WAREHOUSE_ID, PRODUCT_ID, QUANTITY) VALUES(5,14,521300);
INSERT INTO Project.PRODUCTS_IN_WAREHOUSES(WAREHOUSE_ID, PRODUCT_ID, QUANTITY) VALUES(5,6,64420);

-- inserting products_in_warehouses 6
INSERT INTO Project.PRODUCTS_IN_WAREHOUSES(WAREHOUSE_ID, PRODUCT_ID, QUANTITY) VALUES(6,3,5200);
INSERT INTO Project.PRODUCTS_IN_WAREHOUSES(WAREHOUSE_ID, PRODUCT_ID, QUANTITY) VALUES(6,1,2100);
INSERT INTO Project.PRODUCTS_IN_WAREHOUSES(WAREHOUSE_ID, PRODUCT_ID, QUANTITY) VALUES(6,4,52300);
INSERT INTO Project.PRODUCTS_IN_WAREHOUSES(WAREHOUSE_ID, PRODUCT_ID, QUANTITY) VALUES(6,6,6440);

-- inserting customer
INSERT INTO Project.CUSTOMERS(CUSTOMER_ID,  CREDIT) VALUES (1, 7000.00);
INSERT INTO Project.CUSTOMERS(CUSTOMER_ID,  CREDIT) VALUES (2, 4000.00);
INSERT INTO Project.CUSTOMERS(CUSTOMER_ID,  CREDIT) VALUES (3, 123000.00);
INSERT INTO Project.CUSTOMERS(CUSTOMER_ID,  CREDIT) VALUES (4, 741200.00);
INSERT INTO Project.CUSTOMERS(CUSTOMER_ID,  CREDIT) VALUES (5, 7200.00);
INSERT INTO Project.CUSTOMERS(CUSTOMER_ID,  CREDIT) VALUES (6, 41200.00);
INSERT INTO Project.CUSTOMERS(CUSTOMER_ID,  CREDIT) VALUES (7, 4100.00);
INSERT INTO Project.CUSTOMERS(CUSTOMER_ID,  CREDIT) VALUES (8, 740.00);


-- inserting contact
INSERT INTO Project.CONTACTS(CONTACT_ID, CUSTOMER_ID, FIRST_NAME, LAST_NAME, PHONE, ADDRESS, EMAIL) VALUES (1, 1, 'Karol' , 'Nowy', '733-879-325', 'ul. Profesora Paszkowskiego Wacława 26 02-507 Warszawa', 'karol.nowy@temp.pl');
INSERT INTO Project.CONTACTS(CONTACT_ID, CUSTOMER_ID, FIRST_NAME, LAST_NAME, PHONE, ADDRESS, EMAIL) VALUES (2, 2, 'Paweł' , 'Stanley', '732-879-325', 'LEA 114a', 'TEMP@TEMP.PL');
INSERT INTO Project.CONTACTS(CONTACT_ID, CUSTOMER_ID, FIRST_NAME, LAST_NAME, PHONE, ADDRESS, EMAIL) VALUES (3, 3, 'Marek' , 'Kokorajko', '733-879-325', 'LEA 114a', 'TEMP@TEMP.PL');
INSERT INTO Project.CONTACTS(CONTACT_ID, CUSTOMER_ID, FIRST_NAME, LAST_NAME, PHONE, ADDRESS, EMAIL) VALUES (4, 4, 'Robert' , 'Szajko', '734-879-325', 'LEA 114a', 'TEMP@TEMP.PL');
INSERT INTO Project.CONTACTS(CONTACT_ID, CUSTOMER_ID, FIRST_NAME, LAST_NAME, PHONE, ADDRESS, EMAIL) VALUES (5, 5, 'Stanisław' , 'Patrek', '123-879-325', 'LEA 114a', 'TEMP@TEMP.PL');
INSERT INTO Project.CONTACTS(CONTACT_ID, CUSTOMER_ID, FIRST_NAME, LAST_NAME, PHONE, ADDRESS, EMAIL) VALUES (6, 6, 'Karol' , 'Kundera', '733-873-325', 'LEA 114a', 'TEMP@TEMP.PL');
INSERT INTO Project.CONTACTS(CONTACT_ID, CUSTOMER_ID, FIRST_NAME, LAST_NAME, PHONE, ADDRESS, EMAIL) VALUES (7, 7, 'Paweł' , 'Noga', '741-879-415', 'LEA 114a', 'TEMP@TEMP.PL');
INSERT INTO Project.CONTACTS(CONTACT_ID, CUSTOMER_ID, FIRST_NAME, LAST_NAME, PHONE, ADDRESS, EMAIL) VALUES (8, 8, 'Ewa' , 'Kowal', '732-329-325', 'LEA 114a', 'TEMP@TEMP.PL');


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

