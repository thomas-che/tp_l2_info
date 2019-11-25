package ex2;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.Scanner;

public class MainBis {
    public static void main(String[] args) throws FileNotFoundException {
        Personnel p = new Personnel();
        Scanner sc = new Scanner (new File("/home/thomas/Documents/tp_l2_info/poo/tp3/src/ex2/employes.txt")) ;
        int i=0;
        while (sc.hasNextLine()) {
            String nom = new String("e"+i);
            System.out.println(nom);
            Employe nom = new Employe(sc.next(),sc.nextDouble(), LocalDate.of(sc.nextInt(),sc.nextInt(),sc.nextInt()) );
            System.out.println("emploiye : n° "+i+" est : "+nom);
            i++;
        }

    }
}
