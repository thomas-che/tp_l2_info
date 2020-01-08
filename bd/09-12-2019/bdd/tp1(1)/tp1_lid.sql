-- q1
SELECT prenomcli "PRENOM",nomcli "NOM" FROM client ORDER BY nomcli;

-- q2
SELECT codeact "CODE", nomact "NOM", valeurcourante "VALEUR" FROM action;

--q3
SELECT * FROM action WHERE valeurcourante=(SELECT max(valeurcourante) "MAX"FROM action) OR valeurcourante=(SELECT min(valeurcourante) "MIN" FROM action) ORDER BY valeurcourante DESC;

--q4
SELECT * 
  FROM 
    (SELECT numcli FROM client WHERE prenomcli='Pierre' and nomcli='Leloup') 
  NATURAL JOIN 
    possedeaction
      NATURAL JOIN action;

SELECT * FROM action NATURAL JOIN ( possedeaction NATURAL JOIN (SELECT numcli FROM client WHERE prenomcli='Pierre' and nomcli='Leloup'));

-- q5 manquait le *quantite
SELECT sum(quantite*(valeurcourante-prixachat)) as GAINPERTE
  FROM 
    (SELECT numcli FROM client WHERE prenomcli='Pierre' and nomcli='Leloup') 
  NATURAL JOIN 
    possedeaction
      NATURAL JOIN action;
