create table skillsets
(
    id                   serial primary key,
    shooting_dribble     smallint default 0,
    shooting_off_dribble smallint default 0,
    standing_dunk        smallint default 0,
    drive_dunk           smallint default 0,
    fade_away            smallint default 0,
    post_hook            smallint default 0,
    contest_shoot        smallint default 0,
    three_point          smallint default 0,
    free_throw           smallint default 0,
    drive                smallint default 0,
    pass_accuracy        smallint default 0,
    pass_vision          smallint default 0,
    dribbling            smallint default 0,
    defence_rebound      smallint default 0,
    offense_rebound      smallint default 0,
    interior_defence     smallint default 0,
    perimeter_defence    smallint default 0,
    steal                smallint default 0,
    block                smallint default 0,
    speed                smallint default 0,
    acceleration         smallint default 0,
    durability           smallint default 0,
    jump                 smallint default 0,
    total_rating         int      default 0
);