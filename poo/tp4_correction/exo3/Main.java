package tp4.exo3;

import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        int[] tab = {2, 15, 3, 13, 9, 10, 25};
        Predicate<Integer> plusGrandQue10 = new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer > 10;
            }
        };
		Predicate<Integer> greaterThanTen = (i) -> i > 10;
        Predicate<Integer> plusPetitQue20 = new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer <20 ;
            }
        };
        System.out.println("Plus grangs que 10") ;
        for (int i : tab) {
            if (plusGrandQue10.test(i))
                System.out.println(i);
        }
        System.out.println("Compris entre10 et 20") ;
        for (int i : tab) {
            if (plusGrandQue10.and(plusPetitQue20).test(i))
                System.out.println(i);
        }
    }
/*
        Predicate<Integer> greaterThanTen = (i) -> i > 10;
        // Creating predicate
        Predicate<Integer> lowerThanTwenty = (i) -> i < 20;
        boolean result = greaterThanTen.and(lowerThanTwenty).test(15);
        System.out.println(result);

        // Calling Predicate method
        boolean result2 = greaterThanTen.and(lowerThanTwenty).negate().test(15);
        System.out.println(result2);
    }
    */

}


