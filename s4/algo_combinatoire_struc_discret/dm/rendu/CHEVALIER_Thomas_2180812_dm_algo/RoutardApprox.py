# -*- coding: utf-8 -*- 

# Pour la file de priorité
from priority_dict import priority_dict

# Pour avoir un nb aleatoir
import random

#Pour afficher le graphe
# import numpy as np
# import matplotlib.pyplot as plt
# plt.close('all')


def RoutardApprox(G):
    l = prim(G)
    liste_ordre_prefixe = parcousPrefixe(l[0],l[1])
    sigma = ordreParcourSommet(G, liste_ordre_prefixe)
    
    #print(sigma)
    #w = calcPoidListSommet(G,sigma)
    #print("\n\n==> poids du chemin pas a pas : =>",w,"<=\n")

    #testConstruireGrapheDifficile()
    


def prim(G):
    """ calcule un ACM du graphe stocké sur le serveur en utilisant l'algorithme de Prim """

    F = priority_dict() # init file priorite

    # sommet racine choisit arbitrairement
    r = next(iter(G)) # recupere le premier sommet dans le graphe G

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

    

    list_pere_sommet=list() # init liste pere sommet
    for sommet in list_sommet_extrait:
        list_pere_sommet.append([pere[sommet],sommet]) # on ajoute a la fin de la lite une liste tel que : le premier element est le pere et le second est le sommet

#test    
    #print("algo prim = ", list_sommet_extrait)
    #print("\nlist pere sommet = ", list_pere_sommet)

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

    #print("\nliste pere fils = ", dic_voisin)


    liste_ordre = list() # init de la liste des sommets selon l ordre prexie
    racine = next(iter(dic_voisin)) # choisi comme racine le premier element extait dans l exec de Prim, qui est donc la racine dans celui-ci egalement
    liste_ordre.append(racine) # on le rajoute a la liste

    # appel de la fonction recursive pour cree l ordre prefixe
    rectListOrdre(racine, dic_voisin, liste_ordre)

    #print("\n liste liste_ordre prefixer =",liste_ordre)

    return liste_ordre


def rectListOrdre (pere, dic_voisin, liste_ordre):
    ''' retourn l ordre prefixe selon le dictionaire passer et en choisisant le premier voisin qui deviendra le premier fils '''

    if dic_voisin[pere] : # on s assure que le pere n est pas en realiter une feuille (= liste vide : [])

        for fils in dic_voisin[pere] :
            liste_ordre.append(fils) # ajout du fils, a la fin, dans la liste d ordre prefixe
            liste_ordre = rectListOrdre(fils, dic_voisin, liste_ordre) # on lance recursivement la fonction avec comme pere le fils qui viens d etre ajoute precedament
        return liste_ordre # retourne la liste mise a jour

    else :
        return liste_ordre # retourne la liste mise a jour



def ordreParcourSommet (G, liste_ordre_prefixe):
    ''' retourne la liste des sommets suivant l ordre prefixer tout en y apliquant le plus court chemin entre chacun des points. On obtient donc un liste des somet a suivre pas a pas pour tous les parcours en un minimum de temps'''

    sigma = list() # init de la liste des sommet a parcour dans l ordre
    sigma.append(liste_ordre_prefixe[0]) # on y ajoute le premier sommet de la liste d ordre prefixe

    i=0 # init d un compteur
    for sommet in liste_ordre_prefixe :

        if i < len(liste_ordre_prefixe)-1 : # test si on est pas a la fin de la liste -1 pour ensuite pouvoir exec dijkstra ( ~ itineraire(..) ) sur le sommet et sommet+1


            chemin = itineraire(G, sommet, liste_ordre_prefixe[i+1]) # on recupere le plus cour chemein entre le sommet et sommet+1 
            del chemin[0] # retire du chemin le premier sommet qui est deja dans sigma
            sigma += chemin # ajoute a la fin chemin a la liste sigma
        i+=1

    # On referme le cycle σ en revenant au point de départ
    chemin = itineraire(G, sigma[len(sigma)-1], sigma[0])
    del chemin[0]
    sigma += chemin
    #print("\nsigma =",sigma)
    
    return sigma




def dijkstra (G, pos_init):
    ''' retourne un dictionaire avec la plus petite distance a partir de la position inital jusqu'a chaque sommet du graphe G '''

    POID=0 # init constante poid ~ l[0]
    PERE=1 # init constante pere ~ l[1]

    attribut = dict() # init du dict attribut pour y stocker le poid et le pere

    for v in G:
        attribut[v] = [ float('+infinity'), None] # on fixe pour chaque sommet une POIDante a +oo et un pere a None


    attribut[pos_init][POID] = 0 # fixe le premier poid a partir de la position initiale a 0

    F= priority_dict() # cree file prioriter

    # on peuple la file de prioriter avec les sommets et leurs poid respectifs
    for v in G:
        F[v] = attribut[v][POID]	

    while F:

        u = F.pop_smallest() # extrai le sommet avec le plus petit poid
        
        for v in G[u]:

            #relacher
            if attribut[v][POID] > (attribut[u][POID] + G[u][v]) :
                attribut[v][POID] = attribut[u][POID] + G[u][v] # on modifie la poid du sommet v car on a trouver une arete qui reduit la poid pour atteindre v depuis u
                F[v]=attribut[v][POID] # on met a jour les poids dans la file			
                attribut[v][PERE] = u # change le pere de v par u
    return attribut

def itineraire(G, pos_init, pos_final):
    ''' retourne le plus court itineraire entre la position initile et l aposition final'''
    
    PERE=1 # init constante pere ~ l[1]

    attribut = dijkstra(G,pos_init) # on recupere un dictionaire avec la plus petite distance a partir de la position inital jusqu'a chaque sommet du graphe G

    # on part pos_final et remonde les peres
    itineraire = [pos_final]	
    pere = attribut[pos_final][PERE]


    while pere != pos_init:
        itineraire.append(pere) # on ajoute le pere a la liste	
        pere = attribut[pere][PERE] # on affecte au pere son propre pere

    itineraire.append(pos_init) # ajout de la position initial a la liste
    itineraire.reverse() # renverse la liste pour avoir les sommets dans l ordre

    return itineraire


def calcPoidListSommet(G,liste_ordre_sommet) :
    ''' calcule le poid d un chemin donner par la liste d ordre des sommets '''

    w=0 # init du poids a 0
    i=0 # init d un compteur
    for sommet in liste_ordre_sommet :
        
        if i < len(liste_ordre_sommet)-1 :
            w += getWeight(G, sommet, liste_ordre_sommet[i+1])
        i+=1
    
    return w



def ConstruireGrapheDifficile(n) :
    '''contruit un graphe tel que le routard soit 2fois plus long a parcourir le graphe'''
    G = dict()

    # init du dict G avec tout les sommets
    for i in range (0,n):
        nom_sommet = 'S'+str(i)
        G[nom_sommet] = dict()

    sigma = list() # init de la liste du chemin optimal 

    #pour chaque sommet je le lie par une arete a un autre sommet
    for i in range (0,n):
        
        sommet = 'S'+str(i)
        sommet_de_fin = 'S'+str(n-1) # nom du sommet de fin
        sommet_de_fin_1 = 'S'+str(n-2)

        if sommet == 'S0' :
            sigma.append(sommet) # ajout de S0 en premiere position dans la liste, c est le point de depart
            poid = round(random.uniform(100, 1000), 9) # choix d un poid flotant quelconque entre 100 et 1000 avec 9 chiffres apres la vigule 
            reste_poid = poid*2 -1 # varible reste_poid correspond au poid qui reste a distribuer entre tout les sommets de l arbre couvrant ; -1 reserve pour l arete X = Sn -> S1

            voisin = 'S1'
            G = ajoutVoisin(G, sommet, voisin, poid) # Je choisi pour l'arête entre S0->S1 (A) ridiculement petit (1e-9)
            voisin = 'S2'
            G = ajoutVoisin(G, sommet, voisin, poid) # l'arête entre S0->S2 (B) se sera : reste_poid - 1e-9.

        elif sommet == 'S1':
            sigma.append(sommet)
        elif sommet == sommet_de_fin :
            sigma.insert(2, sommet)
            voisin = 'S1'
            poid = calcPoidListSommet(G, itineraire(G,"S2",sommet))+1
            G = ajoutVoisin(G, sommet, voisin, poid)
        elif sommet == sommet_de_fin :
            sigma.insert(2, sommet)
            voisin = 'S1'
            # poid = round(reste_poid, 9) +1
            poid = calcPoidListSommet(G, itineraire(G,"S2",sommet))
            G = ajoutVoisin(G, sommet, voisin, poid)
        else :
            voisin = 'S'+str(i+1) 
            sigma.insert(2, sommet)
            poid = round(random.uniform(0.000000001, (reste_poid//2)), 9)
            reste_poid = round(reste_poid - poid, 9)
            G = ajoutVoisin(G, sommet, voisin, poid)

    # pour avoir un graphe avec plus de lien mais juste pour faire beau
    if 6<=n :
        for i in range(0,n):
            G = ajoutVoisinRandom(G, sommet, n-1)

    sigma.append('S0')
    #print(sigma)
    return [G,sigma]


def ajoutVoisin(G,sommet,voisin,poid):
    '''écrit le lien entre S2 et S3 et réciproquement dans le dictionnaire G puis le retourne'''
    G[sommet][voisin] = poid
    G[voisin][sommet] = poid
    return G

def ajoutVoisinRandom(G, sommet, taille):
    ''' ajoute x voisin a sommet avec un poids supérieur au poids du plus court chemin entre ces sommets '''
    nb_rep = random.randint(0,(taille//2))
    for i in range(0,nb_rep) :
        id_sommet = random.randint(3,taille-2)
        voisin = 'S'+str(id_sommet)
        poid = calcPoidListSommet(G,itineraire(G, sommet, voisin)) + 1
        G = ajoutVoisin(G,sommet,voisin,poid)
    return G





#########################################################################
#                                                                       #
#   partie de test de ConstruireGrapheDifficile + affichage graphe      #
#                                                                       #
#########################################################################                                    

# def testConstruireGrapheDifficile():

#     list_poid_div_sigma = list()

#     for i in range(0,10):
#         print("#####################################")

#         G2,sigma = ConstruireGrapheDifficile(10)
#         l = prim(G2)
#         liste_ordre_prefixe = parcousPrefixe(l[0],l[1])
#         liste_ordre_sommet = ordreParcourSommet(G2, liste_ordre_prefixe)
#         w = calcPoidListSommet(G2,liste_ordre_sommet)
#         print("\n\n routard =", liste_ordre_sommet," ; poids du chemin pas a pas : =>",w,"<=\n")
#         print("\nsimga* : ",sigma," poid ==>", calcPoidListSommet(G2,sigma) ,"<==")
#         poid_div_sigma = w/calcPoidListSommet(G2,sigma)
#         print("\npoid/sigma = ",poid_div_sigma)
#         list_poid_div_sigma.append(poid_div_sigma)


#     print("\n\nla liste : ==>",list_poid_div_sigma,"<==\n\n")

#     summ = 0
#     compteur = 0
#     for i in list_poid_div_sigma :
#         summ += i
#         compteur +=1
#     avg = summ/compteur
#     print("\n avg = ", avg)

    #afficherGraphe(G2)


# def afficherGraphe(G) :
#     ''' pour afficher le graphe G '''
#     X=0
#     Y=1
#     pt = dict()
#     i=0
#     for u in G :
#         x = random.randint(1,9999)
#         y = random.randint(1,9999)
#         coo_coret = False

#         if i != 0 :
#             while not coo_coret:
#                 for point in pt:

#                     if (50<abs(x - pt[point][X] ) and 50<abs(y - pt[point][Y] ) ) :
#                         coo_coret = True
#                     else :
#                         x = random.randint(1,9999)
#                         y = random.randint(1,9999)
#                         coo_coret = False
#                         break

#         i+=1
#         pt_u = [x, y]
#         pt[u] = pt_u


#     for u in G :

#         list_pt_x = [ pt[u][0] ]
#         list_pt_y = [ pt[u][1] ]

#         plt.plot([ pt[u][0] ],[ pt[u][1] ], 'o', label=str(u), markeredgewidth = 6)
#         plt.legend()

#         for v in G[u] :
#             list_pt_x.append(pt[v][0])
#             list_pt_y.append(pt[v][1])

#             plt.figure(1)
#             plt.plot(list_pt_x,list_pt_y, color='black', linewidth=1)
            

#     plt.show(1)    

    



if __name__ == "__main__":
    pass
