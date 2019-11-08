
Q2) 
ALTER TABLE Laboratoire add (chiffreAffaire number default 0 );
attention les champs de laboratoire sont des chaines de caractères donc entre ' 
INSERT INTO Laboratoire (idLaboratoire,raisonSociale,adressePostaleLAbo,telLabo) VALUES ('X1','labo1','orleans','labo@labo.com','0600000000') ;

Q3) ALTER TABLE Client modify (telClient varchar2(12) not null  );

Q4) refus car l'email n'est pas présent dans la table Utilisateur (dépendance clé etrangere). Il faut donc d'abord insérer cette info dans cette table. 
insert into utilisateur values ('dupont@gmail.com')
insert into client (id,....) values ('dupont@gmail.com',...)

Q5) delete from Utilisateur where eMailUtilisateur='dupont@gmail.com'

erreur --> car on viole la contrainte FK ! si dupont était pas dans la table client alors on aurait pu supprimer sans erreur de la table utilisateur. Donc pour répondre à Q5 : erreur+il ne supprime rien dans Client car on avait pas mis : on delete cascade lors de la création de la contrainte FK et du coup si il supprimer ca va violer la contrainte fk qui vérifie que le dupont de client pointe vers un dupont de utilisateur. Il faut donc supprimer la contrainte de clé étrangere dans la table client puis la recréer car on ne peut pas modifier une contrainte de clé étrangere (on ne peut pas faire de modify sur une contrainte)

ALTER TABLE Client DROP CONSTRAINT FK_Client_Utilisateur_eMailUtilisateur ;
ALTER TABLE Client ADD ( CONSTRAINT FK_Client_Utilisateur_eMailUtilisateur FOREIGN KEY (eMailUtilisateur) REFERENCES Utilisateur on delete cascade ) ; 

NE PAS OUBLIER DE FAIRE LA MEME CHOSE POUR NOTATION CAR ELLE CONTIENT ELLE AUSSI UN EMAILUTILISATEUR

Q6) UPDATE Client SET motDePasee='AAAA' WHERE nomClient='Dupont' ;

Q7) drop table Utilisateur ; mais il refuse car la table Client a besoin de cette table dans la contrainte FK. Pour forcer la supression on écrit :
drop table Utilisateur cascade constraints 

Q8)

constraint chk_Album_dateCreationInfDateModification check ( datecreation<=datedernieremodification) la comparaison se fait entre deux date 

puis pour tester : 

insert into album values (....,to_date('12/03/2017 21:30:45', 'DD/MM/YYYY HH24:MI:SS'), ..... )


Q9) 
A ) (O_region="centre" Client natural_join O_visibilité="public" Album natural_join O_dateTelechargement<'15/03/2017' Image) join (O_note=18 Notation) on idAlbum+numImage
Attention a ne pas faire un natural join sur la table Notation car le champ eMailUtilisateur de la table Notation va fusionner avec celui la table Client alors que les deux n'ont rien à voir (le premier c'est l'email de celui qui a noté l'image alors que le second c'est celui qui est client)
