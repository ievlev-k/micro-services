create table categories
(
    id         bigserial primary key,
    name       varchar(255) not null,
    short_name varchar(255)
);

create table payments
(
    id          bigserial primary key,
    create_date varchar(255),
    description varchar(255),
    status bigint not null,
    amount bigint not null
);

create table attachments
(
    id          bigserial primary key,
    base64      varchar(255) not null,
    create_date varchar(255),
    type        varchar(255) not null
);

create table orders
(
    id            bigserial primary key,
    delivery_info varchar(255),
    payment_id    bigint not null references payments,
    user_id       bigint not null references users
);

create table products
(
    id          bigserial primary key,
    description varchar(255) not null,
    category_id bigint NOT NULL,
    user_id     bigint NoT NULL,
    name        varchar(255) not null,
    price       int not null,
    FOREIGN KEY (user_id) REFERENCES  users (id),
    FOREIGN KEY (category_id) REFERENCES categories (id)

);

create table order_products
(
    order_id   bigint not null,
    product_id bigint not null,
    primary key (order_id, product_id),
    FOREIGN KEY  (order_id) REFERENCES  orders (id),
    FOREIGN KEY  (product_id) REFERENCES  products (id)
);

create table product_attachments
(
    product_id    bigserial,
    attachment_id bigserial,
    primary key (product_id, attachment_id),
    FOREIGN KEY (product_id) REFERENCES  products (id),
    FOREIGN KEY (attachment_id) REFERENCES  attachments (id)
);

