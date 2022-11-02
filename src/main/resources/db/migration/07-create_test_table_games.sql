create table games
(
    id                    serial primary key,
    home_team_id          integer references teams (id),
    home_statistic_entity integer references statistics (id),
    away_team_id          integer references teams (id),
    away_statistic_entity integer references statistic (id),
    gameTypeName          varchar(50)
);