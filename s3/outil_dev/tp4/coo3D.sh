#! /bin/bash

coo1=$1
coo2=$2

cat coo1 | sort >coo1Trier
cat coo2 | sort >coo2Trier

join coo1Trier coo2Trier

# affiche les coo en commun
# Si affiche rien alors pas de coo en commun
 
