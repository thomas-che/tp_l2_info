(* Corrigé de la feuille de TD TdRecursivit, Wadoud BOUSDIRA *)

(* Exercice 1 *)

(* x^y *)
(* 1. *)
let rec puissance = fun x y ->
  if y = 0 then 1 else x * puissance x (y-1) ;;
(* val puissance : int -> int -> int = <fun> *)

puissance 4 3 ;;
(* - : int = 64 *)

(* 2. *)
let puissance' = fun x y ->
  let rec aux = fun i res ->
    if i = 0 then res
     else aux (i-1) (x * res)
in aux y 1 ;;
(* val puissance' : int -> int -> int = <fun> *)

puissance' 4 3 ;;
(* - : int = 64 *)

(* Exercice 2 *)

let reste = fun x y ->
   let rec aux = fun i ->
    if i < y then i else aux (i-y) 
in aux x ;;
(* val reste : int -> int -> int = <fun> *)

reste 15 2 ;;
(* - : int = 1 *)

reste 23 8 ;;
(* - : int = 7 *)

let quotient = fun x y ->
  let rec aux = fun i res -> 
    if i <= y then res else aux (i-y) (1+res)
in aux x 0 ;;
(* val quotient : int -> int -> int = <fun> *)

quotient 15 2 ;;
(* - : int = 7 *)

quotient 47 5 ;;
(* - : int = 9 *)

(* Exercice 3 *)

let enum = function n -> 
  let rec aux = function i -> function res ->
    if i > n then res else aux (i+1) (res @ [i])
  in if n < 0 then [] else aux 0 [] ;;

enum 9 ;;
(* - : int list = [0; 1; 2; 3; 4; 5; 6; 7; 8; 9] *)

(* Exercice 4 *)

let supprimer = fun l e ->
  (* supprime une occurrence de e *)
  let rec aux = fun l res ->
   match l with
   | [] -> res
   | h::t -> if h = e then res @ t
              else aux t (res @ [h])
in aux l [] ;;


supprimer [1;2;3;4;5;6] 4 ;;

(* supprime toutes les occurrences de e *)
let supprimer = fun l e ->
  (* supprime une occurrence de e *)
  let rec aux = fun l res ->
   match l with
   | [] -> res
   | h::t -> if h = e then aux t res
              else aux t (res @ [h])
in aux l [] ;;


supprimer [1;2;3;4;5;4; 6] 4 ;;

supprimer [1;2;3;4;5;4; 6] 0 ;;

(* Exercice 4 *)

let rec renverse = fun l ->
     match l with
       | [] -> []
       | h :: t -> (renverse t) @ [h] ;;

renverse [1;2;3;4;5] ;;


let renverse' = fun l ->
   let rec aux = fun u l ->
     match l with
       | [] -> u
       | h :: t -> aux (h :: u) t
in aux [] l ;;

renverse' [1;2;3;4;5] ;;

(* renverse [1; 2; 3; 4] = (renverse [2; 3; 4]) @ [1] = ((renverse [3; 4]) @ [2]) @ [1] =
  (((renverse [4]) @ [3]) @ [2]) @ [1] = ((((renverse []) @ [4]) @ [3]) @ [2]) @ [1] = 
  ((([] @ [4]) @ [3]) @ [2]) @ [1] = [4; 3; 2; 1]

  renverse' [1; 2; 3; 4] = aux [] [1; 2; 3; 4] = aux (1::[]) [2; 3; 4] = aux [1] [2; 3; 4] = 
  aux (2 :: [1]) [3; 4] = aux [2; 1] [3; 4] = aux (3 ::[2; 1]) [4] = aux [3; 2; 1] [4] =
  aux (4 :: [3; 2; 1]) [] = aux [4; 3; 2; 1] [] = [4; 3; 2; 1]

renverse' est récursive terminale. De plus, elle utilise l'opérateur :: (ajout en tête) 
plus performant que l'ajout en fin qui parcourt séquentiellement la liste pour ajouter en fin. *)

(* Exercice 5 *)

(* 1. *)
let supprimer_1_occ = fun l e ->
  let rec aux = fun l res ->
   match l with
   | [] -> res
   | h::t -> if h=e then res @ t else aux t (res @ [h])
in aux l [] ;;
(* val supprimer_1_occ : 'a list -> 'a -> 'a list = <fun> *)

supprimer_1_occ [1; 2; 3; 5; 2; 5; 4; 2; 8] 2 ;;
(* - : int list = [1; 3; 5; 2; 5; 4; 2; 8] *)

(* 2. *)
let supprimer = fun l e ->
  let rec aux = fun l res ->
   match l with
   | [] -> res
   | h::t -> if h=e then aux t res else aux t (res @ [h])
in aux l [] ;;
(* val supprimer : 'a list -> 'a -> 'a list = <fun> *)

supprimer [1; 2; 3; 5; 2; 5; 4; 2; 8] 2 ;;
(* - : int list = [1; 3; 5; 5; 4; 8] *)


(* Exercice 6 *)

let int_to_binaire = fun n ->
   let rec aux = fun n res ->
    if n < 2 then n::res else aux (n/2) (n mod 2::res)
in aux n [] ;;
(* val int_to_binaire : int -> int list = <fun> *)

int_to_binaire 13 ;;
(* - : int list = [1; 1; 0; 1] *)

let binaire_to_int = fun l ->
  let rec aux = fun l res ->
  match l with 
  | [] -> res
  | h::t -> aux t (res*2 + h)
in aux l 0 ;; 
(* val binaire_to_int : int list -> int = <fun> *)

binaire_to_int [1; 1; 0; 1] ;;
(* - : int = 13 *)


(* Exercice 7 *)

let rec reduction = fun operator neutral l ->
   match l with
     | [] -> neutral
     | h::t -> operator (reduction operator neutral t) h ;;
(* val reduction : ('a -> 'b -> 'b) -> 'b -> 'a list -> 'b = <fun> *)

reduction ( - ) 0 [ 1; 2; 3; 4] ;;
(* - : int = -10 *)

let reduction_rt = fun operator neutral l ->
  let rec aux = fun res l ->
  match l with
  | [] -> res
  | h::t ->  aux (operator res h) t
in aux neutral l ;;

reduction_rt ( - ) 0 [ 1; 2; 3; 4] ;;



