package com.thomas;

import javax.swing.text.StyledEditorKit;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

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

    public boolean existeSeanceCeJour(int numJour){
        Iterator<Seance> it = lesSeances.iterator();
        while (it.hasNext()){
            Seance seance = it.next();
            int seanceNumJour = seance.getCreneau().getNumJour();
            if (seanceNumJour == numJour ){
                return true;
            }
        }
        return false;
    }

    public boolean ajouterSeanceTheatre (SeanceTheatre s){
        /*Iterator<Seance> it = lesSeances.iterator();
        while (it.hasNext()){
            Seance seance = it.next();
            int seanceNumJour = seance.getCreneau().getNumJour();
            if (seanceNumJour == s.getCreneau().getNumJour() ){
                return false;
            }
        }
        return lesSeances.add(s);*/

        if (lesSeances.contains(s)){
            return false;
        }
        SalleTheatre salleT = s.getSalleTheatre();
        Creneau creneau = s.getCreneau();
        if (salleT.estDisponible(creneau) ){
            lesSeances.add(s);
            salleT.ajouterCreneau(creneau); // return boolean
            return true;
        }
        else {
            return false;
        }
    }

    // ----------------------------------------------
    // METHODE REDEFINIT
    // ----------------------------------------------

    @Override
    public String toString() {
        return super.toString() +
                "\nNom du meteur en scene: '" + nomMeteurSC + '\'' +
                "\nNb entract: " +nbEntract +
                "\n";
    }
}
