package tp4.exo3;

import java.util.Arrays;
import java.util.function.Predicate;

public class ExemplePredicateCours {
    public static int[] selectionne(int[] lesValeurs, Predicate<Integer> predicate){
        int[] valeursSelectionnees = new int[lesValeurs.length];
        int nb= 0;
        for (int v : lesValeurs){
            if(predicate.test(v)){
                valeursSelectionnees[nb++]=v;
            }
        }
        return Arrays.copyOf(valeursSelectionnees,nb);
    }
    public static void main(String[] args) {
        int[] tab={1, -23, 56, -67, 10, -11};
        int[] e1 =ExemplePredicateCours.selectionne(tab, new Predicate<Integer>() {
            @Override
            public boolean test(Integer i) {
                return i>0;
            }
        });
        System.out.println(Arrays.toString(e1));
        int[] e1bis =selectionne(tab,(Integer i) -> {return i>0;});
        System.out.println(Arrays.toString(e1bis));


        int[] e2 =ExemplePredicateCours.selectionne(tab, new Predicate<Integer>() {
            @Override
            public boolean test(Integer i) {
                return i<0;
            }
        });
        System.out.println(Arrays.toString(e2));
        int[] e2bis =selectionne(tab,i -> i<0);
        System.out.println(Arrays.toString(e2bis));
    }
}