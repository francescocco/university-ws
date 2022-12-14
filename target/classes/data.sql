INSERT INTO STUDENTS (id, matricola, name, surname, corso, città, indirizzo, data_di_nascita)
VALUES(1, 123456, 'Gaetano', 'Gala', 'Informatica', 'Bitonto', 'Via Lemani Dagli Occhi', '1980-12-10');
INSERT INTO STUDENTS (id, matricola, name, surname, corso, città, indirizzo, data_di_nascita)
VALUES(2, 123654, 'Francesco', 'COcco', 'Ingegneria', 'Canosa', 'Via Di Casa Mia', '1994-12-04');
INSERT INTO STUDENTS (id, matricola, name, surname, corso, città, indirizzo, data_di_nascita)
VALUES(3, 789456, 'Ciccio', 'Pasticcio', 'Scienze delle Merendine', 'Venosa', 'Via Col Vento', '1994-12-12');
INSERT INTO EXAMS (id, codice_esame, nome_esame, descrizione, professore, voto, data, studente_id)
VALUES(1, 125, 'Database', 'basi di dati', 'Mortimer', 30, '2022-05-12', 1);
INSERT INTO EXAMS (id, codice_esame, nome_esame, descrizione, professore, voto, data, studente_id)
VALUES(2, 335, 'Polpi schiacciati', 'Si arricciano meglio', 'Von Strausen', 29, '2022-02-12', 3);

CREATE SEQUENCE STUDENTS_SEQUENCE_ID START
WITH (select max(id) + 1 from STUDENTS);
CREATE SEQUENCE EXAMS_SEQUENCE_ID START
WITH (select max(id) + 1 from EXAMS);