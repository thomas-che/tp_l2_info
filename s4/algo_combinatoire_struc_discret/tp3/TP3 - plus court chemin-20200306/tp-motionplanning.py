# coding: utf-8

import tkinter as tk
from threading import Event, Thread
from GUI import MotionPlanning
from priority_dict import priority_dict
import pickle


def creerObstaclesEtGraphesVisibilite(w,h,file=None):
	""" Cette fonction retourne une liste de polygones, où chaque polygone
		est représenté par une liste de coordonnées (x,y) de ses sommets,
		où 0<=x<=w et 0<=y<=h.
		Exemple: [[(Ax1,Ay1), (Ax2,Ay2), ..., (Axk,Ayk)], [(Bx1,By1), (Bx2,By2), ..., (Bxt,Byt)], ...]
		La fonction retourne aussi la position initiale du robot (x,y) et la cible à atteindre (x,y).
		La fonction retourne le graphe de visibilité pondéré.
	"""
	with open(file, "rb") as fichier:
		(polygons, positionRobot, positionSortie, G) = pickle.load(fichier)

	return polygons, positionRobot, positionSortie, G


#correction
DIST=0
PERE=1

def dijkstra(G,posInit):


	attribut=dict()
	for v in G:
		attribut[v]= [ float('+infinity'), None] #[dsitance,pere]
	attribut[posInit][DIST]=0

	F= priority_dict() #cree file prioriter

	# on peuple la file de prioriter avec las sommet et leur distance
	for v in G:
		F[v]=attribut[v][DIST]	

	while F:
		u=F.pop_smallest() #extraire le sommet de plus petit distance
		for v in G[u]:
			#relacher
			if attribut[v][DIST] > (attribut[u][DIST] + G[u][v]) :
				attribut[v][DIST]=attribut[u][DIST] + G[u][v]
				F[v]=attribut[v][DIST]	 # mise a jour des poids dans la file			
				attribut[v][PERE]=u
	return attribut


def chemin(gui, G, posInit, posFinal):
	""" cette fonction prend en entrée l'interface graphique gui;
	le graphe de visibilité G, le sommet de départ du robot (posInit)
	et le sommet d'arrivée posFinal """

	# Si vous souhaitez cacher les arêtes du graphes, supprimez les 3 lignes suivantes (ou mettez les en commentaires)
	for u in G:
		for v in G[u]:
			gui.drawLine(u,v)

	# Commencer par programmer l'algorithme de Dijkstra
	# puis faire parcourir le plus court chemin par Oscar en utilisant la fonction gui.deplacer_oscar(v)

	######################################################################################
	# à vous de jouer ci-dessous ! Vous pouvez programmer d'autres fonctions si besoin   #
	######################################################################################
	
	attr=dijkstra(G,posInit)

	# on part posFinal et remonde les pere
	chemin=[posFinal]	
	p=attr[posFinal][PERE]

	while p != posInit:
		chemin.append(p)	
		p=attr[p][PERE]
	chemin.reverse()
	print(chemin)

	for v in chemin:
		gui.deplacer_oscar(v)


	'''  MOI
	F= priority_dict()
	

	for u in G:
		for v in G[u]:
			F[ v ]=[ float('inf') , None ]			
			print (v,F[v])	

	while F:
		u=F.smallest()
		du=F[u][0]
		pu=F[u][1]
		u=[u,du,pu]
		print("#### u=",u)
		t=F.pop_smallest()

		for v in G[u[0]]:
			dv=F[v][0]
			pv=F[v][1]
			v=[v,dv,pv]
			print("---- v",v)
			print("---- u",u)
			print(G[ u[0] ][ v[0] ])
			relacher( u , v , G[ u[0] ][ v[0] ] )
		break
	'''	

''' moi
def relacher(u,v,w):
	if (u[1]> (v[1] + w)):
		pass
'''


if __name__ == '__main__':
	# RIEN A MODIFIER ICI (excepté pour choisir la scene: scene1.pickle OU scene2.pickle)
	root = tk.Tk()
	width,height = 800,600
	polygons, posInit, posFinal, graphe = creerObstaclesEtGraphesVisibilite(width,height,"scene1.pickle")
	gui = MotionPlanning(root, width, height, polygons, posInit, posFinal)
	
	# Launch a Thread running the main program to move the robot
	def runwrapper():
		chemin(gui, graphe, posInit, posFinal)
	th = Thread(target=runwrapper)
	th.daemon = True
	root.after(100, th.start)

	root.mainloop()

