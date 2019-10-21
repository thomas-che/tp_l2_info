#! /bin/bash

#/home/thomas/Documents/tp_l2_info/outil_dev/atelier/data/data/txt/cyrano.txt
fic= /outil_dev/atelier/data/data/txt/cyrano.txt

nbligne=$(cat  $fic |wc -l)
seq $nbligne > nbligne.txt
paste nbligne.txt $fic
