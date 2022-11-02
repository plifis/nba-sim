create table statistics(
    id serial primary key ,
    pointsTotal integer default '0',
    assistsTotal integer default '0',
    offReboundsTotal integer default '0',
    defReboundsTotal integer default '0',
    reboundsTotal integer default '0',
    stealsTotal integer default '0',
    blocksTotal integer default '0',
    gamesPlayedTotal integer default '0',
    gamesStartTotal integer default '0',
    pointsPerGame numeric default '0',
    assistsPerGame numeric default '0',
    reboundPerGame numeric default '0',
    stealsPerGame numeric default '0',
    blocksPerGame numeric default '0'
);
