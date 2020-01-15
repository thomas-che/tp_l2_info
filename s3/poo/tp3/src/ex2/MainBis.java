package ex2;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.Scanner;

public class MainBis {
// il faut plustot recuperer l erreur car sinon le prgm plante    //
    public static void main(String[] args) throws FileNotFoundException {
        Personnel p = new Personnel();
        ///home/thomas/Documents/tp_l2_info/poo/tp3/src/ex2/
        Scanner sc = new Scanner (new File("employes.txt")) ;
        int i=1;
        while (sc.hasNextLine()) {
            System.out.println("ligne "+i);
            Employe e = new Employe(sc.next(),sc.nextDouble(), LocalDate.of(sc.nextInt(),sc.nextInt(),sc.nextInt()) );
        // pour retourner au debut de la prochaine ligne
            sc.nextLine();
            System.out.println(e);
            i++;
        }
    }

// avec le try catch  ; correction prof
    public static void main2(String[] args) {
        Personnel p = new Personnel();
        ///home/thomas/Documents/tp_l2_info/poo/tp3/src/ex2/

        Scanner sc = null;
        try {
            sc = new Scanner(new File("employes.txt"));

            int i=1;
            while (sc.hasNextLine()) {
                String ligne = sc.nextLine();
                Scanner in = new Scanner(ligne);
                String nom = in.next();
                double salaire= in.nextDouble();
                int annee= in.nextInt();
                int mois= in.nextInt();
                int jour= in.nextInt();
                Employe e = new Employe(nom,salaire, LocalDate.of(annee,mois,jour) );
                System.out.println(e);
                i++;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }




}
