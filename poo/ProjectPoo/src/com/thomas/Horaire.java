package com.thomas;

public class Horaire implements Comparable<Horaire>{
    private int heures;
    private int minutes;

    public Horaire(int heures, int minutes){
        this.heures = heures; // modif heure*60
        this.minutes = minutes;
    }

    public Horaire calcHorairePlusDuree(Horaire h, int duree){
        int horaireInMinute= h.getHeures()*60+h.getMinutes();
        int temps= duree+horaireInMinute;

        int heure = temps/60;
        int minute = temps-heure*60;

        Horaire horaireCalc = new Horaire(heure,minute);
        return horaireCalc;
    }

    // ----------------------------------------------
    // GETTER
    // ----------------------------------------------

    public int getHeures(){
        return this.heures;
    }

    public int getMinutes(){
        return this.minutes;
    }

    // ----------------------------------------------
    // METHODE REDEFINIT
    // ----------------------------------------------

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Horaire horaire = (Horaire) o;
        return heures == horaire.heures &&
                minutes == horaire.minutes;
    }

    @Override
    public int compareTo(Horaire horaire) {
        int h = horaire.getHeures();
        int m = horaire.getMinutes();
        if (this.equals(horaire)){
            return 0;
        }
        else {
            if (this.heures == h){
                if (this.minutes < m){
                    return -1; //this plus petit que horaire
                }
                else return 1;
            }
            if (this.heures < h){
                return -1; //this plus petit que horaire
            }
            else {
                return 1; // this plus grand que horaire
            }
        }
    }

    @Override
    public String toString() {
        return  heures + "h" + minutes ;
    }
}
