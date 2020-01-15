#! /bin/bash

#moi fontionne pas
rep=/etc/passwd
var=0
for i in $(cat /etc/passwd | wc -l ) ; do
	var=$((var+2))
	cat $rep | head -n $var | tail -n $var

done
echo finnnnnn

## prof
longeur=$(cat /etc/passwd | wc -l)
nboc=$((longeur/2))
for i in $(seq $nboc) ; do
	nl=$((i*2)) 
	cat /etc/passwd | head -n $nl | tail -n 1
done
