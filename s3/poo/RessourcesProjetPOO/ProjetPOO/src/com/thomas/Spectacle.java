package com.thomas;

import java.util.LinkedList;
import java.util.List;

public class Spectacle {
    private int numero ;
    private String titre ;


    List <String> nomInterprètes ;
    //List<SeanceFilm> seancesFilm ;
    List <Film

    // Constructeur :

    public Spectacle(int numero, String titre) {
        this.numero = numero;
        this.titre = titre;


        this.nomInterprètes = new LinkedList<String >() ;
        this.seancesFilm = new LinkedList<SeanceFilm>() ;
    }                                                            // Probleme : comment ajouter plusieurs interprete dans la collection ?




    // Contructeur 2 :                            // Pour l'héritage

    public Spectacle(String titre) {
        this.titre = titre;
    }


    // Getters :

    public int getNumero() {
        return numero;
    }

    public String getTitre() {
        return titre;
    }

    public List<String> getNomInterprètes() {
        return nomInterprètes;
    }


    // Methode toString

    @Override
    public String toString() {
        return titre ;
    }
}
