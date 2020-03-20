(* ex 5 *)

let rec alterne : 'a list->bool =
fun l -> match l with
  | [] | [_] -> true
  | [h1;h2] -> h1 <> h2 (* h1 != h2 *)
  | h1::h2::h3::t when h1 < h2 && h2 > h3 -> alterne (h2::h3::t)
  | h1::h2::h3::t when h1 > h2 && h2 < h3 -> alterne (h2::h3::t)
  | _ -> false ;;

alterne [1; 5; 4; 6];;


(* ex 6 *)

let rec schuffle : 'a list -> 'a list -> 'a list list =
  fun l1 l2 ->
    match (l1, l2) with
      | (x, []) | ([], x) -> [x]
      | (h1::t1, h2::t2) -> List.map (fun x -> h1::x) (schuffle t1 l2)
                            @ List.map (fun x -> h2::x) (schuffle l1 t2) ;;

schuffle [5;3] [2;4];;
