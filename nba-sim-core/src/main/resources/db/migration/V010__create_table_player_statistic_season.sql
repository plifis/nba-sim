create table player_statistic_seasons
(
    id           serial primary key,
    season_id    int references seasons (id),
    statistic_id int references statistics (id),
    player_id    int references players (id)
);