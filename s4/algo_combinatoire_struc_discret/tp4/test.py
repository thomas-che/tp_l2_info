G = {
    "a": {"b": 1, "c": 2},
    "b": {"a": 1, "f": 5, "c": 10},
    "c": {"a": 2, "b": 10, "f": 2, "e": 4},
    "d": {"f": 8, "e": 3},
    "e": {"c": 4, "d": 3},
    "f": {"b": 5, "c": 2, "d": 8}
}

for u in G:
    for v in G[u]:
        print("L'arête (%s,%s) a pour poids %d" % (u, v, G[u][v]))

print("################################################\n\n\n")

from priority_dict import priority_dict

F = priority_dict() # F est maintenant définie comme une file de priorité

F['x'] = 30 # l'élément x a pour clé 30
F['y'] = 10
F['z'] = 20

while F:
	u = F.pop_smallest()
	print(u)
	if u=='y':
		F['x'] = 5
