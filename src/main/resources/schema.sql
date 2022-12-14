CREATE TABLE STUDENTS(
   id integer not null auto_increment,
   matricola integer not null,
   name varchar(255) not null,
   surname varchar(255) not null,
   corso varchar(255),
   città varchar(255),
   indirizzo varchar(255),
   data_di_nascita date,
   primary key(id)
);


CREATE TABLE EXAMS(
   id integer not null auto_increment,
   codice_esame integer not null,
   nome_esame varchar(255) not null,
   descrizione varchar(255),
   professore varchar(255),
   voto decimal,
   data date,
   studente_id integer,
   primary key(id),
   foreign key(studente_id) references students(id)
);


