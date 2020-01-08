package com.thomas;

import javax.swing.*;

public class Film extends Spectacle {
    private String nomRealisateur;
    private int duree;

    public static int compteur = 100;

    public Film (String titre, String nomRealisateur, int duree){
        super(titre);
        this.numero=compteur;
        compteur+=10;
        this.nomRealisateur=nomRealisateur;
        this.duree=duree;
    }


    public String getNomRealisateur() {
        return nomRealisateur;
    }

    @Override
    public String toString() {
        return super.toString()+"Film{" +
                "numero="+numero+
                ", nomRealisateur='" + nomRealisateur + '\'' +
                ", duree=" + duree +
                ", numero=" + numero +
                '}';
    }
}
