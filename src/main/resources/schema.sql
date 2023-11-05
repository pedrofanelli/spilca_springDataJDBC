CREATE TABLE IF NOT EXISTS account (
   id SERIAL PRIMARY KEY,
   name varchar(50) NOT NULL,
   amount numeric NOT NULL
);