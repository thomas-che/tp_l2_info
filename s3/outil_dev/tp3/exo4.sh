#! /bin/bash

#un=42
un=$1
while [ $un -ne 1 ] ; do
echo $un
if [ $((un%2)) -eq 0 ] ; then #attention syntaxe du if
un=$(($un/2))
else
un=$(($un*3 +1))
fi
done
echo $un
