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