SELECT * FROM endava.salariat;

UPDATE Salariat
SET Salariu = Salariu - Salariu *0.1 
WHERE Cod_Departament=1;

Select max(Salariu),D.Denumire_Departament from Salariat S join departament D on S.Cod_Departament=D.Cod_Departament group by S.Cod_Departament;
Select max(Salariu),D.Denumire_Departament from Salariat S join departament D on S.Cod_Departament=D.Cod_Departament group by S.Cod_Departament having D.Denumire_Departament like 'T%' and count(S.Marca_Salariat)>2;

update Salariat 
Set Salariu = (Salariu + Salariu * 0.1)
where Cod_Departament = (select D.Cod_Departament from Departament D join Salariat S on S.Cod_Departament = D.Cod_Departament group by S.Cod_Departament having count(S.Marca_Salariat) = 1);

update Salariat 
Set Salariu = (Salariu + Salariu * 0.1)
where Cod_Departament = (select T.CodDep from (select S.Cod_Departament as CodDep, count(S.Marca_Salariat) from Salariat S group by S.Cod_Departament having count(S.Marca_Salariat) = 1) as T)