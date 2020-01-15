#!/bin/bash

if [ $# -eq 1 ] ; then
	nomfic=$1
else
	read nomfic
fi


while read ligne ; do
	# nombre de mots de la ligne
	nbm=$(echo $ligne | wc -w)
	phrase=''
	for i in $(seq $nbm -1 1); do
		# on extrait le mot de rang i
		mot=$(echo $ligne | cut -d' ' -f$i)
		# on le colle en fin de phrase
		phrase="$phrase $mot"
	done
	echo $phrase
done < $nomfic
