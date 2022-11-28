create table players
(
    id            serial primary key,
    name          varchar(100)                      not null,
    surname       varchar(150)                      not null,
    position      varchar(20)                       not null,
    birthdate     date                              not null,
    birthplace    varchar(250),
    birth_country varchar(300),
    height        integer                           not null,
--     //cm
    weight        integer                           not null,
--     //kg
    team_id       integer references teams (id)     default null,
    contract_id   integer references contracts (id) default null,
    skillsets_id  integer references skillsets (id) not null
);