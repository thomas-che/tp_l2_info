--  pb avec cle client donc renomer PK_eMailUtilisateur => PK_eMailUtilisateur1

DROP TABLE TirageImages;
DROP TABLE Tirage;
DROP TABLE TarifFormat;
DROP TABLE TypePapier;
DROP TABLE FormatPapier;
-- DROP TABLE TarifFormat;
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
(  eMailUtilisateur VARCHAR(64)
,  CONSTRAINT PK_eMailUtilisateur PRIMARY KEY(eMailUtilisateur) 
);

CREATE TABLE Client
( eMailUtilisateur VARCHAR(64)
, nomClient VARCHAR(32)
, login VARCHAR(16)
, motDePasse VARCHAR(16)
, adressePostaleClient VARCHAR(128)
, region VARCHAR(32)
, telClient VARCHAR(10)
, quota1 INTEGER(4) --  renomer quota car connu
, CONSTRAINT PK_eMailUtilisateur1 PRIMARY KEY(eMailUtilisateur)
, CONSTRAINT FK_eMail FOREIGN KEY (eMailUtilisateur) REFERENCES Utilisateur (eMailUtilisateur) ON DELETE CASCADE -- ligne rajouter ; pb quand cree client alors email n est pas copier dans la table Util isateur ; ON DELETE CASCADE pour tester suprimer eMail de user
);  

CREATE TABLE CarteBancaire
( numCarteBancaire VARCHAR(16)
, dateLimiteValidite DATE -- d(8)
, codeControle INTEGER(3)
, typeCarteBancaire VARCHAR(32)
, eMailClient VARCHAR(64)
, CONSTRAINT PK_numCarteBancaire PRIMARY KEY(numCarteBancaire) 
, CONSTRAINT FK_CarteBr FOREIGN KEY (eMailClient) REFERENCES Client (eMailUtilisateur)
);

CREATE TABLE Album
( idAlbum INTEGER(4)
, titreAlbum VARCHAR(16)
, dateCreation DATE -- dh(12)
, dateCreationModification DATE
, visibilite VARCHAR(32)
, eMailClient VARCHAR(64)
, CONSTRAINT PK_idAlbum PRIMARY KEY(idAlbum) 
, CONSTRAINT FK_Album_C FOREIGN KEY (eMailClient) REFERENCES Client (eMailUtilisateur)
);

CREATE TABLE Image
( idAlbum INTEGER(4)
, numImage INTEGER(4)
, titreImage VARCHAR(32)
, taille INTEGER(4)
, annotation VARCHAR(64)
, dateTelechargement DATE -- d(8)
, CONSTRAINT PK_idAlbum_numImage PRIMARY KEY(idAlbum,numImage)
);

CREATE TABLE Notation
( eMailUtilisateur VARCHAR(64)
, idAlbum INTEGER(4)
, numImage INTEGER(4)
, note INTEGER(2)
, commentaire VARCHAR(64)
, dateNotation DATE -- d(8)
, CONSTRAINT PK_eMailUtil PRIMARY KEY(eMailUtilisateur,idAlbum,numImage) 
, CONSTRAINT FK_Notation_C FOREIGN KEY (eMailUtilisateur) REFERENCES Utilisateur (eMailUtilisateur) -- rajouter
, CONSTRAINT FK_Notation_Image FOREIGN KEY (idAlbum,numImage) REFERENCES Image (idAlbum,numImage) -- rajouter et test fk avec 2 agrs
);

CREATE TABLE Laboratoire
( idLaboratoire VARCHAR(8)
, raisonSociale VARCHAR(32)
, adressePostalLabo VARCHAR(128)
, eMailLabo VARCHAR(64)
, telLabo VARCHAR(10)
, CONSTRAINT PK_idLaboratoire PRIMARY KEY(idLaboratoire)
);

CREATE TABLE TarifDegressif
( idLaboratoire VARCHAR(8)
, quantiteMini INTEGER(4)
, quantiteMaxi INTEGER(4)
, reduction  DECIMAL(4,2) --  DEC(4,2)  
, CONSTRAINT PK_idLa_qM_qM PRIMARY KEY(idLaboratoire,quantiteMini,quantiteMaxi)
, CONSTRAINT FK_TarifD_Labo FOREIGN KEY (idLaboratoire) REFERENCES Laboratoire (idLaboratoire) -- rajouter
);

CREATE TABLE Commande
( numCommande VARCHAR(8)
, dateCommande DATE -- d(8)
, adresseLivraison VARCHAR(128)
, etatCommande VARCHAR(32)
, eMailClient VARCHAR(64)
, idLaboratoire VARCHAR(8)
, CONSTRAINT PK_numCommande PRIMARY KEY(numCommande) 
, CONSTRAINT FK_C_C_eMail FOREIGN KEY (eMailClient) REFERENCES Client (eMailUtilisateur)
, CONSTRAINT FK_C_L_idLabo FOREIGN KEY (idLaboratoire) REFERENCES Laboratoire (idLaboratoire)
);

-- avant ici TarifFormat, reculer de 2 places

CREATE TABLE FormatPapier
( idFormat VARCHAR(8)
, libelleFormat VARCHAR(32)
, largeur DECIMAL(6,2) --  DEC(6,2) 
, hauteur DECIMAL(6,2) --  DEC(6,2) 
, CONSTRAINT PK_idFormat PRIMARY KEY(idFormat)
);

CREATE TABLE TypePapier
( idTypePapier VARCHAR(8)
, libelleTypePapier VARCHAR(32)
, CONSTRAINT PK_idTypePapier PRIMARY KEY(idTypePapier)
);

CREATE TABLE TarifFormat
( idLaboratoire VARCHAR(8)
, idFormat VARCHAR(8)
, idTypePapier VARCHAR(8)
, prixUnitaire  DECIMAL(4,2) --  DEC(4,2) 
, CONSTRAINT PK_idL_iF_iTP PRIMARY KEY(idLaboratoire,idFormat,idTypePapier)
, CONSTRAINT FK_TarifF_Labo FOREIGN KEY (idLaboratoire) REFERENCES Laboratoire (idLaboratoire) -- rajouter
, CONSTRAINT FK_TarifD_FormatP FOREIGN KEY (idFormat) REFERENCES FormatPapier (idFormat) -- rajouter
, CONSTRAINT FK_TarifD_TypeP FOREIGN KEY (idTypePapier) REFERENCES TypePapier (idTypePapier) -- rajouter
);

CREATE TABLE Tirage
( numCommande VARCHAR(8)
, numTirage INTEGER(4)
, idFormat VARCHAR(8)
, idTypePapier VARCHAR(8)
, CONSTRAINT PK_nC_nT PRIMARY KEY(numCommande,numTirage) 
, CONSTRAINT FK_T_FP_iF FOREIGN KEY (idFormat) REFERENCES FormatPapier (idFormat)
, CONSTRAINT FK_T_TP_iTP FOREIGN KEY (idTypePapier) REFERENCES TypePapier (idTypePapier)
, CONSTRAINT FK_Tirage_Commande FOREIGN KEY (numCommande) REFERENCES Commande (numCommande) -- rajouter
);

CREATE TABLE TirageImages
( numCommande VARCHAR(8)
, numTirage INTEGER(4)
, idAlbum INTEGER(4)
, numImage INTEGER(4)
, quantite INTEGER(4)
, CONSTRAINT PK_nC_nT_iA PRIMARY KEY(numCommande,numTirage,idAlbum,numImage)
, CONSTRAINT FK_TI_Tirage_numC_numT FOREIGN KEY (numCommande,numTirage) REFERENCES Tirage (numCommande,numTirage) -- rajouter
-- , CONSTRAINT FK_TI_Tirage_numT FOREIGN KEY (numTirage) REFERENCES Tirage (numTirage) -- rajouter
, CONSTRAINT FK_TI_Image_idA_numI FOREIGN KEY (idAlbum,numImage) REFERENCES Image (idAlbum,numImage) -- rajouter
-- , CONSTRAINT FK_TI_Image_numI FOREIGN KEY (numImage) REFERENCES Image (numImage) -- rajouter
);


-- q2
ALTER  TABLE Laboratoire ADD (chiffreAffaire INTEGER(30) NOT NULL DEFAULT 0 ) ;
INSERT INTO Laboratoire (`idLaboratoire`) VALUES (2) ;
SELECT * FROM Laboratoire WHERE 1;


-- q3
ALTER TABLE Client DROP COLUMN `telClient`;
ALTER TABLE Client ADD (telClient INTEGER(12) NOT NULL);


-- q4
ALTER TABLE Client DROP COLUMN `telClient`;
ALTER TABLE Client ADD (telClient DECIMAL(12) NOT NULL);  -- remplce INTEGER par DECIMAL car la taille du int etait depacer
-- prof ALTER TABLE Client MODIFY (telClient DECIMAL(12) NOT NULL);

-- comment faire en sorte que se copie tout seul ?
INSERT INTO Utilisateur (`eMailUtilisateur`) VALUES ('dupont@gmail.com');
INSERT INTO Client (`eMailUtilisateur`,`nomClient`,`telClient`) VALUES ('dupont@gmail.com','Dupont',123456789012);
SELECT * FROM Utilisateur WHERE 1;
SELECT * FROM Client WHERE 1;

-- q5

DELETE FROM Utilisateur WHERE `eMailUtilisateur`='dupont@gmail.com' CASCADE ;
























