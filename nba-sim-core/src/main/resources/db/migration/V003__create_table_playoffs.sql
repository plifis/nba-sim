create table playoffs
(
    id            serial primary key,
    start_playoff date,
    end_playoff   date,
    name_playoff  varchar(100)
);