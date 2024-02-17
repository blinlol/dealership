create table brand (
    id serial primary key,
    name text unique not null
);

create table model (
    id serial primary key,
    brand_id int references brand(id),
    name text not null,
    constraint unique_model unique(brand_id, name)
);

create table configuration (
    id serial primary key,
    model_id int references model(id),
    name text not null,
    is_new boolean not null,
    count integer constraint positive_count check (count >= 0) default 0,
    specification jsonb default '{}'::jsonb,
    price integer constraint positive_price check (price >= 0) default 0
);

create type order_status_type as enum (
    'created', 
    'in_progress', 
    'completed', 
    'canceled'
);

create table request (
    id serial primary key,
    configuration_id int references configuration(id),
    count int constraint positive_count check (count > 0) not null,
    client_name text not null,
    client_email text not null,
    client_phone text not null,
    status order_status_type not null default 'created'
);

alter table request add column creation_date timestamp default now();

create table manager (
    id serial primary key,
    name text not null,
    email text not null,
    phone text not null
);

create table passwords (
    manager_id int references manager(id),
    login text not null,
    password text not null
);