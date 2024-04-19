drop table if exists beer;

drop table if exists customer;

CREATE TABLE beer
(
    beer_style         tinyint        not null check (beer_style between 0 and 9),
    price              decimal(38, 2) not null,
    quantity_on_hand   integer,
    version            integer,
    created_date       datetime(6),
    last_modified_date datetime(6),
    beer_name          varchar(50)    not null,
    id                 varchar(36)    not null,
    upc                varchar(255)   not null,
    PRIMARY KEY (id)
) ENGINE = InnoDB;

CREATE TABLE customer
(
    version            integer,
    created_date       datetime(6),
    last_modified_date datetime(6),
    customer_name      varchar(50) not null,
    id                 varchar(36) not null,
    PRIMARY KEY (id)
) ENGINE = InnoDB;
