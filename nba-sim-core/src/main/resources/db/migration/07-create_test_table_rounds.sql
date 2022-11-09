create table rounds(
    id serial primary key ,
    roundName varchar(50),
    winForNextRound integer not null ,
    homeTeamEntityWins integer default '0',
    awayTeamEntityWins integer default '0',
    first_team_id integer references teams(id) not null ,
    second_team_id integer references teams(id) not null ,
    winner_id integer references teams(id) default null,

);

    @OneToOne
@JoinColumn(name = "winner_id")
    private TeamEntity winner = null;

    @OneToMany(mappedBy = "games")
    private List<GameEntity> gameEntityList;