package com.thomas;

import java.util.List;

public class Film extends Spectacle {

    String nomRéalisateur ;
    int duree ; // minutes
    public static int compteur = 100;    // mon compteur à 100 pour incrémentation








    // Constructeur 1 : Basique

    public Film(int numero, String titre, String nomRéalisateur, int duree, int compteur) {
        super(numero, titre);
        this.nomRéalisateur = nomRéalisateur;
        this.duree = duree;
        this.compteur = compteur;
    }





    // Contructeur 2 :   Pour ajouter un film          // avec incrémentation

    public Film( String titre, String nomRéalisateur, int duree) {
        super(titre);
        this.nomRéalisateur = nomRéalisateur;
        this.duree = duree;


        this.numero=compteur;
        compteur+=10;
    }





    // Getters :

    public String getNomRéalisateur() {
        return nomRéalisateur;
    }

    public int getDuree() {
        return duree;
    }

    public static int getCompteur() {
        return compteur;
    }








//Methode to String :

    @Override
    public String toString() {
        return "Film{" +
                "nomRéalisateur='" + nomRéalisateur + '\'' +
                ", duree=" + duree + ", numero=" + numero +
                ", titre='" + super.toString() + '\'' +
                '}';
    }








}

