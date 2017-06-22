create table suburbs (
   id int not null auto_increment primary key,
   post_code_id int not null,
   name varchar(100) not null,
   state_territory varchar(3) not null,
   unique key (post_code_id, name)
);

create table post_codes (
   id int not null auto_increment primary key,
   code int not null unique,
   category varchar(20) default ''
);
