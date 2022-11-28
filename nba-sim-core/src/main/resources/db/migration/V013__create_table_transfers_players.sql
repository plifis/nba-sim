create table transfers_players
(
    id          serial primary key,
    transfer_id int references transfers (id),
    player_id   int references players (id)
);