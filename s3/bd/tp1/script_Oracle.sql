-- sqldev univ: user/mdp=o2.. ; nomhote= 192.168.80.173 ; pors=1521 ; sid=oracle1

--  pb avec cle client donc renomer PK_eMailUtilisateur => PK_eMailUtilisateur1

DROP TABLE TirageImages;
DROP TABLE Tirage;
DROP TABLE TarifFormat;
DROP TABLE TypePapier;
DROP TABLE FormatPapier;
DROP TABLE Commande;
DROP TABLE TarifDegressif;
DROP TABLE Laboratoire;
DROP TABLE Notation;
DROP TABLE Image;
DROP TABLE Album;
DROP TABLE CarteBancaire;
DROP TABLE Client;
DROP TABLE Utilisateur;


CREATE TABLE Utilisateur 
(  eMailUtilisateur VARCHAR2(64)
,  CONSTRAINT PK_eMailUtilisateur PRIMARY KEY(eMailUtilisateur) 
);

CREATE TABLE Client
( eMailUtilisateur VARCHAR2(64)
, nomClient VARCHAR2(32)
, login VARCHAR2(16)
, motDePasse VARCHAR2(16)
, adressePostaleClient VARCHAR2(128)
, region VARCHAR2(32)
, telClient VARCHAR2(10)
, quota1 NUMBER(4) --  renomer quota car connu
, CONSTRAINT PK_eMailUtilisateur1 PRIMARY KEY(eMailUtilisateur)
, CONSTRAINT FK_Client_Utili_eMail FOREIGN KEY (eMailUtilisateur) REFERENCES Utilisateur (eMailUtilisateur)  -- ON DELETE CASCADE -- ligne rajouter ; pb quand cree client alors email n est pas copier dans la table Util isateur ; ON DELETE CASCADE pour tester suprimer eMail de user
);  

CREATE TABLE CarteBancaire
( numCarteBancaire VARCHAR2(16)
, dateLimiteValidite DATE -- d(8)
, codeControle NUMBER(3)
, typeCarteBancaire VARCHAR2(32)
, eMailClient VARCHAR2(64)
, CONSTRAINT PK_numCarteBancaire PRIMARY KEY(numCarteBancaire) 
, CONSTRAINT FK_CarteBr FOREIGN KEY (eMailClient) REFERENCES Client (eMailUtilisateur)
);

CREATE TABLE Album
( idAlbum NUMBER(4)
, titreAlbum VARCHAR2(16)
, dateCreation DATE -- dh(12)
, dateCreationModification DATE
, visibilite VARCHAR2(32)
, eMailClient VARCHAR2(64)
, CONSTRAINT PK_idAlbum PRIMARY KEY(idAlbum) 
, CONSTRAINT FK_Album_C FOREIGN KEY (eMailClient) REFERENCES Client (eMailUtilisateur)
);

CREATE TABLE Image
( idAlbum NUMBER(4)
, numImage NUMBER(4)
, titreImage VARCHAR2(32)
, taille NUMBER(4)
, annotation VARCHAR2(64)
, dateTelechargement DATE -- d(8)
, CONSTRAINT PK_idAlbum_numImage PRIMARY KEY(idAlbum,numImage)
);

CREATE TABLE Notation
( eMailUtilisateur VARCHAR2(64)
, idAlbum NUMBER(4)
, numImage NUMBER(4)
, note NUMBER(2)
, commentaire VARCHAR2(64)
, dateNotation DATE -- d(8)
, CONSTRAINT PK_eMailUtil PRIMARY KEY(eMailUtilisateur,idAlbum,numImage) 
, CONSTRAINT FK_Notation_C FOREIGN KEY (eMailUtilisateur) REFERENCES Utilisateur (eMailUtilisateur) -- rajouter
, CONSTRAINT FK_Notation_Image FOREIGN KEY (idAlbum,numImage) REFERENCES Image (idAlbum,numImage) -- rajouter et test fk avec 2 agrs
);

CREATE TABLE Laboratoire
( idLaboratoire VARCHAR2(8)
, raisonSociale VARCHAR2(32)
, adressePostalLabo VARCHAR2(128)
, eMailLabo VARCHAR2(64)
, telLabo VARCHAR2(10)
, CONSTRAINT PK_idLaboratoire PRIMARY KEY(idLaboratoire)
);

CREATE TABLE TarifDegressif
( idLaboratoire VARCHAR2(8)
, quantiteMini NUMBER(4)
, quantiteMaxi NUMBER(4)
, reduction  NUMBER(4,2) --  DEC(4,2)  
, CONSTRAINT PK_idLa_qM_qM PRIMARY KEY(idLaboratoire,quantiteMini,quantiteMaxi)
, CONSTRAINT FK_TarifD_Labo FOREIGN KEY (idLaboratoire) REFERENCES Laboratoire (idLaboratoire) -- rajouter
);

CREATE TABLE Commande
( numCommande VARCHAR2(8)
, dateCommande DATE -- d(8)
, adresseLivraison VARCHAR2(128)
, etatCommande VARCHAR2(32)
, eMailClient VARCHAR2(64)
, idLaboratoire VARCHAR2(8)
, CONSTRAINT PK_numCommande PRIMARY KEY(numCommande) 
, CONSTRAINT FK_C_C_eMail FOREIGN KEY (eMailClient) REFERENCES Client (eMailUtilisateur)
, CONSTRAINT FK_C_L_idLabo FOREIGN KEY (idLaboratoire) REFERENCES Laboratoire (idLaboratoire)
);

-- avant ici TarifFormat, reculer de 2 places

CREATE TABLE FormatPapier
( idFormat VARCHAR2(8)
, libelleFormat VARCHAR2(32)
, largeur NUMBER(6,2) --  DEC(6,2) 
, hauteur NUMBER(6,2) --  DEC(6,2) 
, CONSTRAINT PK_idFormat PRIMARY KEY(idFormat)
);

CREATE TABLE TypePapier
( idTypePapier VARCHAR2(8)
, libelleTypePapier VARCHAR2(32)
, CONSTRAINT PK_idTypePapier PRIMARY KEY(idTypePapier)
);

CREATE TABLE TarifFormat
( idLaboratoire VARCHAR2(8)
, idFormat VARCHAR2(8)
, idTypePapier VARCHAR2(8)
, prixUnitaire  NUMBER(4,2) --  DEC(4,2) 
, CONSTRAINT PK_idL_iF_iTP PRIMARY KEY(idLaboratoire,idFormat,idTypePapier)
, CONSTRAINT FK_TarifF_Labo FOREIGN KEY (idLaboratoire) REFERENCES Laboratoire (idLaboratoire) -- rajouter
, CONSTRAINT FK_TarifD_FormatP FOREIGN KEY (idFormat) REFERENCES FormatPapier (idFormat) -- rajouter
, CONSTRAINT FK_TarifD_TypeP FOREIGN KEY (idTypePapier) REFERENCES TypePapier (idTypePapier) -- rajouter
);

CREATE TABLE Tirage
( numCommande VARCHAR2(8)
, numTirage NUMBER(4)
, idFormat VARCHAR2(8)
, idTypePapier VARCHAR2(8)
, CONSTRAINT PK_nC_nT PRIMARY KEY(numCommande,numTirage) 
, CONSTRAINT FK_T_FP_iF FOREIGN KEY (idFormat) REFERENCES FormatPapier (idFormat)
, CONSTRAINT FK_T_TP_iTP FOREIGN KEY (idTypePapier) REFERENCES TypePapier (idTypePapier)
, CONSTRAINT FK_Tirage_Commande FOREIGN KEY (numCommande) REFERENCES Commande (numCommande) -- rajouter
);

CREATE TABLE TirageImages
( numCommande VARCHAR2(8)
, numTirage NUMBER(4)
, idAlbum NUMBER(4)
, numImage NUMBER(4)
, quantite NUMBER(4)
, CONSTRAINT PK_nC_nT_iA PRIMARY KEY(numCommande,numTirage,idAlbum,numImage)
, CONSTRAINT FK_TI_Tirage_numC_numT FOREIGN KEY (numCommande,numTirage) REFERENCES Tirage (numCommande,numTirage) -- rajouter
-- , CONSTRAINT FK_TI_Tirage_numT FOREIGN KEY (numTirage) REFERENCES Tirage (numTirage) -- rajouter
, CONSTRAINT FK_TI_Image_idA_numI FOREIGN KEY (idAlbum,numImage) REFERENCES Image (idAlbum,numImage) -- rajouter
-- , CONSTRAINT FK_TI_Image_numI FOREIGN KEY (numImage) REFERENCES Image (numImage) -- rajouter
);


-- q2
ALTER TABLE laboratoire DROP COLUMN chiffreAffaire;
ALTER TABLE laboratoire ADD (chiffreAffaire NUMBER DEFAULT 0 ) ; -- pb avec not null ne pas l ecrir car la la colone prend dejat 0 par default
INSERT INTO Laboratoire (idLaboratoire) VALUES (2) ;
SELECT * FROM laboratoire ;

-- q3
ALTER TABLE Client MODIFY (telClient NUMBER(12) );
SELECT * FROM client;

-- q4
INSERT INTO Utilisateur (eMailUtilisateur) VALUES ('dupont@gmail.com');
INSERT INTO Client (eMailUtilisateur,nomClient,telClient) VALUES ('dupont@gmail.com','Dupont',123456789012);
SELECT * FROM Utilisateur;
SELECT * FROM Client;


-- q5
-- DELETE FROM Utilisateur WHERE eMailUtilisateur='dupont@gmail.com'; -- pas besoin du cascade pour le suprimer
ALTER TABLE Client DROP CONSTRAINT FK_Client_Utili_eMail ;
ALTER TABLE Client ADD  ( CONSTRAINT FK_Client_Utili_eMail FOREIGN KEY (eMailUtilisateur) REFERENCES Utilisateur (eMailUtilisateur)  ON DELETE CASCADE ); -- le CONSTRAINT est dans la ()
DELETE FROM Utilisateur WHERE eMailUtilisateur='dupont@gmail.com';
SELECT * FROM Utilisateur;
SELECT * FROM Client;

-- q6
INSERT INTO Utilisateur (eMailUtilisateur) VALUES ('dupont@gmail.com');
INSERT INTO Client (eMailUtilisateur,nomClient,telClient,motdepasse) VALUES ('dupont@gmail.com','Dupont',123456789012,'AAA');
SELECT * FROM Utilisateur;
SELECT * FROM Client;


-- q7 ; mi en commentaire pour ne pas suprimer
--DROP TABLE Utilisateur CASCADE CONSTRAINTS ; -- c est cascade puis contraint
--SELECT * FROM Utilisateur;
--SELECT * FROM Client;

-- q8
INSERT INTO Album (idAlbum,dateCreation,dateCreationModification) VALUES (1,to_date('05/11/2019','DD/MM/YYYY'),to_date('07/11/2019','DD/MM/YYYY'));
SELECT * FROM Album;
ALTER TABLE Album ADD ( CONSTRAINT CHK_dateCre_inf_egal_dateDM CHECK ( dateCreation <= dateCreationModification ) );
INSERT INTO Album (idAlbum,dateCreation,dateCreationModification) VALUES (2,to_date('05/11/2019','DD/MM/YYYY'),to_date('01/11/2019','DD/MM/YYYY')); -- doit avoir une erreur
SELECT * FROM Album;

-- q9
-- ne fonctione pas
SELECT eMailUtilisateur,nomClient,telClient FROM (SELECT * FROM Client WHERE region='centre') NATURAL JOIN ( SELECT * FROM (SELECT * FROM Album WHERE visibilite='public' ) NATURAL JOIN SELECT * FROM (SELECT * FROM Image WHERE to_char(dateTelechargement ,'DD/MM/YYYY')<to_date('15/03/2017','DD/MM/YYYY') JOIN (SELECT numImage FROM Notation WHERE note=18) ) )  ; 




