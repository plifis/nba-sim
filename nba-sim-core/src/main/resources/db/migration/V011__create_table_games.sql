create table games
(
    id                    serial primary key,
    home_team_id          integer references teams (id),
    home_statistic_entity integer references statistics (id),
    away_team_id          integer references teams (id),
    away_statistic_entity integer references statistics (id),
    game_type_name        varchar(50),
    rounds_id             integer references rounds (id) default null
);