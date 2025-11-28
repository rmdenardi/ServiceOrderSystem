CREATE TABLE person(
id serial NOT NULL PRIMARY KEY,
fullname varchar(45) NOT NULL,
rank varchar(20) NOT NULL,
cpf char(11) NOT NULL,
phone varchar (45) NOT NULL,
email varchar (45) NOT NULL,
login varchar (14) NOT NULL,
passwod varchar (14) NOT NULL,
birthdate date NOT NULL
);


CREATE TABLE acess (
id serial NOT NULL PRIMARY KEY,
description varchar (45) NOT NULL
);


CREATE TABLE user_acess (
person_id int NOT NULL,
acess_id int NOT NULL,
PRIMARY KEY (person_id, acess_id),
FOREIGN KEY (person_id) REFERENCES person(id),
FOREIGN KEY (acess_id) REFERENCES acess(id)
);

CREATE TABLE computer (
siscofis_code int NOT NULL PRIMARY KEY,
processor varchar (45) NOT NULL,
rammemory varchar (45) NOT NULL,
operatingsystem varchar (45) NOT NULL,
gpu varchar(45) NOT NULL,
powersupply varchar (45) NOT NULL,
motherboard varchar (45) NOT NULL,
hardware_type_id int NOT NULL, 
FOREIGN KEY (hardware_type_id) REFERENCES hardware_type (id)
);

ALTER TABLE computer ADD COLUMN harddisk varchar (45) NOT NULL;




CREATE TABLE hardware_type (
id serial NOT NULL PRIMARY KEY,
description varchar (45) NOT NULL UNIQUE
);


CREATE TABLE status (
id serial NOT NULL PRIMARY KEY,
description varchar (45) NOT NULL UNIQUE

);


CREATE TABLE service_order (
id serial NOT NULL,
date timestamp NOT NULL,
user_id int NOT NULL,
computer_siscofis_code int NOT NULL,
problem_description varchar (45) NOT NULL,
solution varchar (45) NOT NULL,
status_id int NOT NULL,
PRIMARY KEY (id, date, user_id, computer_siscofis_code, 
status_id),
FOREIGN KEY (user_id) REFERENCES person (id),
FOREIGN KEY (computer_siscofis_code) REFERENCES computer(siscofis_code),
FOREIGN KEY (status_id) REFERENCES status (id)
);


