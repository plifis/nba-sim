create table players
(
    id           serial primary key,
    name         varchar(100) not null,
    surname      varchar(150) not null,
    position     varchar(20)  not null,
    birthdate    timestamp    not null,
    birthplace   varchar(250),
    birthcountry varchar(300),
    height       integer      not null,
--     //cm
    weight       numeric(1)   not null,
--     //kg
    team_id      integer references teams (id),
    contract_id integer references contracts(id),
    skills_id    integer references skills (id) not null,
    badge_id     integer references badges (id)
);