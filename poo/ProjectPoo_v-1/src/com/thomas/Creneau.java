package com.thomas;

import java.util.Objects;

public class Creneau {
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
        return "Creneau{" +
                "numJour=" + numJour +
                ", horaireDebut=" + horaireDebut +
                ", horaireFin=" + horaireFin +
                '}';
    }
}
