
# n sed pas bavad ; p afifiche le motif
# s = substitution
sed -n 's/AAA/ZZz/gp' f1.txt

# suprime la ligne ou il y a un 2 avec le d
sed '/2/d' fic.txt
