package com.thomas;

import java.util.Objects;

public class Horaire {
    private int heures;
    private int minutes;

    public Horaire(int heures, int minutes){
        this.heures = heures*60;
        this.minutes = minutes;
    }

    public int getHeures(){
        return this.heures;
    }

    public int getMinutes(){
        return this.minutes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Horaire horaire = (Horaire) o;
        return heures == horaire.heures &&
                minutes == horaire.minutes;
    }

}
