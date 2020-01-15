package exo2;

import java.util.function.Predicate;

public class Sup10 implements Predicate<Integer> {

    @Override
    public boolean test(Integer integer) {
        return 10<integer ;
    }

}
