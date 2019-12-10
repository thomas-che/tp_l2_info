#! /bin/bash


#grep "^[A-Z][A-Z ]*.*:" cyrano.txt | cut -d'(' -f1 | cut -d':' -f1 | cut -d' ' -f1,2,3,4,5  | sort | uniq -c


grep "^[A-Z][A-Z ]*:" $1 | cut -d':' -f1 >f1.txt

grep "^[A-Z][A-Z ]*(.*):" $1  | cut -d'(' -f1 >>f1.txt

grep -o "^[A-Z][A-Z ]*[A-Z]" f1.txt | sort | uniq -c | sort -k1 -nr | head -n5


# correction V2

#grep "^[A-Z][A-Z ]*(.*):$" cyrano.txt | cut -d'(' -f1 >tmp/avec
#grep "^[A-Z][A-Z ]*:$" cyrano.txt | tr -s ':' ' ' >tmp/sans
#(cat tmp/avec ; cat tmp/sans ) >tmp/global
#cat tmp/global | sort | uniq -c | sort -nr | head -n5
