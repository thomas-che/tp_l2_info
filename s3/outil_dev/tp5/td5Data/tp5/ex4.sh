#! /bin/bash

# $1 nom : fichier
# $2 nom : de la scene

# memorise les nb de ligne
egrep -n "^(Acte|Scène|Rideau)" $1 > /tmp/ligne

# 
scene="Scène $2[.]"
lignetemp=$(egrep -n "$scene" /tmp/ligne | cut -d':' -f1) 
ligneDebut=$( cat /tmp/ligne | head -n $lignetemp | tail -n 1 | cut -d':' -f1)
ligneFin=$( cat /tmp/ligne | head -n $((lignetemp+1)) | tail -n 1| cut -d':' -f1)

cat $1 | head -n $((ligneFin-1)) | tail -n +$ligneDebut > /tmp/scene

./repliques.sh /tmp/scene
