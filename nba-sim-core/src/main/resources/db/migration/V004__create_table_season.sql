create table seasons
(
    id                   serial primary key,
    years                varchar(20),
    start_regular_season date,
    end_regular_season   date
);