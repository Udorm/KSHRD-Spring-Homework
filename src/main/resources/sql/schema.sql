create table books(
    id          serial primary key,
    title       varchar(200),
    publishDate varchar(50),
    author      varchar(100),
    page        int4,
    coverImage  varchar(200)
);

create table publishers(
    id          serial primary key,
    publisher   varchar(100)
);

create table book_publisher(
    book_id         int4 references books(id) on delete cascade,
    publisher_id    int4 references publishers(id) on delete cascade
);

create table users(
    id          serial primary key,
    username    varchar(100),
    password    varchar(250)
);

create table roles(
    id          serial primary key,
    role        varchar(100)
);

create table user_role(
    user_id     int4 references users(id) on delete cascade,
    role_id     int4 references roles(id) on delete cascade
);