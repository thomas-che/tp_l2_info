package ex2;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        Employe e1 = new Employe("michel",1000.0, LocalDate.of(2009,11,20) );
        Employe e2 = new Employe("caro",2500.0, LocalDate.of(2012,1,3) );
        /*System.out.println(e1.toString() );
        System.out.println(e2.toString() );
        Responsable r1 = new Responsable("boss",10000.0, LocalDate.of(2009,11,20),"n+1",15,e1,e2);
        System.out.println(r1);
        System.out.println(r1.calculerSalaireBrutMensuel());
        System.out.println(e1.calculerSalaireBrutMensuel());*/
        Personnel p = new Personnel();
        p.ajouterEmploye(e1);
        p.ajouterEmploye(e2);
        System.out.println(e2.toString() );
        System.out.println(p);
        // pb e2 n est pas dans le tableau
        System.out.println(p.rechercherEmploye(1));
        System.out.println(p.montantSalairesBrutsMensuels());
    }
}