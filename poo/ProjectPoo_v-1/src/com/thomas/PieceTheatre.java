package com.thomas;

public class PieceTheatre extends Spectacle {
    private String nomMeteurSC;
    private int nbEntract;

    public static int compteur = 1000;

    public PieceTheatre (String titre, String nomMeteurSC, int nbEntract){
        super(titre);
        this.numero=compteur++;
        this.nomMeteurSC=nomMeteurSC;
        this.nbEntract=nbEntract;
    }

    public String getNomMeteurSC() {
        return nomMeteurSC;
    }

    @Override
    public String toString() {
        return super.toString()+"PieceTheatre{" +
                "numero="+numero+
                ", nomMeteurSC='" + nomMeteurSC + '\'' +
                ", nbEntract=" + nbEntract +
                ", numero=" + numero +
                '}';
    }
}
