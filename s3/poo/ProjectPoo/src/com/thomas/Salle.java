package com.thomas;

import java.util.*;

public class Salle {
    private int num;
    private String nom;
    private int nbPlace;
    private double tarifPlace;

    private double tarifPlaceVendu;


    private SortedMap<Integer, Set<Creneau> > lesCreneauxOccupes;

    public static int compteur = 10;

    public Salle (String nom, int nbPlace, double tarifPlace) {
        this.nom=nom;
        this.nbPlace=nbPlace;
        this.tarifPlace=tarifPlace;
        this.num=compteur;
        compteur+=10;
        this.lesCreneauxOccupes=new TreeMap< Integer, Set<Creneau>>();

        this.tarifPlaceVendu=tarifPlace;
    }

    public boolean estDisponible (Creneau c){
        if (lesCreneauxOccupes.containsKey(c.getNumJour())) {
            Horaire cHeureDeb = c.getHoraireDebut();
            Horaire cHeureFin = c.getHoraireFin();

     /** ajout de <Creneau> devant set */
            /*Set<Creneau> setCreneau = lesCreneauxOccupes.get(c.getNumJour());
            Iterator<Creneau> it = setCreneau.iterator();

            Horaire heureFinAncienCreneau = new Horaire(0, 0); // instancie & heure de la journer 00:00
            boolean estDisponible = false;

            while (it.hasNext()) {
                Creneau unCreneau = it.next();
                Horaire heureDebUnCreneau = unCreneau.getHoraireDebut();

                if (cHeureFin.compareTo(heureDebUnCreneau) <= 0) { //creneau demander est avant un autre ou //creneau demander termine a la meme heure que un autre
                    if (heureFinAncienCreneau.compareTo(cHeureDeb) <= 0) { //heure ancien creneau < creneau demande
                        estDisponible = true;
                        //return estDisponible;
                    }
                }

                // met a jour l heure de fin du creneau
                Horaire heureFinUnCreneau = unCreneau.getHoraireFin();

                // rapelle de l heure de l ancien creneau
                heureFinAncienCreneau = heureFinUnCreneau;
            }*/
            Set<Creneau> lesCreneau = lesCreneauxOccupes.get(c.getNumJour());

            Horaire heureFinAncienCreneau = new Horaire(0, 0); // instancie & heure de la journer 00:00
            boolean estDisponible = false;

            for (Creneau unCreneau: lesCreneau){
                Horaire heureDebUnCreneau = unCreneau.getHoraireDebut();

                if (cHeureFin.compareTo(heureDebUnCreneau) <= 0) { //creneau demander est avant un autre ou //creneau demander termine a la meme heure que un autre
                    if (heureFinAncienCreneau.compareTo(cHeureDeb) <= 0) { //heure ancien creneau < creneau demande
                        estDisponible = true;
                        //return estDisponible;
                    }
                }

                // met a jour l heure de fin du creneau
                Horaire heureFinUnCreneau = unCreneau.getHoraireFin();

                // rapelle de l heure de l ancien creneau
                heureFinAncienCreneau = heureFinUnCreneau;
            }
            if (!estDisponible){

                Horaire derniereHoraire = new Horaire(23,59);
                if (cHeureFin.compareTo(derniereHoraire) <= 0) { //creneau demander est avant un autre ou //creneau demander termine a la meme heure que un autre
                    if (heureFinAncienCreneau.compareTo(cHeureDeb) <= 0) { //heure ancien creneau < creneau demande
                        estDisponible = true;
                        //return estDisponible;
                    }
                }
            }
            return estDisponible; // false
        }
        else {
            return true;
        }
    }

    public boolean ajouterCreneau (Creneau c){
        if (lesCreneauxOccupes.containsKey(c.getNumJour())) {
            if ( estDisponible(c)){ //test si la ssalle est dispo
                Set ensembleCreneau = lesCreneauxOccupes.get(c.getNumJour());
                Set ancienEnsembleCreneau=ensembleCreneau;
                ensembleCreneau.add(c);
                return lesCreneauxOccupes.replace(c.getNumJour(),ancienEnsembleCreneau,ensembleCreneau);
            }
            else {
                return false;
            }
        }
        else { // aucun creneau a ce jour
            Set<Creneau> newEnsembleCreneau = new TreeSet<>() ;
            newEnsembleCreneau.add(c);
            lesCreneauxOccupes.put(c.getNumJour(),newEnsembleCreneau);
            return true;
        }

    }

    public boolean pasDeCreneauCeJour(int jour){
        if (lesCreneauxOccupes.containsKey(jour)){
            return false;
        }
        else return true;
    }

    public void reductionPlaceStandard (){
        this.tarifPlaceVendu=tarifPlace*0.6;
    }

    public String affichierSalle(){
        return "\nSalle num="+num+", nb place="+nbPlace+", tarif place normal="+tarifPlace;
    }

    public void viderCreneauOcuper(){
        lesCreneauxOccupes.clear();
    }

    // ----------------------------------------------
    // GETTER
    // ----------------------------------------------

    public int getNum() {
        return num;
    }

    public int getNbPlace() {
        return nbPlace;
    }

    public double getTarifPlace() {
        return tarifPlace;
    }

    // ----------------------------------------------
    // METHODE REDEFINIT
    // ----------------------------------------------

    @Override
    public String toString() {
        return "\nEn salle numéro: "+num;
    }
}
