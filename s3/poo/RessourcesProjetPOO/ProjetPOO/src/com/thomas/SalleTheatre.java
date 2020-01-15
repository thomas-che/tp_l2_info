package com.thomas;

public class SalleTheatre extends Salle {

    private int nbFauteuil;
    private int tarifFauteuil;

    public SalleTheatre (String nom, int nbPlace, int tarifPlace, int nbFauteuil, int tarifFauteuil) {
        super(nom,nbPlace,tarifPlace);
        this.nbFauteuil=nbFauteuil;
        this.tarifFauteuil=tarifFauteuil;
    }
}
