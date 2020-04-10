(* Exercice 1 *)

2/0 ;;

let division = fun x y ->
  try ( x/y) with
   _ -> 0 ;;


division 2 0 ;;

division 4 3 ;;


(* Exercice 2 *)

let logarithme = fun x ->
   if sin x > 0. then log(sin x) else failwith "Argument_invalide" ;;


(* Exercice 3 *)

exception Pas_trouve ;;

(* 1. *)
let rec trouve = fun p l ->
  match l with
  | [] -> raise Pas_trouve
  | h::t -> if p h then h else trouve p t ;;


(* 2. *)
let trouve_bis = fun p l ->
   try [trouve p l] with
   | Pas_trouve -> [] ;;


trouve_bis (fun x -> x mod 2 = 0) [ 1; 3; 5] ;;

trouve_bis (fun x -> x mod 2 = 0) [ 1; 3; 4; 5; 8] ;;


(* Exercice 4 *)

let rec zip = fun l l' ->
   match (l, l') with
   | [], [] -> []
   | (h::t, h'::t') -> (h, h') :: zip t t'
   | _ -> failwith "Longueurs différentes! " ;;

zip [1; 2; 3] [10; 20; 30] ;;

zip [1; 2; 3; 4] [10; 20; 30] ;;

Cette fonction utilise une exceptions pour le cas où les listes données en arguments ne sont pas de même longueur. C'est l'équivalent de la fonction prédéfinie List.combine de Ocaml. 


(* Exercice 5 *)

(* 1. *)
type 'a arbre = Vide | Noeud of 'a * 'a arbre * 'a arbre ;;

(* 2. *)

let ab = Noeud(10, 
                Noeud(6,
                    Noeud(1, Vide, Noeud(3, Vide, Vide) ),
                    Vide),
                Noeud(14, Vide, Vide)) ;;

(* 3. *)
(* a) *)
let rec hauteur = fun a ->
  match a with
  | Vide -> 0
  | Noeud(_, g, d) -> 1 + max (hauteur g) (hauteur d) ;;

hauteur ab ;;


(* b) *)

let equilibre = fun a -> 
   match a with
   | Vide -> true
   | Noeud(_, g, d) -> hauteur g = hauteur d ;;

equilibre ab ;;

(* c) *)
Cette fonction n'est efficace parce qu'elle parcourt tout l'arbre pour calculer sa hauteur. 

(* 4. *)
(* d) *)

exception Desequilibre ;;

let rec equi_hauteur = fun a ->
   match a with 
   | Vide | Noeud(_, Vide, Vide) -> true
   | Noeud(_, _, Vide) | Noeud(_, Vide, _) -> raise Desequilibre
   | Noeud(_, g, d) -> try (equi_hauteur g) && (equi_hauteur d) with
                       | Desequilibre -> raise Desequilibre ;; 

#trace equi_hauteur;;

equi_hauteur ab ;;


(* e) *)
let equilibre_rapide = fun a ->
   try equi_hauteur a with
   | _ -> false ;;

equilibre_rapide mon_a ;;


(* Exercice 6 *)

Cet exercice doit être compilé pour être testé à cause de l'utilisation des E/S qu'on y fait.

(* 1. *)

exception Erreur_bornes ;;

exception Erreur_lire ;;


let lire_entier = fun (inf, sup) ->
    print_string  ( "borne inf : " ^ (string_of_int inf) ^"\n");
    print_string ( "borne sup : " ^ (string_of_int sup) ^"\n" ) ;
    print_string "Entrer un entier entre ces 2 bornes : " ;
    let x = try read_int() with
          _ -> raise Erreur_lire 
  in if x <= sup && x >= inf then x else raise Erreur_bornes ;;


(* 2. *)

let main() = begin print_string "Début du jeu : "; 
                  try let x = lire_entier (1, 50) in (print_int x; print_newline()) with
                   | Erreur_bornes -> begin 
                       print_string "Erreur bornes ! ";   print_newline() end
                   | Erreur_lire -> begin 
                        print_string "Erreur lecture ! "; print_newline() end
             end ;;

main() ;;

(* ocamlc lireEntier.ml -o lireEntier.out *)

(* 3. *)

exception Erreur_lire ;;

let rec lire_entier = fun (inf, sup) ->
    print_string  ( "borne inf : " ^ (string_of_int inf) ^"\n");
    print_string ( "borne sup : " ^ (string_of_int sup) ^"\n" ) ;
    print_string "Entrer un entier entre ces 2 bornes : " ;
    let x = try read_int() with
          _ -> raise Erreur_lire 
  in if x <= sup && x >= inf then x else lire_entier (inf, sup) ;;

(* 4. *)

let deviner = fun i (inf, sup) ->

  (* on ajuste l'argument de Random.int pour être dans [inf .. sup] *)
  let d = Random.int (sup-inf+1) + inf in 

   let rec aux = fun j -> 
    if j > i then "Echec"
    else try (if (lire_entier (inf, sup) = d) 
                then "Bravo"
                else (print_string "pas encore trouve!";
                       print_newline(); aux (j+1)));
              
           with Erreur_lire  -> print_string "ce n'est pas un entier!";
                                print_newline();
                                aux (j+1)
  in aux 1 ;;


let main() = 
  print_string "Début du jeu : "; 
  let essais = int_of_string Sys.argv.(1) 
   and mini = int_of_string Sys.argv.(2) 
   and maxi = int_of_string Sys.argv.(3)
  in begin Random.self_init() ; print_string(devine essais (mini, maxi)); print_newline() end  ;;


main() ;;


(* ocamlc -c deviner.ml -o deviner.out *)


