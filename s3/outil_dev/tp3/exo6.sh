#! /bin/bash

rep=dataTP3/haddock/
for i in $(ls $rep) ; do #utilise le resultat d une commande ex: $(ls $rep)
 head -n 3 $rep$i >> resume.txt #concatene chemin : $rep$i
done
cat resume.txt
