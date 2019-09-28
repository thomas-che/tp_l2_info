package exo6;

public class Main {

    public static void main(String[] args) {

        boolean[] tab = new boolean[11];
        for (int i = 2; i < tab.length ; i++) {
            tab[i]=true;
        }

        for (int i = 2; i < tab.length ; i++) {

            for ( int j =2 ; j<tab.length ; j++ ) {
                if ( i%j == 0 && i!=j ) {
                    tab[i]=false;
                    break;
                }
            }
        }
        for (int i = 0; i < tab.length ; i++) {
            System.out.println(i + "\t valeur \t" + tab[i]);
        }
        System.out.println("##########################");
        for (int i = 0; i < tab.length ; i++) {
            if (tab [i] == true) {
                System.out.println(i + "\t valeur \t" + tab[i]);
            }
        }
    }
}

// correction prof

public class Main {

    public static void main(String[] args) {

        boolean[] tab = new boolean[11];
        for (int i = 2; i < tab.length ; i++) {
            tab[i]=true;
        }

        for (int i = 2; i < tab.length ; i++) {
            if (tab[i]) {
                int j=2 ;
                while (i*j<tab.length) {
                    tab[i * j] = false;
                    j++;
                }
            }
        }
        for (int i = 0; i < tab.length ; i++) {
            System.out.println(i + "\t valeur \t" + tab[i]);
        }
    }
}











