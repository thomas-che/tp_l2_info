package ex2;

import java.time.LocalDate;

public class Commerciaux extends Employe {
    private double ventesDernierMois;

    public Commerciaux (String nom, double salaire , LocalDate dateEmbauche){
        super( nom, salaire, dateEmbauche);
    }

    public void setVentesDernierMois (double ventes) {
        this.ventesDernierMois=ventes;
    }

    @Override
    public double calculerSalaireBrutMensuel()  {
        return super.calculerSalaireBrutMensuel() * (0.05*ventesDernierMois);
    }

    @Override
    public String toString () {
        return super.toString() + "Commerciaux {" +
                                 " venteDernierMois= " + ventesDernierMois +
                                 " }";
    }
}
