DROP TABLE IF EXISTS product;
CREATE TABLE IF NOT EXISTS product(id bigint bigserial NOT NULL, title varchar(255), price double, primary key (id));
INSERT INTO product (title, price) VALUES
    ('Картошка', 300),
    ('Мука', 450),
    ('Сахар', 600),
    ('Колбаса', 1300),
    ('Хлеб', 100),
    ('Морковь', 240),
    ('Лук', 740),
    ('Перец', 280);

DROP TABLE IF EXISTS customers CASCADE;
CREATE TABLE customers(id bigint bigserial NOT NULL, title varchar(255), primary key (id));
INSERT INTO customers(title) VALUES
    ('Azamat'),
    ('Serik'),
    ('Timur'),
    ('Ruslan'),
    ('Roza'),
    ('Svetlana'),
    ('Armat'),
    ('Yerlan');

DROP TABLE IF EXISTS user_products CASCADE;
CREATE TABLE user_products (product_id bigint NOT NULL, customer_id bigint NOT NULL, FOREIGN KEY (product_id) REFERENCES product (id), FOREIGN KEY (customer_id) REFERENCES customers (id));
INSERT INTO user_products (product_id, customer_id) VALUES
    (1, 4),
    (2, 6),
    (3, 4),
    (4, 6),
    (3, 2),
    (3, 4),
    (4, 6),
    (5, 7),
    (5, 8),
    (5, 3),
    (6, 3),
    (6, 6),
    (7, 7);