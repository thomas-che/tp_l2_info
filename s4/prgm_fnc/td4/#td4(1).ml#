(* Corrigé du TD 4,  Wadoud BOUSDIRA *)

(* Exercice 1 *)

let rec inserer = fun ord e l -> 
  match l with 
    [] -> [e]
  | h::t as l -> if (ord e h) then e::l else h::(inserer ord e t) ;;

(* val inserer : ('a -> 'a -> bool) -> 'a -> 'a list -> 'a list = <fun> *)

let rec reduction = fun operator neutral l ->
  match l with 
    [] -> neutral
  | h::t -> operator h (reduction operator neutral t) ;;

(* val reduction : ('a -> 'b -> 'b) -> 'b -> 'a list -> 'b = <fun> *)

(* la fonction de tri polymorphe *)

let tri = fun ord l -> reduction (inserer ord) [] l;;

(* val tri : ('a -> 'a -> bool) -> 'a list -> 'a list = <fun> *)

(* des exemples : *)

tri ( < ) [9; 5; 2; 4; 4; 3; 6];;
(* - : int list = [2; 3; 4; 5; 6; 9] *)

tri ( > ) [9; 5; 2; 4; 4; 3; 6];;

(* Exercice 2 *)

List.fold_left ;;
(* - : ('a -> 'b -> 'a) -> 'a -> 'b list -> 'a = <fun> *)

List.fold_right ;;
(* - : ('a -> 'b -> 'b) -> 'a list -> 'b -> 'b = <fun> *)

List.fold_left ( + ) 0 [1; 2; 3; 4] ;;
(* - : int = 10 *)

List.fold_right ( + ) [1; 2; 3; 4] 0 ;;
(* - : int = 10 *)

List.fold_left ( - ) 0 [1; 2; 3; 4] ;;
(* - : int = -10 *)

List.fold_right ( - ) [1; 2; 3; 4] 0 ;;
(* - : int = -2 *)

(* 1 *)

(* reduction correspond au fold_right *)
reduction (-) 0 [1; 2; 3; 4] ;;


List.fold_right ( - ) [1; 2; 3; 4] 0 ;;
(* - : int = -2 *)

List.fold_left (fun x y -> "(f "^x^" "^y^")") "e" ["x0"; "x1"; "x2";"x3";"x4"];;
(* - : string = "(f (f (f (f (f e x0) x1) x2) x3) x4)" *)

List.fold_right (fun x y -> "(f "^x^" "^y^")") ["x0"; "x1"; "x2";"x3";"x4"] "e";;
(* - : string = "(f x0 (f x1 (f x2 (f x3 (f x4 e)))))" *)

let reduction_droite operator neutral l = List.fold_right operator l neutral ;;
(* val reduction_droite : ('a -> 'b -> 'b) -> 'b -> 'a list -> 'b = <fun> *)

reduction_droite ( - ) 0 [1;2;3;4] ;;
(* - : int = -2 *)

reduction_droite (fun x y -> "(f "^x^" "^y^")") "e" ["x0"; "x1"; "x2";"x3";"x4"] ;;
(* - : string = "(f x0 (f x1 (f x2 (f x3 (f x4 e)))))" *)

(* 2 *)

let rec reduction_gauche operator neutral = function
    [] -> neutral
  | h::t -> reduction_gauche operator (operator neutral h) t ;;

(* val reduction_gauche : ('a -> 'b -> 'a) -> 'a -> 'b list -> 'a = <fun> *)

reduction_gauche ( - ) 0 [1;2;3;4];;

(* - : int = -10 *)

reduction_gauche (fun x y -> "(f "^x^" "^y^")") "e" ["x0"; "x1"; "x2";"x3";"x4"] ;;
(* - : string = "(f (f (f (f (f e x0) x1) x2) x3) x4)" *)

let rec reduction_gauche operator neutral = function
    [] -> neutral
  | h::t -> reduction_gauche operator (operator neutral h) t ;;
(* val reduction_gauche : ('a -> 'b -> 'a) -> 'a -> 'b list -> 'a = <fun> *)

reduction_gauche ( - ) 0 [1;2;3;4];;
(* - : int = -10 *)

reduction_gauche (fun x y -> "(f "^x^" "^y^")") "e" ["x0"; "x1"; "x2";"x3";"x4"];;
(* - : string = "(f (f (f (f (f e x0) x1) x2) x3) x4)" *)


(* Exercice 3 *)

(* val cut_list : 'a list -> int -> int -> 'a list = <fun> *)

let cut_list = fun l a b ->
  let rec aux = fun l i res ->
    match (i, l) with
      | (j, []) -> res
      | (j, h::t) -> if j < a then aux t (j+1) res
	else if j <b then aux t (j+1) (res@[h])
	else res
  in if a > b then failwith "b < a ! "
     else if b < 0 || a < 0 then failwith "a, b < 0 ! " 
     else aux l 0 [] ;;

(* Exception: Failure "b < a ! ". *)
cut_list [1;2;3;4;5;6;7] 5 3 ;;

(* - : int list = [1;2] *)
cut_list [1;2;3;4;5;6;7] 0 2 ;;

(* - : int list = [] *)
cut_list [1;2;3;4;5;6;7] 2 2 ;;

(* - : int list = [3; 4; 5] *)
cut_list [1;2;3;4;5;6;7] 2 5 ;;

(* - : int list = [] *)
cut_list [1;2;3] 6 8 ;;

(* - : int list = [5] *)
cut_list [1; 2; 3; 4; 5] 4 8 ;;

(* Exercice 4 *)

(* val assoc_list : (string * int list) list =
  [("Pierre", [1; 2; 3]); ("Paul", [3; 1; 7]); ("Jacques", [9; 4; 1])] *)
let assoc_list = [("Pierre", [1;2;3]); ("Paul", [3;1;7]); ("Jacques", [9;4;1])];;

(* 1 *)

(* val recherche : 'a -> ('a * 'b list) list -> 'b list = <fun> *)
let rec recherche = function v -> function l ->
  match l with
    | [] -> []
    | (h1, h2)::t -> if h1=v then h2 else recherche v t ;;

(* - : int list = [3; 1; 7] *)
recherche "Paul" assoc_list ;;

(* - : int list = [] *)
recherche "Michel" assoc_list ;;

(* 2 *)

(* val change : 'a -> ('b -> 'b) -> ('a * 'b) list -> ('a * 'b) list = <fun> *)
let change = fun v f (l:('a * 'b list) list) ->
  let rec aux = fun l ->
    match l with
    | [] -> []
    | (h1, h2)::t -> if v=h1 then (h1, f h2):: t
                      else (h1, h2)::aux  t
  in aux l;;

(* version récursive terminale *)
let change' = fun v f (l:('a * 'b list) list) ->
  let rec aux = fun res l ->
    match l with
    | [] -> res 
    | (h1, h2)::t -> if v=h1 then res @[(h1, f h2)] @ t
      else aux (res@[(h1, h2)]) t
  in aux [] l;;


assoc_list ;;

(* - : (string * int list) list =
[("Pierre", [5; 1; 2; 3]); ("Paul", [3; 1; 7]); ("Jacques", [9; 4; 1])] *)
change "Pierre" (fun l -> 5::l) assoc_list ;;

(* 3 *)

(* val add : 'a -> 'b -> ('a * 'b list) list -> ('a * 'b list) list = <fun> *)
let add = fun v x l ->
  let ajout = fun y l  ->
    if List.mem y l then l else y::l
  in if recherche v l = [] then (v,[x])::l else change v (ajout x) l ;;
       

let l' = add "Michel" 10 assoc_list ;;

(* - : (string * int list) list =
[("Pierre", [1; 2; 3]); ("Paul", [8; 3; 1; 7]); ("Jacques", [9; 4; 1])] *)
add "Paul" 8 assoc_list ;;

assoc_list ;;

add "Michel" 10 l' ;;

add "Pierre" 5 assoc_list ;;

(* 4 *)

(* val mapAssoc : 'a -> ('b -> 'b) -> ('a * 'b list) list -> ('a * 'b list) list =
  <fun> *)
let mapAssoc = fun y f l ->
  change y (List.map f) l;;

assoc_list ;;

(* - : (string * int list) list =
[("Pierre", [2; 3; 4]); ("Paul", [3; 1; 7]); ("Jacques", [9; 4; 1])] *)
mapAssoc "Pierre" (fun x -> x+1) assoc_list ;;



