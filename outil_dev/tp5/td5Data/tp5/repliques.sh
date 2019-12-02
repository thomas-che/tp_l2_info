#! /bin/bash


#grep "^[A-Z][A-Z ]*.*:" cyrano.txt | cut -d'(' -f1 | cut -d':' -f1 | cut -d' ' -f1,2,3,4,5  | sort | uniq -c


grep "^[A-Z][A-Z ]*:" cyrano.txt | cut -d':' -f1 >f1.txt

grep "^[A-Z][A-Z ]*(.*):" cyrano.txt | cut -d'(' -f1 >>f1.txt

grep -o "^[A-Z][A-Z ]*[A-Z]" f1.txt | sort | uniq -c | sort -k1 -nr
