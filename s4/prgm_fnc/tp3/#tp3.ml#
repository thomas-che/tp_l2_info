
(* ex 1 *)

let rec renverser = fun l ->
  match l with
  |[]->[]
  |h::t-> renverser t @ [h] ;;

renverser [1;2;3;4;5;6];;

let rec reduction = fun op neutral l ->
  match l with
   |[]-> neutral
   | h::t-> op h (reduction op neutral t) ;;

reduction (fun x y ->y @ [x] ) [] [1;2;3;4;5;6];;

  
(* ex 2 *)

let rec rep = fun nb c ->
  match nb with
  |0->[]
  |_->[c] @ rep (nb-1) c ;;
  
rep 3 "a" ;;
  
let rec deCompression = fun l ->
  match l with
  |[]->[]
  |h::t-> (rep (fst h) (snd h) ) @ deCompression t;;

deCompression [(3,'a') ; (1,'b') ; (1,'a') ; (2,'b')];;



  
let rec occu = fun l c ->
  match l with
  |[]->0
  |h::t->if h=c then  1+ occu t c
	 else occu t c;;
  
occu ["a";"a";"a"] "a" ;;

let rec compression = fun l ->
  match l with
  |[]->[]
  |h::t-> occu



  

(* ex correction 2 *)
  
let rec deCompression = fun l ->
  let rec aux1 = fun c ->
    match (fst c, snd c) with
    |(1,x) -> [x]
    |(n,x) -> x:: aux1 (n-1, x)
  in List.flatten(List.map aux1 l);;

  

deCompression [(3,'a') ; (1,'b') ; (1,'a') ; (2,'b')];;


let rec compression = fun l ->
  let rec aux = fun l n ->
    match l with
    |[]->[]
    |h::[]->[(n,h)]
    |h1::h2::t-> if h1=h2 then aux (h2::t) (n+1)
		 else (n,h1) :: aux (h2::t) 1
  in aux l 1;;

compression ['a' ; 'a' ; 'a' ; 'b' ; 'a' ; 'b' ; 'b' ];;



(* exo 3.1*)

let rec enum = fun n ->
  match n with
  |0->[0]
  |_-> enum (n-1) @ [n] ;;

let rec enum = fun n ->
  if n=0 then [0]
  else enum (n-1) @ [n] ;;

  enum 6;;


(* exo 3.1 correction *)    
let rec enum = fun n ->
  let rec aux = fun i ->
    if i<=n then i::aux(i+1) 
    else []
in aux 0;;

enum 6;;




(* exo 3.2*)
  
let rec enum_droite = fun i n ->
  if n=0 then [(i,0)]
  else enum_droite i (n-1) @ [(i,n)] ;;

enum_droite 4 5;;


(* exo 3.2 correction*)
let rec enum_droite = fun i n ->
  List.map (fun p -> (i,p)) (enum n) ;;

  enum_droite 4 5;;


(* exo 3.3*)

let rec enum_paire = fun n p ->
  let rec aux = fun i ->
     if i > n then []
     else enum_droite i p @ aux(i+1)
in aux 0;;

enum_paire 1 2 ;;
enum_paire 2 2 ;;



(* exo 3.4 correction*)

let rec table_mult = fun n ->
  List.map (fun (i,j) -> (i,j,i*j)) (enum_paire n n) ;;

table_mult 5;;




(* exo 4*)

let rec emballer = fun l ->
  match l with
  |[]->[]
  |h::t-> [h] ::  emballer t ;;

  emballer [1; 2; 3; 4];;

    
(* exo 4 correction*)

let emballer = fun l ->
  List.map (fun i -> [i]) l;;

  emballer [1; 2; 3; 4];;

(* exo 5.1*)

let rec nieme = fun l n ->
  let rec aux = fun i l ->
    if i=n then List.hd l
    else aux (i+1) (List.tl l)
  in if (List.length l)>(n-1) then aux 0 l
     else failwith"error";;

  nieme [1; 2; 3; 4] 4;;

    
    (* exo 5.2 correction *)

  let diagonale = fun m ->
    let rec diagonale_aux = fun n l ->
      match l with
      |[]->[]
      |h::t-> nieme h n :: diagonale_aux (n+1) t
    in diagonale_aux 0 m;;

diagonale [[12 ;2] ;[27 ;13]];;
      
diagonale [ [1; 2; 3];
	    [4; 5; 6];
	    [7; 8; 9] ] ;;
    


(* exo 5.2.2 correction *)

let decurryfier f (x,y) = f x y ;;
  
let from_to = fun n1 n2 ->
  let rec aux = fun n res ->
    if n > n2 then res
    else aux (n+1) (res@[n])
in if n1>n2 then []
   else aux n1 [];;

from_to 3 6 ;;


let diagonale m =
  List.map (decurryfier nieme) (List.combine m (from_to 0 (List.length m-1))) ;;


diagonale [ [1; 2; 3];
	    [4; 5; 6];
	    [7; 8; 9] ] ;;


(* exo 5.3 correction *)

let rec forall = fun p l ->
  match l with
  |[]->true
  |h::t-> if p h then forall p t
	  else false ;;

  
(* exo 5.4 correction *)

let rec verifier = fun l ->
  let lg = List.length l
  in (lg<>0) && forall (fun x -> List.length x =lg) l ;;

verifier [ [1; 2; 3];
	    [4; 5; 6];
	    [7; 89] ] ;;
		   
