(* DM programation fonctionnel *)


(* CHEVALIER Thomas 2180812 tp D td 2 *)


(*###########################*)
(*#  definition des types   #*)
(*###########################*)
type couleur =
  | Blanc
  | Noir ;;

type quadtree =
  | Feuille of couleur
  | Noeud of quadtree * quadtree * quadtree * quadtree ;;

type bit = 
  | Zero 
  | Un;;

(*###########################*)
(*#       QUESTION 1        #*)
(*###########################*)


(*
   @param int n
   @return int k tel que n = 2**k
*)
(*Fonctionnement :

La fonction get_height retourne la hauteur k a partir de l entier n.

exemple d appel : get_height 8;;
 *)
(*val get_height : int -> int = <fun>*)
let rec get_height = fun n ->
  match n with
  | 1 -> 0
  | _ -> 1+ get_height (n/2) ;;

(* get_height 8;; *)



(*La fonction quadtree_full crée un arbre totalement noir de hauteur k tel que n=2**k*)
(*
   @param  int n : la longueur d’un côté du carré tel que n = 2**k
   @return quadtree : un arbre totalement composé de feuilles Noir
*)
(*Fonctionnement :

On appelle la fonction quadtree_full avec un entier n en paramètre, qui fait appel à la fonction get_height qui elle même retourne la hauteur k à partir de l'entier n.
Ensuite on construit l'arbre à partir de la hauteur k.

Lorsque k différent de 1 on appelle récursivement la fonction quadtree_full en décrémentant n de 1. Si n=1 alors nous sommes arrivé à une feuille, en l'occurrence ici, Noir.

exemple d appel : quadtree_full 8;;
 *)
(* val quadtree_full : int -> quadtree = <fun>  *)
let quadtree_full = fun n ->
  let rec aux = fun k ->
  match k with
    | 1 -> Noeud ( Feuille Noir, Feuille Noir, Feuille Noir, Feuille Noir )
    | _ -> Noeud ( aux (k-1), aux (k-1), aux (k-1), aux (k-1) )
 in aux (get_height n);;

(* quadtree_full 8;; *)



(*La fonction quadtree_empty crée un arbre totalement Blanc de hauteur k tel que *)
(*
   @param int n : la longueur d’un côté du carré tel que n = 2**k
   @return quadtree : un arbre totalement composé de feuilles Blanc
*)
(*Fonctionnement :

On appelle la fonction quadtree_empty avec un entier n en paramètre, qui fait appel à la fonction get_height qui elle même retourne la hauteur k à partir de l'entier n.
Ensuite on construit l'arbre à partir de la hauteur k.

Lorsque k différent de 1 on appelle récursivement la fonction quadtree_empty en décrémentant n de 1. Si n=1 alors nous sommes arrivé à une feuille, en l'occurrence ici,Blanc.

exemple d appel : quadtree_empty 8;;
 *)
(* val quadtree_empty : int -> quadtree = <fun> *)
let quadtree_empty = fun n ->
  let rec aux = fun k ->
    match k with
      | 1 -> Noeud ( Feuille Blanc, Feuille Blanc, Feuille Blanc, Feuille Blanc )
      | _ -> Noeud ( aux (k-1), aux (k-1), aux (k-1), aux (k-1) )
 in aux (get_height n);;

(* quadtree_empty 4;; *)



(*###########################*)
(*#       QUESTION 2        #*)
(*###########################*)

(*La fonction inverse prend un quadtree a et inverse les couleurs des feuilles.  *)
(*
   @param quadtree a : le quadtree a représenté une image i
   @return quadtree : le quadtree en retour représente l'image i' de i après application de la fonction inverse
*)
(* Fonctionnement :

On parcourt récursivement notre quadtree a, si a correspond à un Noeud alors on applique la fonction inverse à chacune des feuilles de ce noeud.

Si a est de type Feuille Blanc alors a devient Feuille Noir.
Inversement, si a est de type Feuille Noir alors a devient Feuille Blanc.

exemple d appel : inverse (quadtree_empty 8);;
*)
(*val inverse : quadtree -> quadtree = <fun> *)
let rec inverse = fun a ->
  match a with
    | Feuille Blanc -> Feuille Noir
    | Feuille Noir -> Feuille Blanc
    | Noeud (x1, x2, x3, x4) -> Noeud (inverse x1, inverse x2, inverse x3, inverse x4) ;;


(*Initialisation pour un exemple avec des feuilles de couleurs Noir et Blanc melangees *)
(* let exp = Noeud (
                Noeud (
                  Noeud (Feuille Blanc, Feuille Blanc, Feuille Blanc, Feuille Blanc),
                  Noeud (Feuille Blanc, Feuille Blanc, Feuille Blanc, Feuille Blanc),
                  Noeud (Feuille Blanc, Feuille Blanc, Feuille Blanc, Feuille Blanc),
                  Noeud (Feuille Blanc, Feuille Blanc, Feuille Blanc, Feuille Blanc)
                 ),
                 Noeud (
                   Noeud (Feuille Blanc, Feuille Blanc, Feuille Blanc, Feuille Blanc),
                   Noeud (Feuille Blanc, Feuille Blanc, Feuille Blanc, Feuille Blanc),
                   Noeud (Feuille Noir, Feuille Blanc, Feuille Blanc, Feuille Blanc),
                   Noeud (Feuille Noir, Feuille Noir, Feuille Noir, Feuille Noir)
                 ),
                 Noeud (
                   Noeud (Feuille Noir, Feuille Noir, Feuille Noir, Feuille Noir),
                   Noeud (Feuille Blanc, Feuille Blanc, Feuille Blanc, Feuille Blanc),
                   Noeud (Feuille Blanc, Feuille Blanc, Feuille Noir, Feuille Blanc),
                   Noeud (Feuille Blanc, Feuille Blanc, Feuille Blanc, Feuille Blanc)
                 ),
                 Noeud (
                   Noeud (Feuille Noir, Feuille Noir, Feuille Noir, Feuille Noir),
                   Noeud (Feuille Noir, Feuille Noir, Feuille Noir, Feuille Noir),
                   Noeud (Feuille Noir, Feuille Noir, Feuille Noir, Feuille Noir),
                   Noeud (Feuille Noir, Feuille Noir, Feuille Noir, Feuille Noir)
                 )
              ) ;; *)
(* inverse exp;; *)
(* inverse (quadtree_empty 4);; *)



(*###########################*)
(*#       QUESTION 3        #*)
(*###########################*)

(*La fonction rotate prend un quadtree a et le fait tourner d un quart de tour vers la gauche *)
(*
   @param quadtree a : le quadtree a représenté une image i
   @return quadtree : quadtree : le quadtree en retour represente l image i' de i apres application de la fonction rotate
*)
(* Fonctionnement :

On parcourt récursivement notre quadtree a, si a correspond a un Noeud alors on applique la fonction rotate a chacun des noeuds.

On remplace les positions 1,2,3,4 par 2,3,4,1 pour chaque noeud.
Si a est de type Feuille on ne fait rien.

-----                 -----
|1|2|                 |2|3|
-----  ==> rotate ==> -----
|4|3|                 |1|4|
-----                 -----

exemple d appel : rotate exp;;
*)
(* val rotate : quadtree -> quadtree = <fun> *)
let rec rotate = fun a ->
  match a with
    | Feuille c -> Feuille c
    | Noeud (x1, x2, x3, x4) -> Noeud (rotate x2, rotate x3, rotate x4, rotate x1) ;;


(*Initialisation pour un exemple avec des feuilles de couleurs Noir et Blanc melangees *)
(* let exp3 = Noeud (
             Noeud (Feuille Noir, Feuille Noir, Feuille Noir, Feuille Noir),
             Noeud (Feuille Blanc, Feuille Blanc, Feuille Blanc, Feuille Blanc),
             Noeud (Feuille Blanc, Feuille Blanc, Feuille Noir, Feuille Blanc),
             Noeud (Feuille Blanc, Feuille Blanc, Feuille Blanc, Feuille Blanc) ) ;; *)
(* rotate exp3;; *)




(*###########################*)
(*#       QUESTION 4        #*)
(*###########################*)

(*lLa fonction union prend 2 quadtree a et b, et on change la couleur des feuilles selon la règle.  *)
(*
   @param quadtree a : quadtree a représente une image i
   @param quadtree b : quadtree b représente une image i'
   @return quadtree c : le quadtree c en retour représente l'union des 2 image i et i'
*)
(* Fonctionnement :

On parcourt récursivement les 2 quadtree a et b de même taille.
Si a est un type feuille, nécessairement b aussi, alors on applique la règle d’union définie par:
Blanc u X OU X u Blanc = X ; Noir u Noir = Noir.

Pour ne pas avoir l'erreur :"Warning 8: this pattern-matching is not exhaustive." j'ai ajouté un dernier match pour ne pas comparer une Feuille avec un Noeud.(ce cas ne sera jamais traiter car a et b font la même taille)

exemple d appel : union exa exb;;
*)
(* val union : quadtree -> quadtree -> quadtree = <fun> *)
let rec union = fun a b ->
  match (a,b) with
    | (Feuille Blanc, Feuille x) | (Feuille x, Feuille Blanc) -> Feuille x
    | (Feuille Noir, Feuille Noir) -> Feuille Noir
    | (Noeud (x1, x2, x3, x4), Noeud (y1, y2, y3, y4) ) -> Noeud ( union x1 y1, union x2 y2, union x3 y3, union x4 y4 )
    | (Feuille _, Noeud(_, _, _, _) ) | (Noeud(_, _, _, _), Feuille _) -> failwith"error" (* pour ne pas avoir le "pattern-matching is not exhaustive" mais on aura jamais ce cas *) ;;


(*Initialisation pour un exemple avec des feuilles de couleurs Noir et Blanc melangees *)
(* let exa = Noeud (Feuille Blanc, Feuille Blanc, Feuille Noir, Feuille Noir) ;;
let exb = Noeud (Feuille Blanc, Feuille Noir, Feuille Noir, Feuille Blanc) ;; *)

(* union exa exb;; *)



(*###########################*)
(*#       QUESTION 5        #*)
(*###########################*)

(*lLa fonction intersection prend 2 quadtree a et b, et on change la couleur des feuilles selon la règle. 
  *)
(*
   @param quadtree a : quadtree a représente une image i
   @param quadtree b : quadtree b représente une image i'
   @return quadtree c : le quadtree c en retour représente l'intersection des 2 image i et i'
*)
(* Fonctionnement :

On parcourt récursivement les 2 quadtree a et b de même taille.
Si a est un type feuille, nécessairement b aussi, alors on applique la règle d’intersection définie par:
Blanc n X OU X n Blanc = Blanc ; Noir n Noir = Noir.

Pour ne pas avoir l'erreur :"Warning 8: this pattern-matching is not exhaustive." j'ai ajouté un dernier match pour ne pas comparer une Feuille avec un Noeud.(ce cas ne sera jamais traiter car a et b font la même taille)

exemple d appel : intersection exa exb;;
*)
(* val intersection : quadtree -> quadtree -> quadtree = <fun> *)
let rec intersection = fun a b ->
  match (a,b) with
    | (Feuille Blanc, Feuille x) | (Feuille x, Feuille Blanc) -> Feuille Blanc
    | (Feuille Noir, Feuille Noir) -> Feuille Noir
    | (Noeud (x1, x2, x3, x4), Noeud (y1, y2, y3, y4) ) -> Noeud ( intersection x1 y1, intersection x2 y2, intersection x3 y3, intersection x4 y4 )
    | (Feuille _, Noeud(_, _, _, _) ) | (Noeud(_, _, _, _), Feuille _) -> failwith"error" (* pour ne pas avoir le "pattern-matching is not exhaustive" mais on aura jamais ce cas *) ;;


(* intersection exa exb;; *)
(* intersection exp (inverse exp);; *)



(*###########################*)
(*#       QUESTION 6        #*)
(*###########################*)

(*La fonction color prend 2 coordonnées (x,y), la taille de l’image i, et le quadtree qui représente l'image i, on retourne la couleur de la feuille au coordonnée (x,y).*)
(*
   @param int*int (x,y) : coordonnées (x,y) (on commence a compté à partir de 1!)
   @param int l : taille de l image
   @param quadtree a : quadtree a représente une image i
   @return couleur option c : couleur du point de coordonnées (x,y) dans le quadtree a
*)
(* 

Les bases : 

On commence a compté à partir de 1!, l’axe des abscisses (x) se situe à vertical, lors d'un déplacement vers la case du bas. Donc l'axe des ordonnées se situe à l’horizontal. (rotation du plan RxR de +90°)


Fonctionnement :

Je souhaite me reduire a un carré de 1 de côte.
Pour cela, il faut repérer où se situe le couple (x,y) dans la grille qui se décompose en 4 sous carrée (les 4 noeuds).
---------
| 1 | 2 |    
---------      
| 4 | 3 |  
--------- 

On s'assure que les coordonnées de x et y sont valide sinon on sort avec None.

Si le couple (x,y) se situe dans le carré 1 alors on rappel récursivement la fonction en avec le quadtree du carre 1 et divisant par 2 la taille en paramètre.
Si le couple (x,y) se situe dans le carré 2 alors on rappel récursivement la fonction en avec le quadtree du carré 2 et divisant par 2 la taille en paramètre et on décrémente y de la moitié de la taille du quadtree.
Si le couple (x,y) se situe dans le carré 3 alors on rappel récursivement la fonction en avec le quadtree du carré 3 et divisant par 2 la taille en paramètre et on décrémente x de la moitié de la taille du quadtree et y de la moitié de la taille du quadtree.
Si le couple (x,y) se situe dans le carré 4 alors on rappel récursivement la fonction en avec le quadtree du carré 4 et divisant par 2 la taille en paramètre et on décrémente x de la moitié de la taille du quadtree.

exemple d appel : color (6,7) 8 exp;;
*)
(* val color : int * int -> int -> quadtree -> couleur option = <fun> *)
let color = fun (x,y) l a->
  let rec aux = fun (x,y) a l->
    match a with
      | Feuille x -> Some x
      | Noeud (x1, x2, x3, x4) ->
          if x<=(l/2) then
            if y<=(l/2) then aux (x,y) x1 (l/2)
            else aux (x,(y-(l/2))) x2 (l/2)
          else
            if y<=(l/2) then aux ( (x-(l/2)), y) x4 (l/2)
            else aux ( (x-(l/2)) , (y-(l/2)) ) x3 (l/2)
  in if x>l || y>l || x=0 ||y=0 then None
     else aux (x,y) a l ;;


(* color (6,7) 8 exp;; *)
(* color (0,8) 8 exp;; *)




(*###########################*)
(*#       QUESTION 7        #*)
(*###########################*)

(* Initialisation pour un exemple *)
(*
   @param int x : coordonnée en abscice
   @param int y : coordonnée en ordoonner
   @return couleur c : retounr une couleur selon la definition de la fonction
*)
(*Fonctionnement :

La fonction modify_f_diago_noir retounr la couleur noir si les coordonnées sont sur la diagonale.

exemple d appel : modify_f_diago_noir 8 8 Blanc;;
 *)
(* val modify_f_diago_noir : 'a -> 'a -> couleur -> couleur = <fun> ; 'a mais plus presisement des type int *)
let modify_f_diago_noir = fun x y c ->
  if x=y then
    Noir
  else
    c;;



(*La fonction modify prend un quadtree qui représente l'image i, sa taille et une fonction de profile : int -> int -> couleur -> couleur. On retourne le quadtree modifié par la fonction f.*)
(*
   @param quadtree a : quadtree a représente une image i
   @param int t : taille de l image
   @param function f : de profile : int -> int -> couleur -> couleur
   @return quadtree a : apres apllication de la fonction f en chacun des points du quadtree
*)
(* 
Les bases : 

On commence a compté à partir de 1!, l’axe des abscisses (x) se situe à vertical, lors d'un déplacement vers la case du bas. Donc l'axe des ordonnées se situe à l’horizontal. (rotation du plan RxR de +90°)


Fonctionnement :

Je souhaite me reduire a un carré de 1 de côte. Pour lui ensuite appliquer la fonction f.
Pour cela, il faut repérer où se situe le couple (x,y) dans la grille qui se décompose en 4 sous carrée (les 4 noeuds).
---------
| 1 | 2 |    
---------      
| 4 | 3 |  
--------- 

La fonction auxiliaire prend en paramètre un a quadtree, la taille de ce quadtree et un couple de coordonnées (x,y) de type int*int.
Elle sera appelée avec le quadtree a sa taille et les coordonnées de base (1,1).

Si on se situe dans le carré 1 alors on rappel récursivement la fonction auxiliaire de modify avec comme quadtree le carré 1, on divise la taille par 2,  on ne modifie pas les coordonnées de x et y.
Si on se situe dans le carré 2 alors on rappel récursivement la fonction auxiliaire de modify avec comme quadtree le carré 2, on divise la taille par 2,  on modifie les coordonnées de x en lui ajoutant la taille du carré divisé par 2, et rien de plus pour y.
Si on se situe dans le carré 3 alors on rappel récursivement la fonction auxiliaire de modify avec comme quadtree le carré 3, on divise la taille par 2,  on modifie les coordonnées de x en lui ajoutant la taille du carré divisé par 2, et de y en lui ajoutant la taille du carré divisé par 2.
Si on se situe dans le carré 4 alors on rappel récursivement la fonction auxiliaire de modify avec comme quadtree le carré 4, on divise la taille par 2,  on modifie les coordonnées de x rien de plus pour, mais y on lui ajoutant la taille du carré divisé par 2.


exemple d appel : modify (quadtree_empty 4) 4 modify_f_diago_noir;;
*)
(* val modify : quadtree -> int -> (int -> int -> couleur -> couleur) -> quadtree = <fun> *)
let modify = fun a t f->
  let rec aux = fun b l (x,y) ->
    match b with
      | Feuille c -> Feuille (f x y c)
      | Noeud (x1, x2, x3, x4) -> Noeud( aux x1 (l/2) (x,y), aux x2 (l/2) ((x+(l/2)), y),  aux x3 (l/2) ((x+(l/2)), (y+(l/2))), aux x2 (l/2) (x, (y+(l/2))) )
  in aux a t (1,1) ;;


(* modify (quadtree_empty 4) 4 modify_f_diago_noir;; *)



(*###########################*)
(*#       QUESTION 8        #*)
(*###########################*)

(*
   @param quadtree a 
   @return int k tel que n = 2**k
*)
(*Fonctionnement :

La fonction get_height_quadtree retourne la hauteur k a partir de l entier n.

exemple d appel : get_height_quadtree 8;;
 *)
(*val get_height_quadtree : quadtree -> int = <fun>*)
let rec get_height_quadtree = fun a ->
  match a with
    | Feuille c -> 0
    | Noeud (x1, x2, x3, x4) -> 1+ get_height_quadtree x1 ;;
(* get_height_quadtree exp;; *)





(*La fonction optimise prend un quadtree qui représente l'image i, et retourne le quadtree optimisé tel que un nœud dont les fils sont tous de la même couleur sera modifié en feuille.*)
(*
   @param quadtree a : quadtree a représente une image i
   @return quadtree a : quadtree a : retourné un quadtree optimiser.
*)
(* 
Fonctionnement :

Pour optimiser l’arbre je il faut repérer les cas ou les 4 feuilles sont de couleur identique et transformer le noeud en une feuille de cette couleur.
Lorsque l'on match avec un noeud alors on applique la fonction auxiliaire de optimisés.

Je n ai pas trouvé des solution pour l optimiser complètement donc je repete la fonction auxiliaire de optimise le nombre de fois qui correspond à la hauteur du quadtree. Pour trouver la hauteur du quadtree j'utilise une fonction qui compte le nombre de noeud imbriquer.


exemple d appel : optimise exp;;
*)
(* val modify : val optimise : quadtree -> quadtree = <fun> *)
let optimise = fun a ->
  let rec aux = fun a ->
    match a with
      | Feuille c -> Feuille c
      | Noeud ( Feuille Blanc, Feuille Blanc, Feuille Blanc, Feuille Blanc) -> Feuille Blanc
      | Noeud ( Feuille Noir, Feuille Noir, Feuille Noir, Feuille Noir) -> Feuille Noir
      | Noeud (x1, x2, x3, x4) -> Noeud (aux x1, aux x2, aux x3, aux x4)
  in
    let rec aux2 = fun i res->
      match i with
        | 0 -> res
        | _ -> aux2 (i-1) (aux (res))
    in aux2 (get_height_quadtree a) a ;;


(* optimise exp;; *)
(* optimise (quadtree_empty 16);; *)



(*###########################*)
(*#       QUESTION 9        #*)
(*###########################*)


(*La fonction  quadtree_to_list prend un quadtree qui représente l'image i, et retourne une liste de bit le représentant.*)
(*
   @param quadtree a : quadtree a représente une image i
   @return bit list : retourne liste de bit
*)
(* 
Fonctionnement :

Pour transformer le quadtree en une liste de bit, on regarde regarde récursivement, si l'on tombe sur une feuille Blanc alors on ajoute à la liste Zero Zero, si la feuille est Noir alors Zero Noir. 
Et si c'est un noeud alors on ajoute un à la liste et on recommence récursivement.


exemple d appel : quadtree_to_list exp;;
*)
(*  val quadtree_to_list : quadtree -> bit list = <fun> *)
let quadtree_to_list = fun a ->
  let rec aux = fun a ->
    match a with
      | Feuille Blanc -> [Zero]@[Zero]
      | Feuille Noir -> [Zero]@[Un]
      | Noeud(x1, x2, x3, x4) -> [Un]@(aux x1)@(aux x2)@(aux x3)@(aux x4)
  in aux a;;

(* quadtree_to_list exp;; *)




(*###########################*)
(*#       QUESTION 10       #*)
(*###########################*)

(* Non realisé *)
