create table rounds
(
    id             serial primary key,
    round_name     varchar(50),
    win_for_next   integer                       not null,
    home_team_wins integer                       default 0,
    away_team_wins integer                       default 0,
    first_team_id  integer references teams (id) not null,
    second_team_id integer references teams (id) not null,
    winner_id      integer references teams (id) default null,
    playoff_id     integer references playoffs (id)
);