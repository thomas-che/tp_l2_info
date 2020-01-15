package exo2;

import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {

        int tab[] = {1,13,4,15,32,25} ;

        Predicate<Integer> PlusGrandQue10 =new Sup10();
        for ( int i : tab) {
            if (PlusGrandQue10.test(i)) {
                System.out.println( "10<"+i);
            }
        }

        // on cree une class interne anonyme => pas de nom, redefinit methodes que on a besoin
        Predicate<Integer> PlusPetitQue20 =new Predicate<Integer> () {
            @Override
            public boolean test(Integer integer) {
                return integer<=20;
            }
        };

        for ( int i : tab) {
            if (PlusPetitQue20.test(i) && PlusGrandQue10.test(i)) {
                System.out.println( "10<"+i+"<=20");
            }
        }

        // correction avec le predicate
        for ( int i : tab) {
            if (PlusPetitQue20.and(PlusGrandQue10).test(i)) {
                System.out.println("avec predicate : " + i);
            }
        }



        // ou plus simple lamda expresion
        Predicate<Integer> PlusPetitQue20_V2 = integer -> integer<=20;

    }

}
