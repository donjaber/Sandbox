CREATE TABLE people (
  id INTEGER NOT NULL PRIMARY KEY,
  first_name varchar(50),
  middle_name varchar(50),
  last_name varchar(50),
  alias_name varchar(50),
  birthdate timestamp,
  gender char(1)
);