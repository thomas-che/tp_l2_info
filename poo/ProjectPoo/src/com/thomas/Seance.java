package com.thomas;


import java.util.Objects;

public class Seance implements Comparable<Seance> {
    private Creneau creneau;
    protected int nbPlaceNormalVendu;

    public Seance (Creneau creneau, int nbPlaceNormalVendu){
        this.creneau=creneau;
        this.nbPlaceNormalVendu=nbPlaceNormalVendu;
    }

    public Seance(Creneau creneau){
        this.creneau=creneau;
        this.nbPlaceNormalVendu=0;
    }

    public void vendrePlacesTN(int nbre){
        nbPlaceNormalVendu+=nbre;
    }



    // ----------------------------------------------
    // GETTER
    // ----------------------------------------------

    public Creneau getCreneau() {
        return creneau;
    }

    public int getNbPlaceNormalVendu() {
        return nbPlaceNormalVendu;
    }

// ----------------------------------------------
    // METHODE REDEFINIT
    // ----------------------------------------------

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Seance seance = (Seance) o;
        return Objects.equals(creneau, seance.creneau);
    }

    @Override
    public int compareTo(Seance seance) {
        return this.getCreneau().compareTo(seance.getCreneau());
    }

    @Override
    public String toString() {
        return "Seance " + creneau.toString() +
                "\nNombre de places vendues: " + nbPlaceNormalVendu;
    }
}
