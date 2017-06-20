CREATE TABLE suburbs (
   id int not null auto_increment PRIMARY KEY,
   post_code_id int not null,
   name VARCHAR(100)
)

CREATE TABLE post_codes (
   id int not null auto_increment PRIMARY KEY,
   code int not null
)
