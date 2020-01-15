#! /bin/bash

#chemin=$(/home/thomas/Documents/tp_l2_info/outil_dev/atelier/data/data/cuisine)

#join $chemin/rp $chemin/pp | cut -d' ' -f2,4 | tr ' ' '*' | bc


#correction

tail -n +3 prix | sort | tr -s ' ' >Prix
tail -n +3 recette |sort | tr -s ' ' >Recette
join Recette Prix | cut -d' ' -f2,4 >RP
# join Recette Prix | cut -d' ' -f2,4 | tr -s ' ' '*' | sed...


som=0
#on lit RP et on prend pr chaque ligne le 1er mot et soquer dans q , 2eme mot dans p
while read q p; do
	som=$(echo "$som+$q*$p" | bc )
done <RP
echo $som

# essayer sed avec \n
