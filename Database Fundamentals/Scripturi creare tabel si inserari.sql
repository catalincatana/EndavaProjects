CREATE TABLE Departament (Cod_Departament int NOT NULL CHECK (Cod_Departament >0),Denumire_Departament varchar(255) unique NOT NULL, PRIMARY KEY(Cod_Departament)) ;
CREATE TABLE Salariat ( Marca_Salariat int NOT NULL CHECK (Marca_Salariat >0),Nume_Salariat varchar(255) NOT NULL, Data_nastere datetime, Salariu int , Cod_Departament int NOT NULL CHECK (Cod_Departament >0),PRIMARY KEY (Marca_Salariat),
FOREIGN KEY (Cod_Departament) REFERENCES Departament(Cod_Departament)) ;

ALTER TABLE Salariat
modify COLUMN Data_nastere date;

insert into departament (Cod_Departament, Denumire_Departament) values  (1,'IT');
insert into departament (Cod_Departament, Denumire_Departament) values  (3,'TESTING');

insert into salariat (Marca_Salariat,Nume_Salariat,Data_nastere,Salariu,Cod_Departament) values (1,'Gigel','1988-03-05',2000,1);
insert into salariat (Marca_Salariat,Nume_Salariat,Data_nastere,Salariu,Cod_Departament) values (2,'Marius','1992-08-30',1000,2);
insert into salariat (Marca_Salariat,Nume_Salariat,Data_nastere,Salariu,Cod_Departament) values (3,'Catalin','1992-08-29',1000,1);
insert into salariat (Marca_Salariat,Nume_Salariat,Data_nastere,Salariu,Cod_Departament) values (4,'Dani','1992-08-29',1000,3);
insert into salariat (Marca_Salariat,Nume_Salariat,Data_nastere,Salariu,Cod_Departament) values (5,'Ioana','1992-08-29',1000,3);
insert into salariat (Marca_Salariat,Nume_Salariat,Data_nastere,Salariu,Cod_Departament) values (6,'DANA','1992-08-29',1000,3);

UPDATE Salariat
SET Data_nastere = '1994-2-10' 
WHERE Marca_Salariat=1