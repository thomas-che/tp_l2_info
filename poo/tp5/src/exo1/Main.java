package exo1;

import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {

        // Run > Edit configuration ... > Program argument > taper les varleurs avec des espaces entre

        int somme =0;
        int nbErreurs = 0;
        for (String arg : args) {
            //Integer i =(Pattern.matches("[+-]?\\d+",arg));
            if ((Pattern.matches("[+-]?\\d+", arg))) {
                somme += Integer.parseInt(arg);
            }
            else {
                nbErreurs++;
            }
        }
        System.out.println("Somme des arguments " + somme);
        System.out.println("cb d erreur ? " + nbErreurs);


    }
}
