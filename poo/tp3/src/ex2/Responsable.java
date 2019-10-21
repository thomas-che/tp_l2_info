package ex2;

import java.time.LocalDate;
import java.util.Arrays;

public class Responsable extends Employe {
    private String titre;
    private int pourcentagePrime;
    private Employe[] lesSubordonnes;

// Employe... lesSubordonnes est gerer comme un tableau

    public Responsable (String nom, double salaire, LocalDate dateEmbauche, String titre, int pourcentagePrime, Employe... lesSubordonnes) {
        super( nom, salaire, dateEmbauche);
        this.titre=titre;
        this.pourcentagePrime=pourcentagePrime;
        this.lesSubordonnes=lesSubordonnes;
    }

    @Override
    public double calculerSalaireBrutMensuel() {
        return super.calculerSalaireBrutMensuel() * (1+(pourcentagePrime/100.0));
    }

    @Override
    public String toString() {
        return super.toString()+
                "Responsable{" +
                "titre='" + titre +
                ", pourcentagePrime=" + pourcentagePrime +
                ", lesSubordonnes=" + Arrays.toString(lesSubordonnes) +
                '}';
    }
}
