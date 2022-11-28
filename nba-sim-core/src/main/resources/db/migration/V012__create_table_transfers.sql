create table transfers
(
    id                  serial primary key,
    team_source_id      int references teams (id),
    team_destination_id int references teams (id)
);