-- q1
SELECT nompers,prenompers FROM personne JOIN (SELECT numperspere FROM perede GROUP BY numperspere HAVING 2<=count(*)) ON numpers=numperspere;


-- q2 correction les grand mere
SELECT * from personne where numpers in (SELECT  numpersmere from merede where numpersenfant in (select numperspere from perede union select numpersmere from merede) );

-- q3
SELECT nompers,prenompers
  FROM personne
  NATURAL JOIN
    (SELECT numperspere numpers FROM perede
      NATURAL JOIN
        (SELECT numpers numpersenfant FROM personne WHERE nompers='Durand' and prenompers='Paul')
    )
;

-- q4 pb poure retiere janne
SELECT *
  FROM personne 
  NATURAL JOIN
    (SELECT numpersenfant numpers FROM merede 
      NATURAL JOIN 
        (SELECT numpersmere FROM merede
          NATURAL JOIN
            (SELECT numpers numpersenfant FROM personne WHERE nompers='Dupont' and prenompers='Jeanne')
        )
    )
;

-- q5 correction
create or replace view marmaille(numpersmere,nbenfant) as
  select numpersmere, count(*)
  from merede
  group by numpersmere;
  
select *
from personne
where numpers in
( select numpersmere
  from marmaille 
  where nbenfant=(select max(nbenfant) from marmaille)
)
;

-- q6 correction
select * 
  from personne 
    where numpers not in 
    (select numperspere 
      from perede 
    union 
    select numpersmere 
      from merede
    )
;

-- q7 correction
create or replace view coupledeparent(numperspere,numpersmere) as
  select distinct numperspere, numpersmere 
  from perede natural join merede;
  
select * 
  from personne
  where numpers in
  ( select numperspere
      from coupledeparent
        group by numperspere
          having count(*)=1
    union
    select numpersmere
      from coupledeparent
        group by numpersmere
          having count(*)=1
  )
;

-- q8
CREATE OR REPLACE VIEW numenfant(numperspere) AS
  SELECT numpersenfant
      FROM perede
  ;

SELECT * 
  FROM personne
  WHERE numpers in 
    ( SELECT numperspere 
        FROM perede  
        WHERE numperspere not in
          ( SELECT *
              FROM numenfant
          )
      UNION
      ( SELECT numpersmere 
          FROM merede  
          WHERE numpersmere not in
            ( SELECT *
                FROM numenfant
            )
      )
    )
;

-- q9 marche pas
CREATE OR REPLACE VIEW numenfantp(numperspere) AS
  SELECT numpersenfant
      FROM perede
  ;
  
CREATE OR REPLACE VIEW numenfantm(numpersmere) AS
  SELECT numpersenfant
      FROM merede
  ;  
  
-- durrant monique ; durant pierre
SELECT * 
  FROM personne
  WHERE numpers in 
    ( SELECT numperspere 
        FROM perede  
        WHERE numperspere not in
          ( SELECT *
              FROM numenfantp
          )
      UNION
      ( SELECT numpersmere 
        FROM merede  
        WHERE numpersmere not in
          ( SELECT *
              FROM numenfantm
          )
      )
    )
;



SELECT * 
        FROM merede  
        WHERE numpersmere not in
          ( SELECT *
              FROM numenfantp
          );



SELECT * 
        FROM perede  
        WHERE numperspere not in
          ( SELECT *
              FROM numenfantp
          );


-- q10
CREATE OR REPLACE VIEW frere(numpersenfant) AS
  SELECT count(*)=1 nb
    FROM perede GROUP BY numperspere 
  ;

SELECT * 
  FROM personne
  WHERE numpers in
    (SELECT numpersenfant numpers
      FROM
      (SELECT numpersenfant 
        FROM perede
          NATURAL JOIN 
            (SELECT numperspere FROM 
                (SELECT numperspere,count(*) nbenfant
                  FROM perede 
                    GROUP BY numperspere
                )
                WHERE nbenfant=1
            )
      union  
      SELECT numpersenfant 
        FROM merede
          NATURAL JOIN 
            (SELECT numpersmere FROM 
                (SELECT numpersmere,count(*) nbenfant
                  FROM merede 
                    GROUP BY numpersmere
                )
                WHERE nbenfant=1
            )
      )
    )
;

