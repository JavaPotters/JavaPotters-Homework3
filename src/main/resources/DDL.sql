DROP SCHEMA IF EXISTS homework_3_demo;
CREATE SCHEMA homework_3_demo;
USE homework_3_demo;

DROP SCHEMA IF EXISTS homework_3_demo_test;
CREATE SCHEMA homework_3_demo_test;
USE homework_3_demo_test;

DROP TABLE IF EXISTS sales_rep;
CREATE TABLE sales_rep(
id INT NOT NULL AUTO_INCREMENT,
name VARCHAR(255),
PRIMARY KEY(id)
);

DROP TABLE IF EXISTS contact;
CREATE TABLE contact(
id INT NOT NULL AUTO_INCREMENT,
PRIMARY KEY(id)
);

DROP TABLE IF EXISTS lead_table;
CREATE TABLE lead_table(
id INT NOT NULL AUTO_INCREMENT,
name VARCHAR(255),
phone_number BIGINT,
email VARCHAR(255),
company_name VARCHAR(255),
PRIMARY KEY(id)
);

DROP TABLE IF EXISTS opportunity;
CREATE TABLE opportunity(
id INT NOT NULL AUTO_INCREMENT,
product_enum VARCHAR(255),
quantity INT,
status_enum VARCHAR(255),
decision_maker_id INT,
PRIMARY KEY(id),
FOREIGN KEY(decision_maker_id) REFERENCES contact(id)
);

DROP TABLE IF EXISTS account;
CREATE TABLE account(
id INT NOT NULL AUTO_INCREMENT,
company_name VARCHAR(255),
industry_enum VARCHAR(255),
employee_account INT,
city VARCHAR(255),
country VARCHAR(255),
PRIMARY KEY(id)
);

INSERT INTO sales_rep (name) VALUES
('Sofia'),
('Laura'),
('Ana'),
('Rocio');
INSERT INTO lead_table (name, phone_number, email, company_name) VALUES
('Carlos', 660142356, 'carlos@email.com', 'Desatranques Jaen'),
('Mike', 634477579, 'mike@email.com', 'Tiempost'),
('Paco', 657897458, 'paco@email.com', 'Seur');
INSERT INTO opportunity (product_enum, quantity, status_enum) VALUES
('BOX', 20, 'OPEN'),
('HYBRID', 10, 'OPEN'),
('FLATBED', 15, 'OPEN');
INSERT INTO account (company_name, industry_enum, employee_account, city, country) VALUES
('Desatranques Jaen', 'OTHER', '50', 'Jaen', 'Spain'),
('Tiempost', 'OTHER', '205', 'Montevideo', 'Uruguay'),
('Seur', 'OTHER', '500', 'Madrid', 'Spain');