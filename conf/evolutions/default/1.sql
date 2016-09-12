# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table product (
  ean                           varchar(255),
  name                          varchar(255),
  description                   varchar(255)
);


# --- !Downs

drop table if exists product;

