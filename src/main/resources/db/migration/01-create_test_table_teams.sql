create table teams
(
    id            serial primary key,
    name          varchar(50)  not null unique,
    city          varchar(100) not null,
    arena         varchar(100) not null,
    marketSize    varchar(15)           default 'small',
    salaryCap     integer      not null default '100000000',
    salaryCurrent integer      not null default '900000'
);