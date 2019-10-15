package exo4;

import javax.swing.plaf.synth.SynthRadioButtonMenuItemUI;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("saisie nb positif");
        int n;
        int sum=0;
        boolean reponse =false;
        reponse=sc.hasNextInt();
        while (n!=0) {
            System.out.println("saisie nb positif");
            n = sc.nextInt();
            reponse=sc.hasNextInt();
            if (reponse) {
                if (n>0) {
                    sum+=n;
                }

            }
            else {
                System.out.println("mauvaise saisi");
            }
        }
        System.out.printf("sum= "+sum);


    }
}
