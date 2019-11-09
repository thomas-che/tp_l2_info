#! /bin/bash

#prof

rep=dataTP3/haddock/
for i in $(ls $rep) ; do #utilise le resultat d une commande ex: $(ls $rep)
 nl=$(cat $rep$i | wc -l)
 nc=$(cat $rep$i | wc -c)
 pro$(ls -l $res$i |tr -s ' '|cut -d' ' -f 3)
 echo $i $nl $nc $pro
done
