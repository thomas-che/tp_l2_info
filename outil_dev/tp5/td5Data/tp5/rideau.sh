#! /bin/bash

grep -n "^Rideau" cyrano.txt >acte_rideau.txt

grep -n "^Acte" cyrano.txt >>acte_rideau.txt

grep -n "^Scène" cyrano.txt >>acte_rideau.txt

cat acte_rideau.txt | sort -n 


# correction
#egrep -n "^(Acte|Scène|Rideau)" cyrano.txt
