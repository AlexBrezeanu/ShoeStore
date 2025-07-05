DROP table if exists product;
DROP table if exists category;

CREATE TABLE if not exists category (
id Serial primary key,
name VARCHAR(100));





CREATE TABLE if not exists product (
id Serial primary key,
category_id INTEGER,
name VARCHAR(100),
colour VARCHAR(100),
_size INTEGER,
price NUMERIC(10,2),
FOREIGN KEY (category_id) REFERENCES category(id));
