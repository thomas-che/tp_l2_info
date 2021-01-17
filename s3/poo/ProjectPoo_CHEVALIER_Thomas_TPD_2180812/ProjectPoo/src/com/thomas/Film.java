package com.thomas;

import javax.swing.*;
import java.util.Set;

public class Film extends Spectacle {
    private String nomRealisateur;
    private int duree;

    public static int compteur = 100;

    public Film (String titre, String nomRealisateur, int duree){
        super(titre);
        this.numero=compteur++;
        this.nomRealisateur=nomRealisateur;
        this.duree=duree;
    }

    public boolean ajouterSeanceFilm (SeanceFilm s){
        if (lesSeances.contains(s)){
            return false;
        }
        Salle salle = s.getSalleStandard();
        Creneau creneau = s.getCreneau();
        if (salle.estDisponible(creneau) ){
            lesSeances.add(s);
            salle.ajouterCreneau(creneau); // return boolean
            return true;
        }
        else {
            return false;
        }

    }


    // ----------------------------------------------
    // GETTER
    // ----------------------------------------------

    public String getNomRealisateur() {
        return nomRealisateur;
    }

    public int getDuree() {
        return duree;
    }


    // ----------------------------------------------
    // METHODE REDEFINIT
    // ----------------------------------------------
    @Override
    public String toString() {
        return super.toString()+
                "\nNom du realisateur: '" + nomRealisateur + '\'' +
                "\nDuree du film: " + duree + "min"+
                "\n";
    }
}
