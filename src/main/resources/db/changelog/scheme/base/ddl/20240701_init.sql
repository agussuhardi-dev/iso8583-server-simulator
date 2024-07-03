create table iso8583_response_template
(
    id         char(36)    not null,
    name       varchar(50) not null,
    explain    varchar(255),
    template   text        not null,
    created_at numeric     not null,
    updated_at numeric,
    primary key (id)
);

create table iso8583
(
    id            char(36)    not null,
    acquirer_code varchar(50) not null,
    acquirer_name varchar(50) not null,

    response      text        not null,
    rc            varchar(10) not null,
    mti           varchar(20) not null,

    is_enabled    boolean     not null,
    created_at    numeric     not null,
    updated_at    numeric,
    primary key (id),
    unique (acquirer_code)
);

create table history
(
    id            char(36)    not null,
    acquirer_code varchar(50) not null,
    request       text        not null,
    created_at    numeric     not null,
    primary key (id)
);
