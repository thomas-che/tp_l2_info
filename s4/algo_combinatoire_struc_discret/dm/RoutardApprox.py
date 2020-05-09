# -*- coding: utf-8 -*- 

# Pour la file de priorité
from priority_dict import priority_dict

# Pour le choix aleatoire d un sommet de depart pour Prim
import random


def RoutardApprox(G):
    l=prim(G)
    parcousPrefixe(l[0],l[1])


def prim(G):
    """ calcule un ACM du graphe stocké sur le serveur en utilisant l'algorithme de Prim """

    F = priority_dict() # init file priorite

#test
    # sommet racine choisit arbitrairement
    r = next(iter(G)) # recupere le premier sommet dans le graphe G
    print(r)

    F[r] = 0 

    sommet_atteint = set() # init sommets decouvert 
    sommet_atteint.add(r) # ajout de r a l ensemble des sommets atteint

    pere = dict() # init pere
    pere[r] = None # pere du premier = rien

    weight = dict() # init pour stocker le poids entre 2 sommets, cela evite de le redemander au serveur a la fin pour calculer le poids w de l arbre couvrant

    list_sommet_extrait = [] # init liste des sommets extrait 

    while F :
        u = F.pop_smallest()
        list_sommet_extrait.append(u) # ajout de u a la fin de la liste des sommets extrait

        for v in getNeighbors(G,u):
            if v not in sommet_atteint:
                sommet_atteint.add(v) # si pas atteint alors on l ajoute a l essemble atteint
                F[v] = float('+infinity') # on l ajoute dans la file de prioriter avec comme valeur : +oo

            weight_u_v = getWeight(G,u,v) # stocke dans une var le poids entre u et v
            if v in F and weight_u_v<F[v] :
                pere[v] = u # ajoute(ou modifie si deja existant) au dictionaire pere, le pere du sommet v
                F[v] = weight_u_v # modifie le poids de v 
                weight[(u,v)] = weight_u_v # stocker le poids entre u et v

    # Calcul du poids w de l arbre couvrant
    w=0 # init du poids a 0

    list_pere_sommet=list() # init liste pere sommet
    for sommet in list_sommet_extrait:
        list_pere_sommet.append([pere[sommet],sommet]) # on ajoute a la fin de la lite une liste tel que : le premier element est le pere et le second est le sommet

#test    
    print("algo prim = ", list_sommet_extrait)
    print("list pere sommet = ", list_pere_sommet)
    return [list_sommet_extrait,list_pere_sommet] # return liste chronologique des sommets atteint, la liste des [pere[sommet], sommet]
    


def getNeighbors(G,u):
    '''retourne la liste des voisins d'un sommet u'''
    neighbors = []
    for v in G[u]:
        neighbors.append(v)
    return neighbors

def getWeight(G,u,v):
    '''retourne le poids de l'arête (u,v)'''
    return G[u][v]



def parcousPrefixe(l_prim, l_pere_fils):
    '''Pour le parcours préfixe, il est certainement plus facile d’avoir, pour chaque sommet, la liste de ses fils'''
    
    dic_voisin = dict() # init du dictionaire des voisin selon apres l execution de prim

    for sommet in l_pere_fils: 
        PERE=sommet[0] # init de pere
        SOMMET=sommet[1] # init de la 'contante' FILS

        if PERE != None : # pour ne pas avoir la racine comme fils, car par definition elle n as pas de pere

            if PERE in dic_voisin : 
                l_tmp = dic_voisin[PERE] # il y a deja une liste avec des voisins dans dic_voisin donc on la stoke temporairement dans une liste
                l_tmp += [SOMMET] # on y a joute nouveau voisin sommet
                dic_voisin[PERE] = l_tmp # puis on reset le dictionaire la clef PERE avec sa nouvelle liste de voisin
            else :
                dic_voisin[PERE] = [SOMMET] # si PERE n a pas encore de voisin alors on l ajoute au dict

    # pour initialiser les feuilles de l abre couvrant a une liste vide
    for sommet in l_prim: 
        if sommet not in dic_voisin:
            dic_voisin[sommet] = []

    print("\nliste pere fils = ", dic_voisin)


    ordre = list()
    racine = next(iter(dic_voisin))
    ordre.append(racine)

    rect_ordre(racine, dic_voisin, ordre)

    print("\n liste ordre prefixer =",ordre)



def rect_ordre (pere, dic_voisin, ordre):

    print("##== pere :",pere, " ; \n##==dict :",dic_voisin," ; \n##==ordre :",ordre)


    if dic_voisin[pere] :

        for fils in dic_voisin[pere]:
            print("===>> fils", fils)
            ordre.append(fils)
            ordre = rect_ordre(fils, dic_voisin, ordre)
            print("ORDE",ordre)

        print("<< fin for >>")
        return ordre
    else :
        print("<< dans le else >>")
        return ordre


if __name__ == "__main__":
    pass
