CREATE SCHEMA Project;

CREATE TABLE Project.CUSTOMERS (
                CUSTOMER_ID INTEGER NOT NULL,
                CREDIT INTEGER NOT NULL,
                CONSTRAINT customers_pk PRIMARY KEY (CUSTOMER_ID)
);


CREATE TABLE Project.CONTACTS (
                CONTACT_ID INTEGER NOT NULL,
                CUSTOMER_ID INTEGER NOT NULL,
                FIRST_NAME VARCHAR NOT NULL,
                LAST_NAME VARCHAR NOT NULL,
                PHONE VARCHAR NOT NULL,
                ADDRESS VARCHAR NOT NULL,
                EMAIL VARCHAR NOT NULL,
                CONSTRAINT contacts_pk PRIMARY KEY (CONTACT_ID, CUSTOMER_ID)
);


CREATE TABLE Project.ORDERS (
                ORDER_ID INTEGER NOT NULL,
                CUSTOMER_ID INTEGER NOT NULL,
                NUMBER VARCHAR NOT NULL,
                DATE DATE NOT NULL,
                TOTAL_AMOUNT REAL NOT NULL,
                STATUS VARCHAR NOT NULL,
                CONSTRAINT orders_pk PRIMARY KEY (ORDER_ID)
);


CREATE TABLE Project.PRODUCT_CATEGORIES (
                CATEGORY_ID INTEGER NOT NULL,
                CATEGORY_NAME VARCHAR NOT NULL,
                CONSTRAINT product_categories_pk PRIMARY KEY (CATEGORY_ID)
);


CREATE TABLE Project.PRODUCTS (
                PRODUCT_ID INTEGER NOT NULL,
                CATEGORY_ID INTEGER NOT NULL,
                PRODUCT_NAME VARCHAR NOT NULL,
                DESCRIPTION VARCHAR NOT NULL,
                COST REAL NOT NULL,
                PRICE REAL NOT NULL,
                CONSTRAINT products_pk PRIMARY KEY (PRODUCT_ID)
);


CREATE TABLE Project.ORDER_ITEM (
                ITEM_ID INTEGER NOT NULL,
                ORDER_ID INTEGER NOT NULL,
                PRODUCT_ID INTEGER NOT NULL,
                QUANTITY INTEGER NOT NULL,
                CONSTRAINT order_item_pk PRIMARY KEY (ITEM_ID)
);


CREATE TABLE Project.LOCATIONS (
                LOCATION_ID INTEGER NOT NULL,
                ADDRESS VARCHAR NOT NULL,
                POSTAL_CODE VARCHAR NOT NULL,
                CITY VARCHAR NOT NULL,
                COUNTRY VARCHAR NOT NULL,
                CONSTRAINT locations_pk PRIMARY KEY (LOCATION_ID)
);


CREATE TABLE Project.EMPLOYEES (
                EMPLOYEE_ID INTEGER NOT NULL,
                FIRST_NAME VARCHAR NOT NULL,
                LAST_NAME VARCHAR NOT NULL,
                PHONE VARCHAR(12) NOT NULL,
                EMAIL VARCHAR NOT NULL,
                JOB_TITLE VARCHAR NOT NULL,
                CONSTRAINT employees_pk PRIMARY KEY (EMPLOYEE_ID)
);


CREATE TABLE Project.WAREHOUSES (
                WAREHOUSE_ID INTEGER NOT NULL,
                LOCATION_ID INTEGER NOT NULL,
                WAREHOUSE_NAME VARCHAR NOT NULL,
                CONSTRAINT warehouses_pk PRIMARY KEY (WAREHOUSE_ID)
);


CREATE TABLE Project.PRODUCTS_IN_WAREHOUSES (
                PRODUCT_ID INTEGER NOT NULL,
                WAREHOUSE_ID INTEGER NOT NULL,
                QUANTITY INTEGER NOT NULL,
                CONSTRAINT product_in_warehouses_pk PRIMARY KEY (PRODUCT_ID, WAREHOUSE_ID)
);


CREATE TABLE Project.EMPLOYEES_IN_WAREHOUSES (
                EMPLOYEE_ID INTEGER NOT NULL,
                WAREHOUSE_ID INTEGER NOT NULL,
                CONSTRAINT employees_in_warehouses_pk PRIMARY KEY (EMPLOYEE_ID, WAREHOUSE_ID)
);


ALTER TABLE Project.ORDERS ADD CONSTRAINT customers_orders_fk
FOREIGN KEY (CUSTOMER_ID)
REFERENCES Project.CUSTOMERS (CUSTOMER_ID)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE Project.CONTACTS ADD CONSTRAINT customers_contacts_fk
FOREIGN KEY (CUSTOMER_ID)
REFERENCES Project.CUSTOMERS (CUSTOMER_ID)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE Project.ORDER_ITEM ADD CONSTRAINT orders_order_item_fk
FOREIGN KEY (ORDER_ID)
REFERENCES Project.ORDERS (ORDER_ID)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE Project.PRODUCTS ADD CONSTRAINT products_category_products_fk
FOREIGN KEY (CATEGORY_ID)
REFERENCES Project.PRODUCT_CATEGORIES (CATEGORY_ID)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE Project.PRODUCTS_IN_WAREHOUSES ADD CONSTRAINT products_products_in_warehosues_fk
FOREIGN KEY (PRODUCT_ID)
REFERENCES Project.PRODUCTS (PRODUCT_ID)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE Project.ORDER_ITEM ADD CONSTRAINT products_order_item_fk
FOREIGN KEY (PRODUCT_ID)
REFERENCES Project.PRODUCTS (PRODUCT_ID)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE Project.WAREHOUSES ADD CONSTRAINT location_warehouses_fk
FOREIGN KEY (LOCATION_ID)
REFERENCES Project.LOCATIONS (LOCATION_ID)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE Project.EMPLOYEES_IN_WAREHOUSES ADD CONSTRAINT employee_employees_in_warehouses_fk
FOREIGN KEY (EMPLOYEE_ID)
REFERENCES Project.EMPLOYEES (EMPLOYEE_ID)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE Project.EMPLOYEES_IN_WAREHOUSES ADD CONSTRAINT warehouses_employees_in_warehouses_fk
FOREIGN KEY (WAREHOUSE_ID)
REFERENCES Project.WAREHOUSES (WAREHOUSE_ID)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE Project.PRODUCTS_IN_WAREHOUSES ADD CONSTRAINT warehouses_products_in_warehosues_fk
FOREIGN KEY (WAREHOUSE_ID)
REFERENCES Project.WAREHOUSES (WAREHOUSE_ID)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;