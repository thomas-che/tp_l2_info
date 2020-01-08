package com.thomas;

public class SeanceTheatre extends Seance {
    private SalleTheatre salleTheatre;
    private int nbFauteilVendu;

    // place vendu initiliser a 0
    public SeanceTheatre(Creneau creneau, SalleTheatre salleTheatre){
        super(creneau);
        this.salleTheatre=salleTheatre;
        this.nbFauteilVendu=0;
    }


    public int nbPlaceStandardDisponible(){
        return salleTheatre.getNbPlace()-(nbPlaceNormalVendu+nbFauteilVendu);
    }

    public int nbPlaceFauteuilDisponible(){
        return salleTheatre.getNbFauteil()-nbFauteilVendu;
    }


    public double tauxRemplisage(){
        return ((nbPlaceNormalVendu+nbFauteilVendu+0.0)/salleTheatre.getNbPlace() )*100;
    }

    public void vendrePlacesFauteuil(int nbre) {
        nbFauteilVendu+=nbre;
    }

// ----------------------------------------------
    // GETTER
    // ----------------------------------------------

    public SalleTheatre getSalleTheatre() {
        return salleTheatre;
    }

    public int getNbFauteilVendu() {
        return nbFauteilVendu;
    }
// ----------------------------------------------
    // METHODE REDEFINIT
    // ----------------------------------------------


    @Override
    public String toString() {
        return super.toString() +
                "\nNombre de places vendues au tarif fauteuil: " + nbFauteilVendu +
                salleTheatre.toString()+
                "\n";
    }
}
