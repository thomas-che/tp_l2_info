let rec produit = fun n ->
  if n<10 then n
  else n mod 10 *produit(n/10);;

produit 234;;
produit 2340;;

(* correction optimiser*)
  
let rec produit' = fun n ->
  if n<10 then n
  else let i = n mod 10 in
       if i =0 then 0
       else i *produit'(n/10);;

produit' 2340;;
#trace produit' (* pour voir l execution*)    
 
  
let rec ex2 = fun n -> let i =10 in
  if n mod i < n mod i*10 then ex2 n i
  else ex2 ( n/10*i + n mod i  + (n mod i)*10  )  i;;

ex2 614;;


(* correction ex2 *)
let rec ordonnancer = fun n ->
  let rec placer = fun chiffre v ->
    if chiffre >= (v mod 10) then v*10 + chiffre 
    else (placer chiffre (v/10)) *10 + v mod 10
  in
  if n < 10 then n
  else let x = ordonnancer (n/10)
       in placer (n mod 10) x ;;


ordonnancer 3714;;
ordonnancer 950;;

Char.escaped 's';;
String.sub "abc" 0 1;;

(* ex 3*)

let rec rep = fun n s ->
  if n <= 0 then ""
  else s ^ (rep (n-1) s);;

rep 3 "t";;

(* ex 4*)

let rec sablier' = fun c ->
  let rec succ = fun i->
    if i=0 then 0
    else 1+succ(i-1)
  in 
  if (String.length c) >=2   then c ^ "\n"^ (rep (succ 0)  " " )  ^ sablier' (String.sub c 1 ((String.length c)-2)  ) ^ "\n" ^ c
  else c ;;

print_string (sablier' "bonjour");;




    
let rec sablier = fun c -> 
  if (String.length c) >=2   then c ^ "\n" ^ sablier (String.sub c 1 ((String.length c)-2)  ) ^ "\n" ^ c
  else c ;;

print_string (sablier "bonjour");;


(* correction*)
  let rec sablier2 = fun s ->
    let rec blanc = fun n->
      if n=0 then ""
      else " " ^blanc(n-1)
    in
    let rec aux = fun s i ->
      let lg= String.length s in
      if lg=1 || lg=2 then (blanc i) ^s
      else (blanc i)^s"\n"^aux(String.sub s 1 (lg-2)) (i+1) "\n" ^ (blanc i) ^s

    in
     if s = "" then print_newline()
     else begin print_newline(); print_string( aux s 0) ; print_newline() end;;
										
sablier2 "bonjour";;

  
(* ex 6*)

let rec string_split = fun s c ->
  match s with
  |""->[]
  |_->if (String.sub s 0 1)=c then (String.sub s 0 1) :: string_split (String.sub s 1 (String.length s)) c
      else (String.sub s 0 1) ^ string_split (String.sub s 1 (String.length s)) c;;

string_split ("on fait quoi deja dans ce tp") (" ");;

#trace string_split "on fait quoi deja dans ce tp" " ";;

(* ex corriger 6*)

let string_split = fun s c->

  let rec aux = fun s car i ->
    let lg = String.length s in
    if i = lg then [s]
    else
      if s.[i] = car then
      let s' = String.sub s (i+1) (lg-i-1) in
       (String.sub s 0 i) :: aux s' car 0
      else aux s car (i+1)

  in aux s c.[0] 0;;

string_split "on fait quoi deja dans ce tp" " ";;
      
    


   
