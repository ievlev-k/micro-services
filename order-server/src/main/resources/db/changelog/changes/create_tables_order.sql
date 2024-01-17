create table payments
(
    id          bigserial primary key,
    create_date varchar(255),
    description varchar(255),
    status bigint not null,
    amount bigint not null
);


create table orders
(
    id            bigserial primary key,
    delivery_info varchar(255),
    payment_id    bigint not null references payments,
    user_id       uuid not null references users
);

create table order_products
(
    order_id   bigint not null,
    product_id bigint not null,
    primary key (order_id, product_id),
    FOREIGN KEY  (order_id) REFERENCES  orders (id),
    FOREIGN KEY  (product_id) REFERENCES  products (id)
);



