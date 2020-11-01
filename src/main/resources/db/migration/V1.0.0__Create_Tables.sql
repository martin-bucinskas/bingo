CREATE SCHEMA IF NOT EXISTS bingo;

CREATE TABLE bingo.player (
    id varchar not null primary key,
    username varchar,
    discriminator varchar(4),
    player_points int,
    team uuid
);

CREATE UNIQUE INDEX bingo_player_username_index
    ON bingo.player (username);

CREATE TABLE bingo.item (
    id uuid not null primary key,
    name varchar,
    item_level varchar
);

CREATE UNIQUE INDEX bingo_item_name_index
    ON bingo.item (name);
CREATE UNIQUE INDEX bingo_item_level_index
    ON bingo.item (item_level);

CREATE TABLE bingo.team (
    id uuid not null primary key,
    team_name varchar not null,
    team_points int
);

CREATE UNIQUE INDEX bingo_team_id_index
    ON bingo.team (id);

CREATE TABLE bingo.event (
    id uuid not null primary key,
    event_name varchar,
    start_date timestamp with time zone,
    finish_date timestamp with time zone,
    event_started boolean
);

CREATE TABLE bingo.team_item (
    id uuid not null primary key,
    team_id uuid not null,
    player_id varchar not null,
    item_id uuid not null
);

CREATE UNIQUE INDEX bingo_team_item_team_id_player_id_item_id_index
    ON bingo.team_item (team_id, player_id, item_id);
