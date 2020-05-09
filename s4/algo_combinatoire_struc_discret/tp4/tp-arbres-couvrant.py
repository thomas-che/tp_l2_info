# -*- coding: utf-8 -*- 

from utils import connectSocket, closeSocket, sendcmd, recvcmd
from utils import getWeight, getNeighbors, getAVertex, Cookie, SpanningTreeWeight

# Pour la file de priorité de Prim
from priority_dict import priority_dict

# The union-find data-structure is used by Kruskal algorithm
from UnionFind import UnionFind


# ---------------------------------------------------------------------------------------------------
def ACM_Prim():
    """ calcule un ACM du graphe stocké sur le serveur en utilisant l'algorithme de Prim """

    F = priority_dict() #init file priorite
    r = getAVertex() # recupere un somet au hazard
    F[r] = 0 

    sommet_atteint = set() # init sommets decouvert 
    sommet_atteint.add(r) # ajout de r a l ensemble des sommets atteint

    pere = dict() # init pere
    pere[r] = None # pere du premier = rien

    weight = dict() # init pour stocker le poids entre 2 sommets, cela evite de le redemander au serveur a la fin pour calculer le poids w de l arbre couvrant

    while F :
        u = F.pop_smallest()
        for v in getNeighbors(u):
            if v not in sommet_atteint:
                sommet_atteint.add(v) # si pas atteint alors on l ajoute a l essemble atteint
                F[v]=float('+infinity') # on l ajoute dans la file de prioriter avec comme valeur : +oo

            weight_u_v = getWeight(u,v) # stocke dans une var le poids entre u et v
            if v in F and weight_u_v<F[v] :
                pere[v]=u # ajoute(ou modifie si deja existant) au dictionaire pere, le pere du sommet v
                F[v]=weight_u_v # modifie le poids de v 
                weight[(u,v)] = weight_u_v # stocker le poids entre u et v

    # Calcul du poids w de l arbre couvrant
    w=0 # init du poids a 0
    for s in sommet_atteint:
        if s != r:
            w += weight[(pere[s],s)] # somme des poids des arrets 
    
    # test si le poid de l arbre couvrant est bien le min
    SpanningTreeWeight(w) 



# ---------------------------------------------------------------------------------------------------


# ---------------------------------------------------------------------------------------------------
def ACM_Kruskal(G):
    """ calcule un ACM du graphe G en utilisant l'algorithme de Kruskal"""
    pass


# ---------------------------------------------------------------------------------------------------


if __name__ == "__main__":
    """ Il n'y a rien à modifier ci-dessous, excepté l'appel à ACM_Prim() ou à
    ACM_Kruskal(G) en définissant le graphe au préalable """

    # connexion au serveur
    connectSocket("distrigraphes.info-orleans.fr", 6667)

    ACM_Prim()  # peut être mis en commentaire si nécessaire

    sendcmd('stop', '')
    closeSocket()

    #G = {}  # graphe vide
    #ACM_Kruskal(G)
