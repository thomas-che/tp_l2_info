# -*- coding: utf-8 -*- 


from RoutardApprox import RoutardApprox
import json


if __name__ == "__main__":


	for ficgraphe in ["graphe_th3.json"]:

		print("\n\n ==> graphe : ",ficgraphe," <==\n")

		with open(ficgraphe, "r", encoding="utf-8") as fichier:
			G = json.load(fichier)

		cycle = RoutardApprox(G)
		
print("\n==> end")