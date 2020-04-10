(* Corrigé du TD5, Wadoud BOUSDIRA *)

(* Exercice 1 *)

(* 1. *)
(* val map2 : ('a -> 'b -> 'c) -> 'a list -> 'b list -> 'c list = <fun> *)
let map2 = fun op l1 l2 ->
  let rec aux = fun l1 l2 res ->
  match l1, l2 with
  | [], [] -> res
  | h1::t1, h2::t2 -> aux t1 t2 (res @[op h1 h2])
  | _ -> failwith "erreur "
in aux l1 l2 [] ;; 

map2 (+) [1;2;3] [3;2;1] ;;

map2 (+) [1;2;3] [3;2;1;0] ;;
(* Exception: Failure "erreur ". *)

(* 2. *)

(* val select : ('a -> bool) -> 'a list -> 'b list -> 'b list -> 'b list = <fun> *)
let select = fun filter l1 l2 l3 ->
  let rec aux = fun l1 l2 l3 res ->
   match l1 , l2, l3 with
   | [], [], [] -> res
   | h1::t1, h2::t2, h3::t3 -> if filter h1 then  aux t1 t2 t3 (res @ [h2])
                                else aux t1 t2 t3 (res @ [h3])
   | _ -> failwith "erreur "
in aux l1 l2 l3 [] ;;

select (fun x -> x=0) [1; 0; 0; 1] ['a'; 'b'; 'c'; 'd'] ['A';'B';'C';'D'] ;;
(* - : char list = ['A'; 'b'; 'c'; 'D'] *)


(* 3. *)

(* val f : ('a -> bool) -> 'a list -> 'b list -> 'b list -> 'b list = <fun> *)
let f = fun filter l1 l2 l3 ->
  select filter l1 (select filter l1 l2 l3) (select filter l1 l3 l2) ;;


f (fun x -> x=0) [1;0;0;1] ['a';'b';'c';'d'] ['A';'B';'C';'D'] ;;
(* - : char list = ['a'; 'b'; 'c'; 'd'] *)

min ;;
(* - : 'a -> 'a -> 'a = <fun>, min est prédéfinie en Ocaml *)

let min' = fun l1 l2 -> map2 min l1 l2 ;;
(* val min' : 'a list -> 'a list -> 'a list = <fun> *)


min' [1; 5; 3; 8] [2; 6; 7; 6] ;;
  

(* Exercice 2 *)


(* 1 *)
type 'a abf = Leaf of 'a | Node of 'a abf * 'a abf ;;

(* 2 *)
let a = Node (Node (Node( Leaf 'Y', Leaf 'N'),
		    Leaf 'O'),
	      Node( Node( Leaf 'I', Leaf 'E'),
		    Node( Leaf 'U', Leaf 'S')));;
		  
(* 3 *)

exception Not_found;;

(* val decode_info : 'a abf -> bool list -> 'a = <fun> *)

let decode_info = fun a -> fun code -> 
  let rec aux = fun a code -> 
  match (a, code) with
    | (Leaf x, []) -> Some x
    | (Node(x, y), h::t) -> if h then aux x t 
                                  else aux  y t 
    | _ -> raise Not_found
    
  in try (aux a code) with
  | Not_found -> None ;;

(* - : char option = Some 'N' *)
decode_info a [true; true; false];;

(* - : char option = Some 'I' *)
decode_info a [false; true; true] ;;

(* char option = None *)
decode_info a [true; false; true];;

(* une solution sans exception *)

let decode_info = fun ab code ->
  let rec aux = fun a l ->
    match (a, l) with
    | (Leaf x, []) -> x
    | (Node (x, y), []) -> failwith "n'existe pas! "
    | (Leaf x, h::t) -> failwith "n'existe pas! "
    | (Node(x, y), h::t) -> if h then aux x t 
      else aux y t
  in aux ab code ;;

(* - : char = 'N' *)
decode_info a [true; true; false];;

(* - : char = 'I' *)
decode_info a [false; true; true] ;;

(* Exception: Failure "n'existe pas! ". *)
decode_info a [true; false; true];;


(* 4 *)

exception No_code ;;

(* val code_info : 'a abf -> 'a -> bool list option = <fun> *)

let code_info = fun a -> fun info -> 
  let rec aux = fun a res ->
    match a with
      | Leaf x -> if x=info then Some res else raise No_code
      | Node(x, y) -> begin try aux x (res@[true]) with
	  | _ -> begin try aux y (res@[false]) with
	      | _ -> raise No_code
	    end 
	end
 in try (aux a []) with
  | No_code ->  None ;;

(* - : bool list option = Some [true; false] *)
code_info a 'O';; 

(* - : bool list option = Some [false; true; false] *)
code_info a 'E';;

(* - : bool list option = None *)
code_info a 'A';;

(* solution sans exception *)

let code_info = fun a -> fun info -> 
  let rec aux = fun a res ->
    match a with
      | Leaf x -> if x=info then Some res else None
      | Node(x, y) -> if aux x (res@[true]) = None then 
	                 aux y (res@[false]) else aux x (res@[true])
  in aux a []  ;;

(* - : bool list option = Some [true; false] *)
code_info a 'O';; 

(* - : bool list option = Some [false; true; false] *)
code_info a 'E';;

(* - : bool list option = None *)
code_info a 'A';;


(* 5 *)

(* val build_dictionnaire : 'a abf -> ('a * bool list) list = <fun> *)

let build_dictionnaire = fun a -> 
  let arbre = a in
  let rec aux = fun a res ->
    match a with
      | Leaf x -> begin let u = code_info arbre x in 
		  match u with 
		    Some v -> res@[(x, v)]
		  end
      | Node(x, y) -> let res1 = aux x res in
	  aux y res1
  in aux a [];;


(* - : (char * bool list) list =
[('Y', [true; true; true]); ('N', [true; true; false]); ('O', [true; false]);
 ('I', [false; true; true]); ('E', [false; true; false]);
 ('U', [false; false; true]); ('S', [false; false; false])] *)
build_dictionnaire a ;;

(* 6 *)

(* val cherche_dictionnaire : 'a abf -> 'a -> bool list = <fun> *)
let cherche_dictionnaire = fun dico -> fun info ->
    (*let dico = build_dictionnaire a in*)
    List.assoc info dico;;

(* - : bool list = [false; true; true] *)
cherche_dictionnaire (build_dictionnaire a) 'I';;


