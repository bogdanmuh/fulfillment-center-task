create table products (
    qty integer not null,
    value integer not null,
    id uuid not null,
    fulfillment_center varchar(255),
    product_id varchar(255),
    status varchar(255)

    check (status in ('SELLABLE','UNFULFILLABLE','INBOUND')),
    primary key (id))