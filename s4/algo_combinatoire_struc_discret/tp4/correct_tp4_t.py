# -*- coding: utf-8 -*- 

from utils import connectSocket, closeSocket, sendcmd, recvcmd
from utils import getWeight, getNeighbors, getAVertex, Cookie, SpanningTreeWeight


# Pour la file de priorité de Prim
from priority_dict import priority_dict

# The union-find data-structure is used by Kruskal algorithm
from UnionFind import UnionFind




#---------------------------------------------------------------------------------------------------
def ACM_Prim():
   """ calcule un ACM du graphe stocké sur le serveur en utilisant l'algorithme de Prim """
   F = priority_dict()
   r = getAVertex()
   sommets = set()
   sommets.add(r)
   F[r]=0
   pere=dict()
   pere[r]=None
   while F :
      u = F.pop_smallest()
      for v in getNeighbors(u):
         if v not in sommets:
            sommets.add(v)
            F[v]=float('+infinity')
         if v in F and getWeight(u,v)<F[v] :
            pere[v]=u
            F[v]=getWeight(u,v)

   #Calcul du poids w de l'arbre couvrant
   w=0
   for v in sommets:
      if v != r:
         w += getWeight(pere[v],v)
   SpanningTreeWeight(w)

#---------------------------------------------------------------------------------------------------





#---------------------------------------------------------------------------------------------------
def ACM_Kruskal(G):
   """ calcule un ACM du graphe G en utilisant l'algorithme de Kruskal"""
   r = getAVertex()
   traites = set()
   arretes = []
   F = [r]
   while F :
      u=F.pop()
      for v in getNeighbors(u):
         if v not in traites:
            F.append(v)  
            arretes.append( ((u,v),getWeight(u,v)) )
      traites.add(u)
   arretes = trier(arretes)
   S = UnionFind()
   w=0
   for a in arretes:
      u=a[0][0]
      v=a[0][1]
      if S[u] != S[v]:
         w += a[1]
         S.union(u,v)
   SpanningTreeWeight(w)    
  
def trier(t):
   """ trie une liste composée de couples de la forme ((u,v),poids de (u,v))"""
   n = len(t)
   if n <= 1:
      return t
   p = n//2
   t1 = trier(t[:p])
   t2 = trier(t[p:])
   res = []
   for i in range(n):
      if t1 == []:
         res = res + t2
         break
      elif t2 == []:
         res = res + t1
         break
      elif t1[0][1]<t2[0][1]:
         res.append(t1[0])
         t1.pop(0)
      else:
         res.append(t2[0])
         t2.pop(0)
   return res

#---------------------------------------------------------------------------------------------------




if __name__ == "__main__":
   """ Il n'y a rien à modifier ci-dessous, excepté l'appel à ACM_Prim() ou à
   ACM_Kruskal(G) en définissant le graphe au préalable """

   # connexion au serveur
   connectSocket("distrigraphes.info-orleans.fr", 6667)

   #ACM_Prim() # peut être mis en commentaire si nécessaire



   G = {} # graphe vide
   ACM_Kruskal(G)

   sendcmd('stop','')
   closeSocket()
