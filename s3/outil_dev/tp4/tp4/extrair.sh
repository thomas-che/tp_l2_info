#! /bin/bash

#### crrection

if [ $# -ne 2 ] ; then
	echo"pb nom fichier"
	exit 1
fi

monfic=$1
nomextr=$2
encour=0
while read ligne ; do
	if [ $encour -ne 1 ] ; then
		mot1=$(echo $ligne | cut -d' ' -f1)
		mot2=$(echo $ligne | cut -d' ' -f2)
		if [ "$mot1" = "###" ] ; then
			if [ "$mot2" = "BEGIN" ] ; then
				mot3=$(echo $ligne | cut -d' ' -f3)
					if [ "$mot3" = "$nomextr" ] ; then
						encour=1
					fi
			fi
		fi
	else
		mot1=$(echo $ligne | cut -d' ' -f1)
		if [ "$mot1" = "###" ] ; then
			mot2=$(echo $ligne | cut -d' ' -f2)
			if [ "$mot2" = "END" ] ; then
				encour=0
				exit 0
			fi
		fi

		# on cherche a suprimer le prefix

		#prefix="# "
		#rest=${$ligne#$prefix}
		#echo $reste

		nbm=$(echo $ligne | wc -w)
		phrase=""
		for i in $(seq 2 $nbm) ; do
			mot=$(echo $ligne | cut -d' ' -f$i)
			phrase="$phrase $mot"
		done
		echo $phrase
	fi
done < $monfic






## pr inclure

# tmpfile est une copie du conteneur dans tmp

cp conteneur $tmpfile

while read ligne ; do
	echo "# $ligne">>tmpfile
done < $1
mv $tmpfile conteneur



##################### ou

# pas fini
lignedebut="### BEGIN $nomextr"
lignefin="### END"


while read ligne ; do
	if [ $encour -ne 1 ] ; then
		#mot1=$(echo $ligne | cut -d' ' -f1)
		#mot2=$(echo $ligne | cut -d' ' -f2)
		if [ $ligne = $lignedebut ] ; then
			
						encour=1
					fi
			fi
		fi
	else
		if [ "$mot1" = "###" ] ; then
			mot2=$(echo $ligne | cut -d' ' -f2)
			if [ "$mot2" = "END" ] ; then
				encour=0
				exit 0
			fi
		fi

		# on cherche a suprimer le prefix

		#prefix="# "
		#rest=${$ligne#$prefix}
		#echo $reste

		nbm=$(echo $ligne | wc -w)
		phrase=""
		for i in $(seq 2 $nbm) ; do
			mot=$(echo $ligne | cut -d' ' -f$i)
			phrase="$phrase $mot"
		done
		echo $phrase
	fi
done < $monfic
