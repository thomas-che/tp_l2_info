#! /bin/bash

binaire='110110'
res=0
pui=0
cal=$(($pui+2))
echo $cal
echo ${#binaire}
echo $(echo $binaire |  cut -c 1)
long=${#biniare}
while [ $long -ne 1 ] ; do
	num=$(echo $binaire | cut -c $long)
	res=$((res+num**pui))
	long=$((long-1))
	pui=$((pui+1))
	echo $long
	echo $res
	exit
done


echo $binaire
echo $ress

exit

####prof

binaire=110110
puiss=1
dec=0
while [ $binaire -ne 0 ] ;do
	if [ $((binaire%2)) -eq 1 ] ; then
		dec=$((dec+puiss))
	fi
	binaire=$((binaire/10))
	puiss=$((puiss*2))
	echo $dec
done
