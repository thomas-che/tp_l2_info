#! /bin/bash

nblignenom=$(cat dataTP3/haddock/noms | wc -l)
lignenom=$(($RANDOM%$nblignenom))
nom=$(tail -n $lignenom dataTP3/haddock/noms | head -n 1 )
nblignequali=$(cat dataTP3/haddock/qualificatifs |wc -l)
lignequali=$(($RANDOM%$nblignequali))
quali=$(tail -n $lignequali dataTP3/haddock/qualificatifs | head -n 1)
echo $nom $quali

# peux aussi faire des fonction

hasard() {
	fic=$1
	nbligne=$(cat $fic |wc -l)
	ligne=$(($RANDOM%$nbligne))
	tail -n $ligne $fic |head -n 1
} 

nom=$(hasard dataTP3/haddock/noms)
quali=$(hasard dataTP3/haddock/qualificatifs)
echo $nom $quali
