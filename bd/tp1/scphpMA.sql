--  pb avec cle client donc renomer PK_eMailUtilisateur => PK_eMailUtilisateur1


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
); 

CREATE TABLE CarteBancaire
( numCarteBancaire VARCHAR(16)
, dateLimiteValidite DATE -- d(8)
, codeControle INTEGER(3)
, typeCarteBancaire VARCHAR(32)
, eMailClient VARCHAR(64)
, CONSTRAINT PK_numCarteBancaire PRIMARY KEY(numCarteBancaire) 
, CONSTRAINT FK_CarteBr FOREIGN KEY (eMailClient) REFERENCES Client 
);

CREATE TABLE Album
( idAlbum INTEGER(4)
, titreAlbum VARCHAR(16)
, dateCreation DATE -- dh(12)
, dateCreationModification DATE
, visibilite VARCHAR(32)
, eMailClient VARCHAR(64)
, CONSTRAINT PK_idAlbum PRIMARY KEY(idAlbum) 
, CONSTRAINT FK_Album_C FOREIGN KEY (eMailClient) REFERENCES Client 
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
, reduction  INTEGER(4,2) --  DEC(4,2)  
, CONSTRAINT PK_idLa_qM_qM PRIMARY KEY(idLaboratoire,quantiteMini,quantiteMaxi)
);

CREATE TABLE Commande
( numCommande VARCHAR(8)
, dateCommande DATE -- d(8)
, adresseLivraison VARCHAR(128)
, etatCommande VARCHAR(32)
, eMailClient VARCHAR(64)
, idLaboratoire VARCHAR(8)
, CONSTRAINT PK_numCommande PRIMARY KEY(numCommande) 
, CONSTRAINT FK_C_C_eMail FOREIGN KEY (eMailClient) REFERENCES Client 
, CONSTRAINT FK_C_L_idLaboratoire FOREIGN KEY (idLaboratoire) REFERENCES Laboratoire 
);

CREATE TABLE TarifFormat
( idLaboratoire VARCHAR(8)
, idFormat VARCHAR(8)
, idTypePapier VARCHAR(8)
, prixUnitaire  INTEGER(4,2) --  DEC(4,2) 
, CONSTRAINT PK_idL_iF_iTP PRIMARY KEY(idLaboratoire,idFormat,idTypePapier)
);

CREATE TABLE FormatPapier
( idFormat VARCHAR(8)
, libelleFormat VARCHAR(32)
, largeur INTEGER(6,2) --  DEC(6,2) 
, hauteur INTEGER(6,2) --  DEC(6,2) 
, CONSTRAINT PK_idFormat PRIMARY KEY(idFormat)
);

CREATE TABLE TypePapier
( idTypePapier VARCHAR(8)
, libelleTypePapier VARCHAR(32)
, CONSTRAINT PK_idTypePapier PRIMARY KEY(idTypePapier)
);

CREATE TABLE Tirage
( numCommande VARCHAR(8)
, numTirage INTEGER(4)
, idFormat VARCHAR(8)
, idTypePapier VARCHAR(8)
, CONSTRAINT PK_nC_nT PRIMARY KEY(numCommande,numTirage) 
, CONSTRAINT FK_T_FP_iF FOREIGN KEY (idFormat) REFERENCES FormatPapier
, CONSTRAINT FK_T_TP_iTP FOREIGN KEY (idTypePapier) REFERENCES TypePapier 
);

CREATE TABLE TirageImages
( numCommande VARCHAR(8)
, numTirage INTEGER(4)
, idAlbum INTEGER(4)
, numImage INTEGER(4)
, quantite INTEGER(4)
, CONSTRAINT PK_nC_nT_iA PRIMARY KEY(numCommande,numTirage,idAlbum,numImage) 
);


-- q2
ALTER  TABLE Laboratoire ADD (chiffreAffaire INTEGER(30) ) ;

SELECT * FROM laboratoire;

