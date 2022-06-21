CREATE SCHEMA homework_3_demo;
USE homework_3_demo;

CREATE TABLE sales_rep(
id BIGINT NOT NULL AUTO_INCREMENT,
name VARCHAR(255),
PRIMARY KEY(id)
);
CREATE TABLE contact(
id BIGINT NOT NULL AUTO_INCREMENT,
PRIMARY KEY(id)
);
CREATE TABLE lead_table(
id BIGINT NOT NULL AUTO_INCREMENT,
name VARCHAR(255),
phone_number BIGINT,
email VARCHAR(255),
company_name VARCHAR(255),
PRIMARY KEY(id)
);
CREATE TABLE opportunity(
id BIGINT NOT NULL AUTO_INCREMENT,
product_enum VARCHAR(255),
quantity INT,
status_enum VARCHAR(255),
decision_maker_id BIGINT,
PRIMARY KEY(id),
FOREIGN KEY(decision_maker_id) REFERENCES contact(id)
);
CREATE TABLE account(
id BIGINT NOT NULL AUTO_INCREMENT,
industry_enum VARCHAR(255),
employee_account INT,
city VARCHAR(255),
country VARCHAR(255),
PRIMARY KEY(id)
);