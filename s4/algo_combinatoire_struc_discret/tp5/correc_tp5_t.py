# -*- coding: utf-8 -*- 

from functools import reduce
from itertools import combinations
import random

def check(dS,k):
   """ given a set S, a dictionary dS with attributes 'prix', "calories' for each item of S,
      and an integer k, the fonction returns a couple (n,val) where nb is the number of subsets
      in dS of size k, and val is the maximum value of calories/prix over all subsets of size k """
   nb, val = 0, 0
   for subsets in combinations(dS, k):
      nb += 1
      sumCalories = sum([dS[j][0] for j in subsets])
      sumPrix = sum([dS[j][1] for j in subsets])
      val = max(val, sumCalories/sumPrix)
   return (nb, val)



def createDict(n):
   """ return a dictionary containing n fruits or vegetables
   and attributes (calories, price) for each portion"""
   mainlist = ['abricot', 'artichaut', 'asperge', 'aubergine', 'avocat', 'betterave', 'blette', 'brocoli', 'carotte', 'cassis', 'cerfeuil tubéreux', 'cerise', 'chou de Bruxelles', 'chou romanesco ', 'chou-fleur', 'chou-rave', 'châtaigne', 'citrouille', 'clémentine', 'coing', 'concombre', 'cornichon', 'courgette', 'céleri', 'datte', 'endive', 'flageolet', 'fraise', 'framboise', 'groseille', 'haricot', 'kaki', 'kiwi', 'laitue', 'lentille', 'mandarine', 'maïs doux', 'melon', 'mirabelle', 'myrtille', 'mâche', 'mûre', 'navet', 'noix', 'orange', 'pastèque', 'pastèque', 'patate douce', 'petit pois ', 'pissenlit', 'poire', 'poireau', 'pois chiche', 'poivron', 'pomme', 'pomme de terre', 'potiron', 'pâtisson', 'pêche', 'radis', 'radis noir', 'raisin', 'rhubarbe', 'roquette', 'rutabaga', 'salicorne', 'salsifis', 'scarole', 'tomate', 'topinambour', 'épinard ']	
   S = random.sample(mainlist, n)
   dictS = dict()
   for v in S:
      calories = random.randint(1, 500)	# random calories for a portion
      price = random.randint(1, 500)		# random price for a portion
      dictS[v]=(calories, price)
   return (S,dictS)

def assoc(S,I):
   res=[]
   for i in I :
      res.append(S[i])
   return res

def GenerateSubsets(S,k):
   I = list(range(0,k))
   yield I
   #assoc(S,I)
   while True:
      for i in I:
         if i+1 not in I:
            j=i
            break
      if j == len(S)-1:
         break
      else:
         q=I.index(j)
         I[q] = j+1
         for p in range (0,q):
            I[p]=p
         yield I
         #assoc(S,I)
            

def Permutation(S):
   n = len(S)
   s = list(range(0,n))
   yield assoc(S,s)
   
   while True:
      i=-1
      for j in range (n-2,-1,-1):
         if s[j] < s[j+1]:
            i=j
            break
      #print ("i=",i+1)
      if i==-1:
         break
      else:
         k=i+1
         for j in range (i+2,n):
            if s[j]>s[i] and s[j]<s[k]:
               k=j
         #print ("k=",k+1)
         s[i],s[k] = s[k],s[i]
         for j in range ( 1 , (n-i-1)//2 +1):
            s[i+j],s[n-j] = s[n-j],s[i+j]
         yield assoc(S,s)
	
if __name__ == '__main__':
   random.seed()

   n, k = 25, 5
   S, dictS = createDict(n)
   
   newgen = GenerateSubsets(S,k)
   minRapport = -1
   min = []
   nb=0
   for I in newgen:
      nb+=1
      sumCalories = 0
      sumPrix = 0
      for i in I:
         cal,prix = dictS[S[i]]
         sumCalories += cal
         sumPrix += prix
      if sumCalories/sumPrix > minRapport:
         minRapport = sumCalories/sumPrix
         min = I
   print(assoc(S,min))
   print (nb,minRapport)
   print( check(dictS,k) )
   
   newgen = Permutation(assoc(S,min))
   nb = 0
   for I in newgen:
      nb+=1
      print (I)
   print (nb)
	
#   for subsets in GenerateSubsets(S,k):
#      print("indices", subsets, " --> corresponding subset", [S[j] for j in subsets])
