#! /bin/bash

fic=$1

#debut=$(grep  "^\*\* START[.]*\*\*" $fic | cut -d' ' -f 1)
#cat $debut

#correction

debut=$(grep -n "^** STRAT OF" $fic | cut -d':' -f 1)


fin=$(grep -n "^** END OF" $fic | cut -d':' -f 1)

head -n $(($fin-1)) $fic | tail -n $(($debut+1)) > fic_clear.txt

cat fic_clear.txt | tr -d '\r' > fic_clear.txt

cat fic_clear.txt

