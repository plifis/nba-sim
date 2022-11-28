create table teams
(
    id             serial primary key,
    name           varchar(50)  not null unique,
    city           varchar(100) not null,
    arena          varchar(100) not null,
    market_size    varchar(15) default 'small',
    salary_cap     numeric default 100000000,
    salary_current numeric default 900000,
    playoff_id     int references playoffs (id) default null
);