create table partiu.location
(
    id        bigserial primary key,
    latitude  numeric(16, 14) not null,
    longitude numeric(17, 14) not null,
    name      varchar(255)    not null
        constraint uk_location_name
            unique
);

alter table partiu.location
    owner to partiu;


create table partiu.event
(
    id               bigserial    primary key,
    creation_date    timestamp      not null,
    final_date       timestamp      not null,
    initial_date     timestamp      not null,
    max_participants integer,
    min_participants integer,
    name             varchar(255)   not null,
    price            numeric(19, 2) not null,
    status           varchar(255)   not null,
    creator_id       varchar(255)   not null,
    location_id      bigint         not null
        constraint fk_location
            references partiu.location
);

alter table partiu.event
    owner to partiu;

create table partiu.event_user
(
    user_id       varchar(255) not null,
    creation_date timestamp    not null,
    paid          boolean      not null,
    event_id      bigint       not null
        constraint fk_event
            references partiu.event,
    primary key (event_id, user_id)
);

alter table partiu.event_user
    owner to partiu;