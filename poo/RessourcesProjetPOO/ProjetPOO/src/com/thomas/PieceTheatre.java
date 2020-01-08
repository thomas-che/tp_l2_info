package com.thomas;

public class PieceTheatre extends Spectacle {

    String nomMES ;
    int nbEntractes ;
    public static int compteur = 1000 ;               // static: veut dire qu'il "s'utilise" partout, toute les classes



    public PieceTheatre(int numero, String titre, String nomInterprete, String nomMES, int nbEntractes) {
        super(numero, titre);
        this.nomMES = nomMES;
        this.nbEntractes = nbEntractes;
    }   // Constructeur basique


    public PieceTheatre(String titre, String nomMES, int nbEntractes) {
        super(titre);
        this.nomMES = nomMES;
        this.nbEntractes = nbEntractes;

        this.numero = compteur ;
        compteur++ ;
    }      // ajouter pieceTheatre   // et incrémentation








    // Methode toString :

    @Override
    public String toString() {
        return "PieceTheatre{" +
                "nomMES='" + nomMES + '\'' +
                ", nbEntractes=" + nbEntractes +
                ", titre='" + titre + '\'' +
                '}';
    }
}
