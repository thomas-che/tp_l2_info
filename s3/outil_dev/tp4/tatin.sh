#! /bin/bash

#fichier=$1

#while read ligne ; do
#	while read  mot ; do
#		mot <<tatinInv
#	done< wc -w $ligne
#done < $1
#cat tatinInv

### correction

# savoir si lit en enter standard ou en argument $1
if [ $# -eq 1 ] ; then
	nomfic=$1
else
	read nomfic
fi
# pb avec choix donc force le choix
monfic=$1

while read ligne ; do
	nbm=$(echo $ligne | wc -w )
	phrase=''
	for i in $(seq $nbm -1 1) ; do
		mot=$(echo $ligne | cut -d' ' -f$i)
		phrase="$phrase $mot"
	done
	echo $phrase
done< $monfic

