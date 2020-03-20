(* EXO 1 *)

(* ex 1.1 *)
type valeur_logique =
  | Vrai
  | Faux
  | Indefini ;;

(* ex 1.2 *)

type formule_logique =
  | Et of formule_logique*formule_logique
  | Non of formule_logique
  | Valeur of valeur_logique;;

let f = Et(Valeur Faux, Et( Valeur Vrai, Valeur Indefini)) ;;


(* ex 1.3 *)

let rec compte_et = fun f ->
  match f with
    | Et(j,k) -> 1 + compte_et j + compte_et k 
    | Non(j) -> compte_et j  
    | Valeur _ -> 0 ;;


compte_et f;;

(* ex 1.4 CORRECTION *)

let rec evaluer = fun f -> 
  match f with
  |Valeur v -> v
  |Non (Valeur Indefini) -> Indefini
  |Non (Valeur Vrai) -> Faux
  |Non (Valeur Faux) -> Vrai
  |Non f -> let x =  evaluer f in evaluer(Non (Valeur x))
  |Et (Valeur Faux, _) | Et (_, Valeur Faux) -> Faux
  |Et (Valeur Indefini, f) | Et (f, Valeur Indefini) -> Indefini
  |Et (Valeur Vrai, Valeur Vrai) -> Vrai
  |Et (f, g) -> let x1 = evaluer f and x2 = evaluer g in evaluer (Et (Valeur x1, Valeur x2)) ;;


evaluer f;;

  
let f1 = Et(Non(Valeur Faux), Valeur Vrai)
and f2 = Et(Valeur Faux, Non(Valeur Vrai)) ;;
  
let f3 = Et(Valeur Indefini, f2)
 and f4 = Et(f2, Valeur Indefini)
and f5 = Et(Non f2, Valeur Indefini) ;;


(* ex 1.5 *)

let equivalent_syntaxique = fun f1 f2 ->
  if f1=f2 then true else false ;;

equivalent_syntaxique f2 f3;;
    

(* ex 1.6 CORRECTION *)
  
let equivalent_sementique = fun f1 f2 -> (evaluer f1)= (evaluer f2) ;;

equivalent_sementique (Valeur Faux) (Non(Valeur Vrai) );;

evaluer f3;;
evaluer f2;;




(* ################################################## *)

(* EXO 2 *)

  
(* ex 2.1 *)
  
type 'a formule_avec_var =
  | Valeur of valeur_logique
  | Variable of 'a 
  | Et of 'a formule_avec_var * 'a formule_avec_var
  | Non of 'a formule_avec_var  ;;


let f = Et( Variable "x", Et(Variable "y", Valeur Vrai) ) ;;



(* ex 2.2 CORRECTION*)
  
let rec est_close = fun f ->
  match f with
    | Et(j,k) -> est_close j && est_close k 
    | Non(j) -> est_close j  
    | Valeur _ -> true
    | Variable _ -> false ;;

est_close f ;;
est_close (Et(Non(Valeur Faux), Valeur Vrai)) ;;

  

(* ex 2.3 CORRECTION*)

let rec substitution = fun v f g ->
  match f with
  |Variable x -> if x=v then g else Variable x
  |Valeur x -> Valeur x
  |Non k -> Non (substitution v k g)
  |Et (k, m) -> Et (substitution v k g, substitution v m g) ;;
  
substitution "x" f (Valeur Indefini);;
  
  

(* ex 2.4 CORRECTION*)
  
let rec to_string = fun (a_to_string: 'a-> string) f ->
  match f with
  | Valeur x -> a_to_string x
  | Variable Vrai ->" vrai"
  | Variable Faux ->" faux"
  | Variable Indefini ->" indefini"
  | Et (j,k) -> "( " ^ to_string a_to_string j ^ "&" ^ to_string a_to_string k ^ " )"
  | Non j -> "not( " ^ to_string a_to_string j ^ " )"  ;;


  to_string (fun s-> s) (Et( Variable "x", Et(Variable "y", Valeur Vrai) ) );;
  
