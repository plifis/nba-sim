create table standings
(
    id        serial primary key,
    team_id   int references teams (id),
    win       int default 0,
    loss      int default 0,
    season_id int references seasons (id)
);