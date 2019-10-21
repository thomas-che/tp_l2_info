package ex2;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Employe {
    private String nom;
    private static int matricule;
    private double salaire;
    private LocalDate dateEmbauche ; //=LocalDate of (int year, int month, int dayOfMonth);

    public static int compteur = 1;

    public Employe (String nom,Double salaire, LocalDate dateEmbauche) {
        this.matricule=compteur++;
        this.nom=nom;
        this.salaire=salaire;
        this.dateEmbauche=dateEmbauche;

    }
    public static int getMatricule () {
        return compteur;
    }


    @Override
    public String toString() {
        return "Employe{" +
                "nom='" + nom +
                ", matricule=" + matricule+
                ", salaire=" + salaire +
                ", dateEmbauche=" + dateEmbauche +
                '}';
    }

    public double calculerSalaireBrutMensuel() {
        double salaireCalc = 0.0;
        LocalDate dateDuJour = LocalDate.now();
        long anner = ChronoUnit.YEARS.between(dateEmbauche,dateDuJour);
        if (9 < anner) {
            salaireCalc = this.salaire * (1.1);
        } else if (6 < anner) {
            salaireCalc = this.salaire * (1.07);
        } else if (3 < anner) {
            salaireCalc = this.salaire * (1.03);
        } else {
            salaireCalc=this.salaire;
        }
        return salaireCalc;
    }



}



