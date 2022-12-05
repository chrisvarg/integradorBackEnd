DROP TABLE IF EXISTS dentists;
CREATE TABLE dentists (
  id INT NOT NULL  AUTO_INCREMENT,
  name VARCHAR(50) NOT NULL,
  last_name VARCHAR(50) NOT NULL,
  license VARCHAR(10) NOT NULL,
  PRIMARY KEY (`id`));

INSERT INTO dentists (name, last_name, license) VALUES('Christian', 'Tabares', '1234567890');
INSERT INTO dentists (name, last_name, license) VALUES('Reinald', 'Suarez', '9876512303');
INSERT INTO dentists (name, last_name, license) VALUES('Daniel', 'Ocampo', '3214578290');
INSERT INTO dentists (name, last_name, license) VALUES('Santiago', 'Vargas', '5946121544');

DROP TABLE IF EXISTS address;
CREATE TABLE address (
    id INT NOT NULL AUTO_INCREMENT,
    street varchar(100) NULL,
    number INT NULL,
    location varchar(100) NULL,
    province varchar(100) NULL,
    PRIMARY KEY (id)
);

INSERT INTO address (street, number, location, province) VALUES('Manzana', 30, 'local 40', 'cucuta');
INSERT INTO address (street, number, location, province) VALUES('Calle', 29, 'avenida 32', 'Bogota');
INSERT INTO address (street, number, location, province) VALUES('Avenida', 12, 'callejon 48', 'Bucaramanga');
INSERT INTO address (street, number, location, province) VALUES('Avenica', 30, 'conjunto sant', 'cucuta');

DROP TABLE IF EXISTS patients;
CREATE TABLE patients (
    id INT NOT NULL AUTO_INCREMENT,
    name varchar(100) NOT NULL,
    last_name varchar(100) NOT NULL,
    email varchar(100) NOT NULL,
    DNI varchar(100) NOT NULL,
    discharge_day DATE NOT NULL,
    address_id INT NOT NULL,
    PRIMARY KEY(id),
    FOREIGN KEY (address_id) REFERENCES address(ID)
);

INSERT INTO patients (address_id, name, last_name, DNI, email, discharge_day) VALUES(2, 'Manuel', 'Rico', 'CC12356974545', 'manuel@email.com', '2017-05-04');
INSERT INTO patients (address_id, name, last_name, DNI, email, discharge_day) VALUES(4, 'Yeis', 'Einst', 'ED1545356566', 'yeist@email.com', '2019-10-24');
INSERT INTO patients (address_id, name, last_name, DNI, email, discharge_day) VALUES(3, 'Kathe', 'Becerra', 'DF451213515', 'kathe@email.com', '2021-06-12');
INSERT INTO patients (address_id, name, last_name, DNI, email, discharge_day) VALUES(1, 'Dilan', 'Pachecho', '12458655412', 'dilan@email.com', CURRENT_DATE);

DROP TABLE IF EXISTS turns;
CREATE TABLE turns (
    id INT NOT NULL AUTO_INCREMENT,
    dentist_id INT NOT NULL,
    patient_id INT NOT NULL,
    date TIMESTAMP NOT NULL,
    PRIMARY KEY(id),
    FOREIGN KEY (patient_id) REFERENCES patients(ID),
    FOREIGN KEY (dentist_id) REFERENCES dentists(ID)
);

INSERT INTO turns (dentist_id, patient_id, date) VALUES(1, 2, CURRENT_TIMESTAMP);
INSERT INTO turns (dentist_id, patient_id, date) VALUES(1, 3, CURRENT_TIMESTAMP);
INSERT INTO turns (dentist_id, patient_id, date) VALUES(2, 1, CURRENT_TIMESTAMP);