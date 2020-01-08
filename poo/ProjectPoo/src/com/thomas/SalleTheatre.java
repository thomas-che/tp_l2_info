package com.thomas;

public class SalleTheatre extends Salle {
    private int nbFauteuil;
    private double tarifFauteuil;

    public SalleTheatre (String nom, int nbPlace, double tarifPlace, int nbFauteuil, double tarifFauteuil) {
        super(nom,nbPlace,tarifPlace);
        this.nbFauteuil=nbFauteuil;
        this.tarifFauteuil=tarifFauteuil;
    }

    @Override
    public String affichierSalle() {
        return super.affichierSalle()+", nb fauteuil="+nbFauteuil+", tarif fauteuil="+tarifFauteuil;
    }

// ----------------------------------------------
    // GETTER
    // ----------------------------------------------

    public int getNbFauteil() {
        return nbFauteuil;
    }

    public double getTarifFauteuil() {
        return tarifFauteuil;
    }
}
