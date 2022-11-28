create table statistics
(
    id                 serial primary key,
    points_total       integer default '0',
    assists_total      integer default '0',
    off_rebounds_total integer default '0',
    def_rebounds_total integer default '0',
    rebounds_total     integer default '0',
    steals_total       integer default '0',
    blocks_total       integer default '0',
    games_played_total integer default '0',
    game_start_total   integer default '0',
    points_per_game    float8  default '0',
    assists_per_game   float8  default '0',
    rebounds_per_game  float8  default '0',
    steals_per_game    float8  default '0',
    blocks_per_game    float8  default '0'
);
