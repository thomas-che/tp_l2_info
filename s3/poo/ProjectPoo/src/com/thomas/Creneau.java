package com.thomas;


import java.util.Objects;

public class Creneau implements Comparable<Creneau> {
    private int numJour;
    private Horaire horaireDebut;
    private Horaire horaireFin;

    public Creneau (int numJour, Horaire horaireDebut, Horaire horaireFin){
        this.numJour=numJour;
        this.horaireDebut=horaireDebut;
        this.horaireFin=horaireFin;
    }


    public int getNumJour() {
        return numJour;
    }

    public Horaire getHoraireDebut() {
        return horaireDebut;
    }

    public Horaire getHoraireFin() {
        return horaireFin;
    }




    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Creneau creneau = (Creneau) o;
        return numJour == creneau.numJour &&
                Objects.equals(horaireDebut, creneau.horaireDebut) &&
                Objects.equals(horaireFin, creneau.horaireFin);
    }

    @Override
    public String toString() {
        return  " du " + numJour +
                " a " + horaireDebut.toString() +
                " jusqu a " + horaireFin.toString();
    }

    @Override
    public int compareTo(Creneau creneau) {
        if (this.equals(creneau)){
            return 0;
        }
        else if (this.getNumJour() < creneau.getNumJour()){ //this avant creneau
            return -1;
        }
        else {
            return this.getHoraireDebut().compareTo(creneau.getHoraireDebut());
        }
    }
}
