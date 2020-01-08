package com.thomas;

import java.util.*;

public class Spectacle {
    protected int numero;
    protected String titre;


    private Set<String> interprete;
    protected Set<Seance> lesSeances;


    public Spectacle (String titre){
        this.titre=titre;
        interprete = new TreeSet<>();
        lesSeances = new TreeSet<Seance>(new Comparator<Seance>() {
            @Override
            public int compare(Seance s1, Seance s2) {
                Creneau s1Creneau = s1.getCreneau();
                Creneau s2Creneau = s2.getCreneau();
                return s1Creneau.compareTo(s2Creneau);
            }
        });
    }


    public void ajouterInterprete (String nomInterprete){
        interprete.add(nomInterprete);
    }

    public Seance rechercheSeanceJourHoraireDebut(int numJour, Horaire horaireDebut){
        Iterator<Seance> it = lesSeances.iterator();
        while (it.hasNext()){
            Seance seance = it.next();
            int seanceNumJour = seance.getCreneau().getNumJour();
            Horaire seanceHoraireDebut= seance.getCreneau().getHoraireDebut();
            if (seanceNumJour == numJour && seanceHoraireDebut.equals(horaireDebut) ){
                return seance;
            }
        }
        return null;
    }

    public Set<Seance> rechercheSeance(int numJour){
        Set<Seance> ensembleSeance = new TreeSet<Seance>();
        Iterator<Seance> it = lesSeances.iterator();
        while (it.hasNext()){
            Seance seance = it.next();
            int seanceNumJour = seance.getCreneau().getNumJour();
            if (seanceNumJour == numJour ){
                ensembleSeance.add(seance);
            }
        }
        return ensembleSeance;
    }


    /** todo: cree methodes
    //public double tauxRemplisageSpectacle()
    //public double chifreAffaireSpectacle() */


    // ----------------------------------------------
    // GETTER
    // ----------------------------------------------

    public String getTitre() {
        return titre;
    }
    public int getNumero() {
        return numero;
    }

    public Set<Seance> getLesSeances() {
        return lesSeances;
    }


// ----------------------------------------------
    // METHODE REDEFINIT
    // ----------------------------------------------

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Spectacle spectacle = (Spectacle) o;
        return numero == spectacle.numero &&
                Objects.equals(titre, spectacle.titre) &&
                Objects.equals(interprete, spectacle.interprete);
    }

    @Override
    public String toString() {
        return  "\nNumero spectacle: " + numero +
                "\nTitre: '" + titre + '\'' +
                "\nLes interpretes: " + interprete ;
    }

}
