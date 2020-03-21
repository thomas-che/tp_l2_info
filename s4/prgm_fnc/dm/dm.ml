type couleur =
  | Blanc
  | Noir ;;


type quadtree =
  | Feuille of couleur
  | Noeud of quadtree * quadtree * quadtree * quadtree ;;



(* QUESTION 1 *)

(* val quadtree_full : int -> quadtree = <fun>  *)
let rec quadtree_full = fun n ->
  match n with
    | 1 -> Noeud ( Feuille Noir, Feuille Noir, Feuille Noir, Feuille Noir )
    | _ -> Noeud ( quadtree_full (n-1), quadtree_full (n-1), quadtree_full (n-1), quadtree_full (n-1) ) ;;

quadtree_full 2;;



let rec quadtree_empty = fun n ->
  match n with
    | 1 -> Noeud ( Feuille Blanc, Feuille Blanc, Feuille Blanc, Feuille Blanc )
    | _ -> Noeud ( quadtree_empty (n-1), quadtree_empty (n-1), quadtree_empty (n-1), quadtree_empty (n-1) ) ;;

quadtree_empty 2;;

quadtree_empty 3;;


(* QUESTION 2 *)


let rec inverse = fun a ->
  match a with
    | Feuille Blanc -> Feuille Noir
    | Feuille Noir -> Feuille Blanc
    | Noeud (x1, x2, x3, x4) -> Noeud (inverse x1, inverse x2, inverse x3, inverse x4) ;;


let f = Noeud (Noeud (Feuille Noir, Feuille Noir, Feuille Noir, Feuille Noir),
               Noeud (Feuille Noir, Feuille Noir, Feuille Noir, Feuille Noir),
               Noeud (Feuille Noir, Feuille Noir, Feuille Noir, Feuille Noir),
               Noeud (Feuille Noir, Feuille Noir, Feuille Noir, Feuille Noir) ) ;;

inverse f ;;


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



let exp3 = Noeud (
             Noeud (Feuille Noir, Feuille Noir, Feuille Noir, Feuille Noir),
             Noeud (Feuille Blanc, Feuille Blanc, Feuille Blanc, Feuille Blanc),
             Noeud (Feuille Blanc, Feuille Blanc, Feuille Noir, Feuille Blanc),
             Noeud (Feuille Blanc, Feuille Blanc, Feuille Blanc, Feuille Blanc) ) ;;


(* QUESTION 3 *)

let rec rotate = fun a ->
  match a with
    | Feuille c -> Feuille c
    | Noeud (x1, x2, x3, x4) -> Noeud (rotate x2, rotate x3, rotate x4, rotate x1) ;;

rotate exp3;;



(* QUESTION 4 *)
(* PB: je sort avec un FAILWITH et non un NONE  *)
(* on suppose que a et b font la meme taille *)

let rec union = fun a b ->
  match (a,b) with
    | (Feuille Blanc, Feuille x) | (Feuille x, Feuille Blanc) -> Feuille x
    | (Feuille Noir, Feuille Noir) -> Feuille Noir
    | (Noeud (x1, x2, x3, x4), Noeud (y1, y2, y3, y4) ) -> Noeud ( union x1 y1, union x2 y2, union x3 y3, union x4 y4 )
    | (Feuille _, Noeud(_, _, _, _) ) | (Noeud(_, _, _, _), Feuille _) -> failwith"error" (* pour ne pas avoir le "pattern-matching is not exhaustive" mais on aura jamais ce cas *) ;;



let exa = Noeud (Feuille Blanc, Feuille Blanc, Feuille Noir, Feuille Noir) ;;

let exb = Noeud (Feuille Blanc, Feuille Noir, Feuille Noir, Feuille Blanc) ;;

union exa exb;;



(* QUESTION 5 *)
(* PB: je sort avec un FAILWITH et non un NONE  *)
(* on suppose que a et b font la meme taille *)

let rec intersection = fun a b ->
  match (a,b) with
    | (Feuille Blanc, Feuille x) | (Feuille x, Feuille Blanc) -> Feuille Blanc
    | (Feuille Noir, Feuille Noir) -> Feuille Noir
    | (Noeud (x1, x2, x3, x4), Noeud (y1, y2, y3, y4) ) -> Noeud ( intersection x1 y1, intersection x2 y2, intersection x3 y3, intersection x4 y4 )
    | (Feuille _, Noeud(_, _, _, _) ) | (Noeud(_, _, _, _), Feuille _) -> failwith"error" (* pour ne pas avoir le "pattern-matching is not exhaustive" mais on aura jamais ce cas *) ;;


intersection exa exb;;



(* QUESTION 6 *)


let rec lg = fun a ->
  match a with
    | Feuille c -> 1
    | Noeud (x1, x2, x3, x4) -> 2 * lg x1 ;;

lg exp ;;



let color = fun (x,y) a ->
  let rec aux = fun (x,y) a l->
    match a with
      | Noeud (Feuille x1, Feuille x2, Feuille x3, Feuille x4) -> if x=1 then
                                                                    if y=1 then x1
                                                                    else x4
                                                                  else
                                                                    if y=1 then x2
                                                                    else x3
      | Noeud (x1, x2, x3, x4) ->
          if x<=(l/2) then
            if y<=(l/2) then aux (x,y) x1 (l/2)
            else aux (x,(y-(l/2)) ) x4 (l/2)
          else
            if y<=(l/2) then aux ( (x-(l/2)), y) x2 (l/2)
            else aux ( (x-(l/2)) , (y-(l/2)) ) x3 (l/2)
      | Feuille _ -> failwith"error" (* pour ne pas avoir le "pattern-matching is not exhaustive" mais on aura jamais ce cas *)

  in if (lg a)<x || (lg a)<y then failwith"error" (* ne peux pas avoir la valeur None  *)
     else aux (x,y) a (lg a) ;;

color (6,6) exp;;

color (6,9) exp;;











