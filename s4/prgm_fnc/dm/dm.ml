(* DM programation fonctionnel *)


(*###########################*)
(*#  definition des types   #*)
(*###########################*)
type couleur =
  | Blanc
  | Noir ;;

type quadtree =
  | Feuille of couleur
  | Noeud of quadtree * quadtree * quadtree * quadtree ;;


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
let rec get_height = fun n ->
  match n with
  | 1 -> 0
  | _ -> 1+ get_height (n/2) ;;
(*val get_height : int -> int = <fun>*)



(*la fonction quadtree_full cree un arbre totalement noir de hauteur k tel que n=2**k *)
(*
   @param int n : la longeur d un cote du carre tel que n = 2**k
   @return quadtree : un arbre totalement compose de feuilles noirs
*)
(*Fonctionnement :

On appelle la fonction quadtree_full avec un entier n en parametre, qui fait appel a la fonction get_height qui elle meme retourne la hauteur k a partir de l entier n.
Ensuite on construit l arbre a partir de la hauteur k.

Lorsque k different de 1 on appelle recursivement la fonction quadtree_full en decrementant n de 1. Si n=1 alors nous sommes arrive a une feuille, en l ocurence ici, Noir.

exemple d appel : quadtree_full 8;;
 *)
let quadtree_full = fun n ->
  let rec aux = fun k ->
  match k with
    | 1 -> Noeud ( Feuille Noir, Feuille Noir, Feuille Noir, Feuille Noir )
    | _ -> Noeud ( aux (k-1), aux (k-1), aux (k-1), aux (k-1) )
 in aux (get_height n);;
(* val quadtree_full : int -> quadtree = <fun>  *)

quadtree_full 8;;



(*la fonction quadtree_empty cree un arbre totalement blanc de hauteur k tel que n=2**k *)
(*
   @param int n : la longeur d un cote du carre tel que n = 2**k
   @return quadtree : un arbre totalement compose de feuilles blanc
*)
(*Fonctionnement :

On appelle la fonction quadtree_empty avec un entier n en parametre, qui fait appel a la fonction get_height qui elle meme retourne la hauteur k a partir de l entier n.
Ensuite on construit l arbre a partir de la hauteur k.

Lorsque k different de 1 on appelle recursivement la fonction quadtree_empty en decrementant n de 1. Si n=1 alors nous sommes arrive a une feuille, en l ocurence ici, Blanc.

exemple d appel : quadtree_empty 8;;
 *)
let quadtree_empty = fun n ->
  let rec aux = fun k ->
    match k with
      | 1 -> Noeud ( Feuille Blanc, Feuille Blanc, Feuille Blanc, Feuille Blanc )
      | _ -> Noeud ( aux (k-1), aux (k-1), aux (k-1), aux (k-1) )
 in aux (get_height n);;
(* val quadtree_empty : int -> quadtree = <fun> *)

quadtree_empty 4;;


(*###########################*)
(*#       QUESTION 2        #*)
(*###########################*)

(*la fonction inverse prend un quadtree a et inverse les couleurs des feuilles *)
(*
   @param quadtree a : quadtree a represente une image i
   @return quadtree : le quadtree en retour represente l image i' de i apres application de la fonction inverse
*)
(* Fonctionnement :

on parcourt recursivement notre quadtree a, si a correspond a un Noeud alors on applique la fonction inverse a chacune des feuilles de ce noeud.
Si a est de type Feuille Blanc alors a devient Feuille Noir.
Inversement, si a est de type Feuille Noir alors a devient Feuille Blanc.

*)
let rec inverse = fun a ->
  match a with
    | Feuille Blanc -> Feuille Noir
    | Feuille Noir -> Feuille Blanc
    | Noeud (x1, x2, x3, x4) -> Noeud (inverse x1, inverse x2, inverse x3, inverse x4) ;;
(*val inverse : quadtree -> quadtree = <fun> *)


(*Initialisation pour un exemple avec des feuilles de couleurs Noir et Blanc melangees *)
let exp = Noeud (
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
              ) ;;
inverse exp;;
inverse (quadtree_empty 4);;


(*###########################*)
(*#       QUESTION 3        #*)
(*###########################*)

(*la fonction rotate prend un quadtree a et le fait tourner d un quart de tour vers la gauche *)
(*
   @param quadtree a : quadtree a represente une image i
   @return quadtree : le quadtree en retour represente l image i' de i apres application de la fonction rotate
*)
(* Fonctionnement :

on parcourt recursivement notre quadtree a, si a correspond a un Noeud alors on applique la fonction rotate a chacun des noeuds.
On remplace les positions 1,2,3,4 par 2,3,4,1 pour chaque noeud.
Si a est de type Feuille on ne fait rien.
-----                 -----
|1|2|                 |2|3|
-----  ==> rotate ==> -----
|4|3|                 |1|4|
-----                 -----
*)
let rec rotate = fun a ->
  match a with
    | Feuille c -> Feuille c
    | Noeud (x1, x2, x3, x4) -> Noeud (rotate x2, rotate x3, rotate x4, rotate x1) ;;
(* val rotate : quadtree -> quadtree = <fun> *)


(*Initialisation pour un exemple avec des feuilles de couleurs Noir et Blanc melangees *)
let exp3 = Noeud (
             Noeud (Feuille Noir, Feuille Noir, Feuille Noir, Feuille Noir),
             Noeud (Feuille Blanc, Feuille Blanc, Feuille Blanc, Feuille Blanc),
             Noeud (Feuille Blanc, Feuille Blanc, Feuille Noir, Feuille Blanc),
             Noeud (Feuille Blanc, Feuille Blanc, Feuille Blanc, Feuille Blanc) ) ;;
rotate exp3;;




(*###########################*)
(*#       QUESTION 4        #*)
(*###########################*)

(*la fonction union prend 2 quadtree a et b, et on change la couleur des feuilles celon la regle *)
(*
   @param quadtree a : quadtree a represente une image i
   @param quadtree b : quadtree b represente une image i'
   @return quadtree c : le quadtree c en retour represente l union des 2 image i et i'
*)
(* Fonctionnement :

on parcourt recursivement les 2 quadtree a et b de meme taille.
Si a est un type feuille, nessesairement b aussi, alors on applique la regle d union definie:
Blanc u X OU X u Blanc = X ; Noir u Noir = Noir.

Pour ne pas avoir l erreur :"Warning 8: this pattern-matching is not exhaustive." j ai ajoute un dernier test pour ne pas comparer une Feuille avec un Noeud.

*)

let rec union = fun a b ->
  match (a,b) with
    | (Feuille Blanc, Feuille x) | (Feuille x, Feuille Blanc) -> Feuille x
    | (Feuille Noir, Feuille Noir) -> Feuille Noir
    | (Noeud (x1, x2, x3, x4), Noeud (y1, y2, y3, y4) ) -> Noeud ( union x1 y1, union x2 y2, union x3 y3, union x4 y4 )
    | (Feuille _, Noeud(_, _, _, _) ) | (Noeud(_, _, _, _), Feuille _) -> failwith"error" (* pour ne pas avoir le "pattern-matching is not exhaustive" mais on aura jamais ce cas *) ;;


(*Initialisation pour un exemple avec des feuilles de couleurs Noir et Blanc melangees *)
let exa = Noeud (Feuille Blanc, Feuille Blanc, Feuille Noir, Feuille Noir) ;;
let exb = Noeud (Feuille Blanc, Feuille Noir, Feuille Noir, Feuille Blanc) ;;

union exa exb;;


(*###########################*)
(*#       QUESTION 5        #*)
(*###########################*)
(* PB: je sort avec un FAILWITH et non un NONE  *)
(* on suppose que a et b font la meme taille *)

let rec intersection = fun a b ->
  match (a,b) with
    | (Feuille Blanc, Feuille x) | (Feuille x, Feuille Blanc) -> Feuille Blanc
    | (Feuille Noir, Feuille Noir) -> Feuille Noir
    | (Noeud (x1, x2, x3, x4), Noeud (y1, y2, y3, y4) ) -> Noeud ( intersection x1 y1, intersection x2 y2, intersection x3 y3, intersection x4 y4 )
    | (Feuille _, Noeud(_, _, _, _) ) | (Noeud(_, _, _, _), Feuille _) -> failwith"error" (* pour ne pas avoir le "pattern-matching is not exhaustive" mais on aura jamais ce cas *) ;;


intersection exa exb;;

intersection exp (inverse exp);;



(*###########################*)
(*#       QUESTION 6        #*)
(*###########################*)

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



color (6,7) 8 exp;;

color (0,8) 8 exp;;

let exa = Noeud (Feuille Blanc, Feuille Blanc, Feuille Noir, Feuille Noir) ;;

color (1,1) 2 exa;;
color (1,2) 2 exa;;
color (2,2) 2 exa;;
color (2,1) 2 exa;;



(*###########################*)
(*#       QUESTION 7        #*)
(*###########################*)


let modify_f_diago_noir = fun x y c ->
  if x=y then
    Noir
  else
    c;;


let modify = fun a t f->
  let rec aux = fun b l (x,y) ->
    match b with
      | Feuille c -> Feuille (f x y c)
      | Noeud (x1, x2, x3, x4) -> Noeud( aux x1 (l/2) (x,y), aux x2 (l/2) ((x+(l/2)), y),  aux x3 (l/2) ((x+(l/2)), (y+(l/2))), aux x2 (l/2) (x, (y+(l/2))) )
  in aux a t (1,1) ;;


modify (quadtree_empty 4) 4 modify_f_diago_noir;;



(*###########################*)
(*#       QUESTION 8        #*)
(*###########################*)

let rec get_height_quadtree = fun a ->
  match a with
    | Feuille c -> 0
    | Noeud (x1, x2, x3, x4) -> 1+ get_height_quadtree x1 ;;
get_height_quadtree exp;;


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





optimise exp;;


optimise (quadtree_empty 16);;



(*###########################*)
(*#       QUESTION 9        #*)
(*###########################*)

type bit = Zero | Un;;


let quadtree_to_list = fun a ->
  let rec aux = fun a ->
    match a with
      | Feuille Blanc -> [Zero]@[Zero]
      | Feuille Noir -> [Zero]@[Un]
      | Noeud(x1, x2, x3, x4) -> [Un]@(aux x1)@(aux x2)@(aux x3)@(aux x4)
  in aux a;;

quadtree_to_list exp;;

let list_exp = quadtree_to_list exp;;



(*###########################*)
(*#       QUESTION 10       #*)
(*###########################*)


let list_to_quadtree = fun l ->
  let rec aux = fun l->
    match l with
      | h1::t when h1=Un -> Noeud(aux t
      | h1::h2::t when h1=Zero && h2=Zero -> Feuille Blanc
      | h1::h2::t when h1=Zero && h2=Un -> Feuille Noir
  in aux l;;

