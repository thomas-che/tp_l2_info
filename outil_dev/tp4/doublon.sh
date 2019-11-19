#! /bin/bash

fichier=$1
cat $fichier | sort >fichierTrier
compteur=0
oldcompteur=1
doublon=""
oldl="" # valeur par default
while read l ; do
	# on considere que $oldl est une chaine de char avec ".."
	# $l est deja considere comme une caine de char car on fait un read
	if [ $l = "$oldl" ] ; then
		compteur=$((compteur+1))
		if [ $oldcompteur -lt $compteur ] ; then
			doublon=$l
			oldcompteur=$compteur
		fi
	else
		compteur=0
	fi
	oldl=$l
done <fichierTrier
echo $doublon" est le doublon le plus recurant avec "$oldcompteur" fois"

exit
#### correction
fichier=$1

cat $fichier | sort | uniq -c | sort -nr | head -n 1
 
