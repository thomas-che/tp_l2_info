(* lancer en ocaml : ctl+C ctl+E *)



(* EX 1 *)
let est_multiple = fun x y -> if x mod y = 0 then true else false;;
est_multiple 4 2;;

(* CORRECTION *)

let est_mul = fun x y -> x mod y = 0;;
  est_mul 4 2;;

(* EX 2 *)

let somme_f_i = fun x y -> x +. float_of_int(y);;
somme_f_i 1.2 5;;

(* EX 3 *)

let rec f = fun (n,(x,y)) ->
  if n = 0 then (x-n)*(y+n)
  else (x-n)*(y+n) + f(pred n,(x,y));;
			     
f (3,(1,2));;
	
(* CORRECTION ; ma fonction marche !! *) 
let rec fc  = fun (n,(x,y)) ->
  if n<0 then failwith "indefini"
  else let rec aux = fun i x y n ->
	       if i>n then 0
	       else (x-i)*(y+i) + aux (i+1) x y n in aux 0 x y n;;

fc (3,(1,2));;
	
(* EX 4 *)
let f = fun x -> x=true ;;
let neg_bf = fun y -> f y ;;
neg_bf not;;


(* CORRECTION *)

let neg_bfC = fun f -> f true || f false;;
neg_bfC not;;
neg_bfC (fun x -> false);;

(* EX 5 *)
let double_arg= fun f x -> f x x ;;
let x16 = fun a -> double_arg (^) (double_arg (^) (double_arg (^) (double_arg (^) a) ) ) ;;

x16 "ab";;

(* EX 6 *)

let rec de_b_en_10 = fun n b ->
  if n<b then n
  else (de_b_en_10 (n/10) b )* b + n mod 10;;
  de_b_en_10 1101 2;;

let rec de_10_en_b = fun n b ->
  if n mod b <b then n
  else (de_10_en_b (n/b) b )* 10 + n mod b;;
  de_10_en_b 13 10;;