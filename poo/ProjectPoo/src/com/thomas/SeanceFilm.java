package com.thomas;

public class SeanceFilm extends Seance {
    private Salle salleStandard ;
    private int nbPlaceVenduTarifReduit;

    public SeanceFilm (Creneau creneau, int nbPlaceNormalVendu, Salle salleStandard, int nbPlaceVenduTarifReduit){
        super(creneau, nbPlaceNormalVendu);
        this.salleStandard=salleStandard;
        this.nbPlaceVenduTarifReduit=nbPlaceVenduTarifReduit;
    }

    // place vendu initiliser a 0
    public SeanceFilm(Creneau creneau, Salle salleStandard){
        super(creneau);
        this.salleStandard=salleStandard;
        nbPlaceVenduTarifReduit=0;
    }

    public int nbPlaceStandardDisponible(){
        return salleStandard.getNbPlace()-(nbPlaceNormalVendu+nbPlaceVenduTarifReduit);
    }

    public double tauxRemplisage(){
        return ( (nbPlaceNormalVendu+nbPlaceVenduTarifReduit+0.0)/salleStandard.getNbPlace() )*100;
    }


    public void vendrePlacesTR(int nbre){
        nbPlaceVenduTarifReduit+=nbre;
    }

    // ----------------------------------------------
    // GETTER
    // ----------------------------------------------

    public Salle getSalleStandard() {
        return salleStandard;
    }

    public int getNbPlaceVenduTarifReduit() {
        return nbPlaceVenduTarifReduit;
    }
// ----------------------------------------------
    // METHODE REDEFINIT
    // ----------------------------------------------

    @Override
    public String toString() {
        return super.toString() +
                "\nNombre de places vendues au tarif réduit: " + nbPlaceVenduTarifReduit +
                salleStandard.toString() +
                "\n";
    }
}
