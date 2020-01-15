package com.thomas;


import java.util.*;

public class Salle {
    private int num;
    private String nom;
    private int nbPlace;
    private int tarifPlace;

/** FAUX  */
    private SortedMap<Integer, Set<Creneau> > lesCreneauxOccupes;

    public static int compteur = 10;

    public Salle (String nom, int nbPlace, int tarifPlace) {
        this.nom=nom;
        this.nbPlace=nbPlace;
        this.tarifPlace=tarifPlace;
        this.num=compteur;
        compteur+=10;
        this.lesCreneauxOccupes=new TreeMap< Integer, Set<Creneau> >();
    }

/** FAUX
    public boolean estDisponible(Creneau c){
        int numJour = c.getNumJour();
        if (lesCreneauxOccupes.containsKey(numJour)){

            Iterator<Creneau> iterator = cr


            return false;
        }
        else {

        }
        return true;
    }

    /* if (lesCreneauxOccupes.containsKey(numJour)){
            return false;
        }
        else {
            int j = c.getNumJour();
            Horaire hD = c.getHoraireDebut() ;

            Set<Map.Entry<Integer, Set<Creneau> >> lesEntree = lesCreneauxOccupes.entrySet();
            Iterator<Map.Entry<Integer, Set<Creneau> >> it = lesEntree.iterator();


            while (it.hasNext()){
                Map.Entry<Integer, Set<Creneau> > uneEntree= it.next();
                Creneau creneau = (Creneau) uneEntree.getValue();


                // ils ont le meme jours
                if (creneau.equals(c) ){
                    Horaire hFCreneau = creneau.getHoraireFin() ;

                    // heure debut new creneau == heure fin creneau du meme jour
                    if (hD.equals(hFCreneau)){
                        return true;
                    }
                }
            }
        }
        return true; */









    @Override
    public String toString() {
        return "Salle{" +
                "num=" + num +
                ", nom='" + nom + '\'' +
                ", nbPlace=" + nbPlace +
                ", tarifPlace=" + tarifPlace +
                '}';
    }
}
