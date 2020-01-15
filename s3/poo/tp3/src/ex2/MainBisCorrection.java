package ex2;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.Scanner;

public class MainBisCorrection {

    // avec le try catch  ; correction prof
    public static void main(String[] args) {
        Personnel p = new Personnel();
        ///home/thomas/Documents/tp_l2_info/poo/tp3/src/ex2/

        Scanner sc = null;
        try {
            sc = new Scanner(new File("employes.txt"));

            int i = 1;
            while (sc.hasNextLine()) {
    // c est mieux de tester les parametres avant de appeler la methode
                String ligne = sc.nextLine();
         // lit toute la ligne
                Scanner in = new Scanner(ligne);
         // recupere chaque arg de la ligne
         // normalement test avant chaque var si la var est du bon type ex: hasnextInt()
                String nom = in.next();
                double salaire = in.nextDouble();
                int annee = in.nextInt();
                int mois = in.nextInt();
                int jour = in.nextInt();
                Employe e = new Employe(nom, salaire, LocalDate.of(annee, mois, jour));
                System.out.println(e);
                i++;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
