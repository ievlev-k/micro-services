create table users
(
    id          uuid PRIMARY KEY DEFAULT gen_random_uuid(),
    email      varchar(255) not null
        constraint uk_6dotkott2kjsp8vw4d0m25fb7
            unique,
    user_status varchar(128) NOT NULL,
    role      varchar(40)      ,
    room            bigint not null,
    social_media    varchar(255) not null,
    phone           varchar(255) not null,
    first_name      varchar(255) not null,
    last_name       varchar(255),
    password            varchar(255) not null,
    username        varchar(255) not null
        constraint uk_r43af9ap4edm43mmtq01oddj6
            unique

);



create table categories
(
    id         bigserial primary key,
    name       varchar(255) not null,
    short_name varchar(255)
);


create table attachments
(
    id          bigserial primary key,
    base64      varchar(255) not null,
    create_date varchar(255),
    type        varchar(255) not null
);

create table products
(
    id          bigserial primary key,
    description varchar(255) not null,
    category_id bigint       NOT NULL,
    user_id     uuid       NoT NULL,
    name        varchar(255) not null,
    price       int          not null,
    FOREIGN KEY (user_id) REFERENCES users (id),
    FOREIGN KEY (category_id) REFERENCES categories (id)

);

create table product_attachments
(
    product_id    bigserial,
    attachment_id bigserial,
    primary key (product_id, attachment_id),
    FOREIGN KEY (product_id) REFERENCES products (id),
    FOREIGN KEY (attachment_id) REFERENCES attachments (id)
);

