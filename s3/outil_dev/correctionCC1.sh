#corretion cc continue outil dev

#ex1
rwr wr r
rwxrrxrx

#ex2
ls -l data | tr -s ' ' | cut -d' ' -f3,5,9 | sort -nk 2

#ex3
date | tr -s ' ' | cut -d' ' -f3

#ex4
find -type f data |wc -l
# ou
cpt=0
lf=$(ls data)
for i in $lf; do
  if [ -f $i ] ; then
	cpt=$((cpt+1))
  fi
done 

#ex5
# on descend '.' dans le rep courrant ; xarg permet de les prendres et de les metre en parametre du chmod
find . -type d | xarg chmod og -x

#ex6
heure=$(date | tr -s ' ' | cut -d' ' -f5)
h=$(echo $heure | cut -d' ' -f1)
m=$(echo $heure | cut -d' ' -f2)
s=$(echo $heure | cut -d' ' -f3)
echo "jfoiajefh"$h...

#ex7
cpt=0
while read ligne ; do
  if [ $cpt -lt 10 ] ; them
	echo $ligne
	cpt=$((cpt+1))
  else
	break
  fi
done < poeme


#ex8
nb1=$(find data1 -type f -maxdepth1 | wc -l)
nb1=$(find data2 -type f -maxdepth1 | wc -l)

if [ $nb1 -eq $nb2 ] ; them
  echo "egaux"
else if [ $nb1 -gt $nb2 ] ; then
  echo "data1"
else
  echo "data2"
fi

#ex9
read n
if [ $n -lt 0 ] ; then
  echo "n<0"
else if [ $n -eq 0 ] ; then
  echo "n=0"
else
  seq n
fi






