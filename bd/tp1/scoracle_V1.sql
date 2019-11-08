-- pb avec cle client donc renomer PK_eMailUtilisateur => PK_eMailUtilisateur1


DROP TABLE TirageImages;
DROP TABLE Tirage;
DROP TABLE TypePapier;
DROP TABLE FormatPapier;
DROP TABLE TarifFormat;
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
, quota1 NUMBER(4) -- renomer quota car connu
, CONSTRAINT PK_eMailUtilisateur1 PRIMARY KEY(eMailUtilisateur)
); 

CREATE TABLE CarteBancaire
( numCarteBancaire VARCHAR2(16)
, dateLimiteValidite DATE --d(8)
, codeControle NUMBER(3)
, typeCarteBancaire VARCHAR2(32)
, eMailClient VARCHAR2(64)
, CONSTRAINT PK_numCarteBancaire PRIMARY KEY(numCarteBancaire) 
, CONSTRAINT FK_CarteBr FOREIGN KEY (eMailClient) REFERENCES Client 
);

CREATE TABLE Album
( idAlbum NUMBER(4)
, titreAlbum VARCHAR2(16)
, dateCreation DATE --dh(12)
, dateCreationModification DATE
, visibilite VARCHAR2(32)
, eMailClient VARCHAR2(64)
, CONSTRAINT PK_idAlbum PRIMARY KEY(idAlbum) 
, CONSTRAINT FK_Album_C FOREIGN KEY (eMailClient) REFERENCES Client 
);

CREATE TABLE Image
( idAlbum NUMBER(4)
, numImage NUMBER(4)
, titreImage VARCHAR2(32)
, taille NUMBER(4)
, annotation VARCHAR2(64)
, dateTelechargement DATE --d(8)
, CONSTRAINT PK_idAlbum_numImage PRIMARY KEY(idAlbum,numImage)
);

CREATE TABLE Notation
( eMailUtilisateur VARCHAR2(64)
, idAlbum NUMBER(4)
, numImage NUMBER(4)
, note NUMBER(2)
, commentaire VARCHAR2(64)
, dateNotation DATE --d(8)
, CONSTRAINT PK_eMailUtil PRIMARY KEY(eMailUtilisateur,idAlbum,numImage) 
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
, reduction  NUMBER(4,2) -- DEC(4,2)  
, CONSTRAINT PK_idLa_qM_qM PRIMARY KEY(idLaboratoire,quantiteMini,quantiteMaxi)
);

CREATE TABLE Commande
( numCommande VARCHAR2(8)
, dateCommande DATE --d(8)
, adresseLivraison VARCHAR2(128)
, etatCommande VARCHAR2(32)
, eMailClient VARCHAR2(64)
, idLaboratoire VARCHAR2(8)
, CONSTRAINT PK_numCommande PRIMARY KEY(numCommande) 
, CONSTRAINT FK_C_C_eMail FOREIGN KEY (eMailClient) REFERENCES Client 
, CONSTRAINT FK_C_L_idLaboratoire FOREIGN KEY (idLaboratoire) REFERENCES Laboratoire 
);

CREATE TABLE TarifFormat
( idLaboratoire VARCHAR2(8)
, idFormat VARCHAR2(8)
, idTypePapier VARCHAR2(8)
, prixUnitaire  NUMBER(4,2) -- DEC(4,2) 
, CONSTRAINT PK_idL_iF_iTP PRIMARY KEY(idLaboratoire,idFormat,idTypePapier)
);

CREATE TABLE FormatPapier
( idFormat VARCHAR2(8)
, libelleFormat VARCHAR2(32)
, largeur NUMBER(6,2) -- DEC(6,2) 
, hauteur NUMBER(6,2) -- DEC(6,2) 
, CONSTRAINT PK_idFormat PRIMARY KEY(idFormat)
);

CREATE TABLE TypePapier
( idTypePapier VARCHAR2(8)
, libelleTypePapier VARCHAR2(32)
, CONSTRAINT PK_idTypePapier PRIMARY KEY(idTypePapier)
);

CREATE TABLE Tirage
( numCommande VARCHAR2(8)
, numTirage NUMBER(4)
, idFormat VARCHAR2(8)
, idTypePapier VARCHAR2(8)
, CONSTRAINT PK_nC_nT PRIMARY KEY(numCommande,numTirage) 
, CONSTRAINT FK_T_FP_iF FOREIGN KEY (idFormat) REFERENCES FormatPapier
, CONSTRAINT FK_T_TP_iTP FOREIGN KEY (idTypePapier) REFERENCES TypePapier 
);

CREATE TABLE TirageImages
( numCommande VARCHAR2(8)
, numTirage NUMBER(4)
, idAlbum NUMBER(4)
, numImage NUMBER(4)
, quantite NUMBER(4)
, CONSTRAINT PK_nC_nT_iA PRIMARY KEY(numCommande,numTirage,idAlbum,numImage) 
);


--q2
ALTER  TABLE Laboratoire ADD (chiffreAffaire NUMBER(30) ) ;

SELECT * FROM laboratoire;

