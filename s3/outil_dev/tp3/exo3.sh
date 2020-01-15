#! /bin/bash

fic=/home/thomas/Documents/tp_l2_info/outil_dev/atelier/data/data/txt/cyrano.txt
#fic= /outil_dev/atelier/data/data/txt/cyrano.txt

nbligne=$(cat  $fic |wc -l)
# seq => affiche de 0 a $nbligne que l on ecrit dans un fichier
seq $nbligne > nbligne.txt
# paste colle la ligne i de chaque fichier a la suite
paste nbligne.txt $fic
