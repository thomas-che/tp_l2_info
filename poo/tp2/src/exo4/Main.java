package exo4;

import javax.swing.plaf.synth.SynthRadioButtonMenuItemUI;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n;
        int sum = 0;
        boolean reponse = false;

        do {

            do {
                System.out.println("saisie nb positif");
                reponse = sc.hasNextInt();
                n = sc.nextInt();
                if (reponse != true || 0 < n) { // erire negation corecteemnt
                    System.out.println("erreur de saisie, veuillez recomencer");
                }

            } while (reponse);
                sum += n;


        } while (n != 0);
            System.out.println("ok on continue");

        System.out.println("fin");

    }
}

