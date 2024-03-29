-- Active: 1708096356933@@127.0.0.1@5432@expensave
create table users (
    id serial primary key,
    username varchar(255) not null,
    password varchar(255) not null,
    created_at timestamp not null default current_timestamp
);

create table expenses (
    id serial primary key,
    amount numeric(10, 2) not null,
    description text not null,
    created_at timestamp not null default current_timestamp
);

create table user_expenses (
    user_id int not null,
    expense_id int not null,
    primary key (user_id, expense_id),
    foreign key (user_id) references users(id),
    foreign key (expense_id) references expenses(id)
);