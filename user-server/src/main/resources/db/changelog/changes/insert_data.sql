insert into roles (role)
values
    ('ADMIN'),
    ('USER');


insert into users(email, user_status, role ,room, social_media, phone, first_name, last_name, password, username)
values
    ('admin@gmail.com','ACTIVE', 1,1, 'vk.com/admin', '89123456789', 'admin', 'admin','$2a$10$2MIyJH.1was2rThai9t2Huyisdw/WMtbJyAyEgkUVnfi5N2BVZIT6', 'admin'),
    ('kirill@gmail.com','ACTIVE', 2,1, 'vk.com/kirill', '89123456999', 'kirill', 'kirill','$2a$10$2MIyJH.1was2rThai9t2Huyisdw/WMtbJyAyEgkUVnfi5N2BVZIT6', 'kirill');

insert into categories (name, short_name)
values
    ('Салаты', 'Салаты'),
    ('Паста', 'Паста'),
    ('Рыба и морепродукты', 'Рыба и морепродукты'),
    ('Мясо и птица', 'Мясо и птица'),
    ('Вегетарианское', 'Вегетарианское'),
    ('Пицца', 'Пицца'),
    ('Сэндвичи', 'Сэндвичи'),
    ('Закуски', 'Закуски'),
    ('Десерты', 'Десерты'),
    ('Напитки', 'Напитки'),
    ('Завтраки', 'Завтраки'),
    ('Гарниры', 'Гарниры'),
    ('Разное', 'Разное');

INSERT INTO attachments (base64, create_date, type)
VALUES
    ('base64_2', '2022-01-02', 'PHOTO'),
    ('base64_3', '2022-01-03', 'PHOTO'),
    ('base64_4', '2022-01-04', 'PHOTO'),
    ('base64_5', '2022-01-05', 'PHOTO'),
    ('base64_6', '2022-01-06', 'PHOTO'),
    ('base64_7', '2022-01-07', 'PHOTO'),
    ('base64_8', '2022-01-08', 'PHOTO'),
    ('base64_9', '2022-01-09', 'PHOTO'),
    ('base64_10', '2022-01-10', 'PHOTO'),
    ('base64_11', '2022-01-11', 'PHOTO'),
    ('base64_12', '2022-01-12', 'PHOTO'),
    ('base64_13', '2022-01-13', 'PHOTO'),
    ('base64_14', '2022-01-14', 'PHOTO'),
    ('base64_15', '2022-01-15', 'PHOTO'),
    ('base64_16', '2022-01-16', 'PHOTO'),
    ('base64_17', '2022-01-17', 'PHOTO'),
    ('base64_18', '2022-01-18', 'PHOTO'),
    ('base64_19', '2022-01-19', 'PHOTO'),
    ('base64_20', '2022-01-20', 'PHOTO'),
    ('base64_21', '2022-01-21', 'PHOTO'),
    ('base64_22', '2022-01-22', 'PHOTO'),
    ('base64_23', '2022-01-23', 'PHOTO'),
    ('base64_24', '2022-01-24', 'PHOTO'),
    ('base64_25', '2022-01-25', 'PHOTO'),
    ('base64_26', '2022-01-26', 'PHOTO'),
    ('base64_27', '2022-01-27', 'PHOTO'),
    ('base64_28', '2022-01-28', 'PHOTO'),
    ('base64_29', '2022-01-29', 'PHOTO'),
    ('base64_30', '2022-01-30', 'PHOTO');

-- --
INSERT INTO payments (create_date, description, status, amount) VALUES
                                                                    ('2022-01-03', 'Payment 3', 1, 150),
                                                                    ('2022-01-04', 'Payment 4', 1, 300),
                                                                    ('2022-01-05', 'Payment 5', 1, 250),
                                                                    ('2022-01-06', 'Payment 6', 1, 400),
                                                                    ('2022-01-07', 'Payment 7', 1, 180),
                                                                    ('2022-01-08', 'Payment 8', 1, 220),
                                                                    ('2022-01-09', 'Payment 9', 1, 350),
                                                                    ('2022-01-10', 'Payment 10', 1, 280),
                                                                    ('2022-01-11', 'Payment 11', 1, 150),
                                                                    ('2022-01-12', 'Payment 12', 1, 200),
                                                                    ('2022-01-13', 'Payment 13', 1, 300),
                                                                    ('2022-01-14', 'Payment 14', 1, 250),
                                                                    ('2022-01-15', 'Payment 15', 1, 400),
                                                                    ('2022-01-16', 'Payment 16', 1, 180),
                                                                    ('2022-01-17', 'Payment 17', 1, 220),
                                                                    ('2022-01-18', 'Payment 18', 1, 350),
                                                                    ('2022-01-19', 'Payment 19', 1, 280),
                                                                    ('2022-01-20', 'Payment 20', 1, 150),
                                                                    ('2022-01-21', 'Payment 21', 1, 200),
                                                                    ('2022-01-22', 'Payment 22', 1, 300),
                                                                    ('2022-01-23', 'Payment 23', 1, 250),
                                                                    ('2022-01-24', 'Payment 24', 1, 400),
                                                                    ('2022-01-25', 'Payment 25', 1, 180),
                                                                    ('2022-01-26', 'Payment 26', 1, 220),
                                                                    ('2022-01-27', 'Payment 27', 1, 350),
                                                                    ('2022-01-28', 'Payment 28', 1, 280),
                                                                    ('2022-01-29', 'Payment 29', 1, 150),
                                                                    ('2022-01-30', 'Payment 30', 1, 200),
                                                                    ('2022-01-31', 'Payment 31', 1, 300),
                                                                    ('2022-02-01', 'Payment 32', 1, 250),
                                                                    ('2022-02-02', 'Payment 33', 1, 400),
                                                                    ('2022-02-03', 'Payment 34', 1, 180),
                                                                    ('2022-02-04', 'Payment 35', 1, 220),
                                                                    ('2022-02-05', 'Payment 36', 1, 350),
                                                                    ('2022-02-06', 'Payment 37', 1, 280),
                                                                    ('2022-02-07', 'Payment 38', 1, 150),
                                                                    ('2022-02-08', 'Payment 39', 1, 200),
                                                                    ('2022-02-09', 'Payment 40', 1, 300),
                                                                    ('2022-02-10', 'Payment 41', 1, 250),
                                                                    ('2022-02-11', 'Payment 42', 1, 400),
                                                                    ('2022-02-12', 'Payment 43', 1, 180),
                                                                    ('2022-02-13', 'Payment 44', 1, 220),
                                                                    ('2022-02-14', 'Payment 45', 1, 350),
                                                                    ('2022-02-15', 'Payment 46', 1, 280),
                                                                    ('2022-02-16', 'Payment 47', 1, 150),
                                                                    ('2022-02-17', 'Payment 48', 1, 200),
                                                                    ('2022-02-18', 'Payment 49', 1, 300),
                                                                    ('2022-02-19', 'Payment 50', 1, 250),
                                                                    ('2022-02-20','Payment 51', 1, 400),
                                                                    ('2022-02-21','Payment 52', 1, 180),
                                                                    ('2022-02-22', 'Payment 53', 1, 220),
                                                                    ('2022-02-23', 'Payment 54', 1, 350),
                                                                    ('2022-02-24', 'Payment 55', 1, 280),
                                                                    ('2022-02-25', 'Payment 56', 1, 150),
                                                                    ('2022-02-26', 'Payment 57', 1, 200),
                                                                    ('2022-02-27', 'Payment 58', 1, 300),
                                                                    ('2022-02-28', 'Payment 59', 1, 250),
                                                                    ('2022-03-01', 'Payment 60', 1, 400),
                                                                    ('2022-03-02', 'Payment 61', 1, 180),
                                                                    ('2022-03-03', 'Payment 62', 1, 220),
                                                                    ('2022-03-04', 'Payment 63', 1, 350),
                                                                    ('2022-03-05', 'Payment 64', 1, 280),
                                                                    ('2022-03-06', 'Payment 65', 1, 150),
                                                                    ('2022-03-07', 'Payment 66', 1, 200),
                                                                    ('2022-03-08', 'Payment 67', 1, 300),
                                                                    ('2022-03-09', 'Payment 68', 1, 250),
                                                                    ('2022-03-10', 'Payment 69', 1, 400),
                                                                    ('2022-03-11', 'Payment 70', 1, 180);

INSERT INTO users (user_status, role, email, room, social_media, phone, first_name, last_name, password, username)
VALUES
    ('ACTIVE', 2, 'email2@example.com', 124, 'social_media2', '1234567892', 'Alice', 'Smith', 'password2', 'alice.smith2'),
    ('ACTIVE', 2, 'email3@example.com', 125, 'social_media3', '1234567893', 'Bob', 'Johnson', 'password3', 'bob.johnson3'),
    ('ACTIVE', 2, 'email4@example.com', 126, 'social_media4', '1234567894', 'Emma', 'Davis', 'password4', 'emma.davis4'),
    ('ACTIVE', 2, 'email5@example.com', 127, 'social_media5', '1234567895', 'Michael', 'Wilson', 'password5', 'michael.wilson5'),
    ('ACTIVE', 2, 'email6@example.com', 128, 'social_media6', '1234567896', 'Olivia', 'Brown', 'password6', 'olivia.brown6'),
    ('ACTIVE', 2, 'email7@example.com', 129, 'social_media7', '1234567897', 'William', 'Taylor', 'password7', 'william.taylor7'),
    ('ACTIVE', 2, 'email8@example.com', 130, 'social_media8', '1234567898', 'Sophia', 'Jones', 'password8', 'sophia.jones8'),
    ('ACTIVE', 2, 'email9@example.com', 131, 'social_media9', '1234567899', 'James', 'Anderson', 'password9', 'james.anderson9'),
    ('ACTIVE', 2, 'email10@example.com', 132, 'social_media10', '1234567890', 'Isabella', 'Lee', 'password10', 'isabella.lee10'),
    ('ACTIVE', 2, 'email11@example.com', 133, 'social_media11', '1234567891', 'Benjamin', 'Clark', 'password11', 'benjamin.clark11'),
    ('ACTIVE', 2, 'email12@example.com', 134, 'social_media12', '1234567892', 'Sophia', 'Hall', 'password12', 'sophia.hall12'),
    ('ACTIVE', 2, 'email13@example.com', 135, 'social_media13', '1234567893', 'Oliver', 'Harris', 'password13', 'oliver.harris13'),
    ('ACTIVE', 2, 'email14@example.com', 136, 'social_media14', '1234567894', 'Amelia', 'Martin', 'password14', 'amelia.martin14'),
    ('ACTIVE', 2, 'email15@example.com', 137, 'social_media15', '1234567895', 'Lucas', 'Moore', 'password15', 'lucas.moore15'),
    ('ACTIVE', 2, 'email16@example.com', 138, 'social_media16', '1234567896', 'Mia', 'Jackson', 'password16', 'mia.jackson16'),
    ('ACTIVE', 2, 'email17@example.com', 139, 'social_media17', '1234567897', 'Henry', 'White', 'password17', 'henry.white17'),
    ('ACTIVE', 2, 'email18@example.com', 140, 'social_media18', '1234567898', 'Evelyn', 'Turner', 'password18', 'evelyn.turner18'),
    ('ACTIVE', 2, 'email19@example.com', 141, 'social_media19', '1234567899', 'Alexander', 'Scott', 'password19', 'alexander.scott19'),
    ('ACTIVE', 2, 'email20@example.com', 142, 'social_media20', '1234567890', 'Charlotte', 'Walker', 'password20', 'charlotte.walker20'),
    ('ACTIVE', 2, 'email21@example.com', 143, 'social_media21', '1234567891', 'Daniel', 'Wright', 'password21', 'daniel.wright21'),
    ('ACTIVE', 2, 'email22@example.com', 144, 'social_media22', '1234567892', 'Scarlett', 'Robinson', 'password22', 'scarlett.robinson22'),
    ('ACTIVE', 2, 'email23@example.com', 145, 'social_media23', '1234567893', 'Matthew', 'Cooper', 'password23', 'matthew.cooper23'),
    ('ACTIVE', 2, 'email24@example.com', 146, 'social_media24', '1234567894', 'Ava', 'King', 'password24', 'ava.king24'),
    ('ACTIVE', 2, 'email25@example.com', 147, 'social_media25', '1234567895', 'David', 'Adams', 'password25', 'david.adams25'),
    ('ACTIVE', 2, 'email26@example.com', 148, 'social_media26', '1234567896', 'Grace', 'Parker', 'password26', 'grace.parker26'),
    ('ACTIVE', 2, 'email27@example.com', 149, 'social_media27', '1234567897', 'Joseph', 'Evans', 'password27', 'joseph.evans27'),
    ('ACTIVE', 2, 'email28@example.com', 150, 'social_media28', '1234567898', 'Lily', 'Morris', 'password28', 'lily.morris28'),
    ('ACTIVE', 2, 'email29@example.com', 151, 'social_media29', '1234567899', 'Daniel', 'Bell', 'password29', 'daniel.bell29'),
    ('ACTIVE', 2, 'email30@example.com', 152, 'social_media30', '1234567890', 'Emily', 'Cook', 'password30', 'emily.cook30');


INSERT INTO products (description, category_id, user_id, name, price)
VALUES
    ('Description 3', 3, 2, 'Product 3', 30),
    ('Description 4', 4, 2, 'Product 4', 40),
    ('Description 5', 5, 2, 'Product 5', 50),
    ('Description 6', 6, 2, 'Product 6', 60),
    ('Description 7', 7, 2, 'Product 7', 70),
    ('Description 8', 8, 2, 'Product 8', 80),
    ('Description 9', 9, 2, 'Product 9', 90),
    ('Description 10', 10, 2, 'Product 10', 100),
    ('Description 11', 11, 2, 'Product 11', 110),
    ('Description 12', 12, 2, 'Product 12', 120),
    ('Description 13', 13, 2, 'Product 13', 130),
    ('Description 14', 2, 2, 'Product 14', 140),
    ('Description 15', 3, 2, 'Product 15', 150),
    ('Description 16', 3, 2, 'Product 16', 160),
    ('Description 17', 3, 2, 'Product 17', 170),
    ('Description 18', 4, 2, 'Product 18', 180),
    ('Description 19', 5, 2, 'Product 19', 190),
    ('Description 20', 6, 2, 'Product 20', 200),
    ('Description 21', 7, 2, 'Product 21', 210),
    ('Description 22', 8, 2, 'Product 22', 220),
    ('Description 23', 9, 2, 'Product 23', 230),
    ('Description 24', 10, 2, 'Product 24', 240),
    ('Description 25', 11, 2, 'Product 25', 250),
    ('Description 26', 12, 2, 'Product 26', 260),
    ('Description 27', 13, 2, 'Product 27', 270),
    ('Description 28', 2, 2, 'Product 28', 280),
    ('Description 29', 3, 2, 'Product 29', 290),
    ('Description 30', 3, 2, 'Product 30', 300);

INSERT INTO orders (delivery_info, payment_id, user_id)
VALUES
    ('test2', 3, 2),
    ('test3', 3, 2),
    ('test4', 4, 2),
    ('test5', 5, 2),
    ('test6', 3, 2),
    ('test7', 3, 2),
    ('test8', 4, 2),
    ('test9', 5, 2);


INSERT INTO payments (create_date, description, status, amount) VALUES
                                                                    ('2022-01-02', 'Payment 2', 2, 200),
                                                                    ('2022-01-03', 'Payment 3', 1, 300),
                                                                    ('2022-01-04', 'Payment 4', 2, 400),
                                                                    ('2022-01-05', 'Payment 5', 1, 500),
                                                                    ('2022-01-06', 'Payment 6', 2, 600),
                                                                    ('2022-01-07', 'Payment 7', 1, 700),
                                                                    ('2022-01-08', 'Payment 8', 2, 800),
                                                                    ('2022-01-09', 'Payment 9', 1, 900),
                                                                    ('2022-01-10', 'Payment 10', 2, 1000),
                                                                    ('2022-01-11', 'Payment 11', 1, 1100),
                                                                    ('2022-01-12', 'Payment 12', 2, 1200);

-- INSERT INTO product_attachments (product_id, attachment_id) VALUES
--                                                                 (1, 1),
--                                                                 (1, 2),
--                                                                 (2, 3),
--                                                                 (2,4);