package exo2;

public class Temps {
    private int heure;
    private int minute;
    private int seconde;
    private int jour;
    static int conteurSeconde =0;

    public Temps () {
        this.heure=heure;
        this.minute=minute;
        this.seconde=seconde;
    }


    public Temps (int heure,int minute,int seconde) {
        this.heure=heure;
        this.minute=minute;
        this.seconde=seconde;

        convertInTime();
    }

    public Temps (long t){
        seconde=(int) (t);
        convertInTime();
    }




    private void convertInTime () {
        this.seconde+=seconde;
        this.minute+=seconde/60;
        seconde=seconde-minute*60;
        this.heure+=minute/60;
        minute=minute-heure*60;
        if (24<=heure) {
            jour=heure/24;
            heure=heure-(jour*24);
        }
    }

    public long convertInSec (){
        long tempSec=0;
        tempSec = (heure*3600)+(minute*60)+(seconde*60);
        return tempSec;
    }


    public void convertInvers (long t) {
        this.seconde= (int) t%60;
        t=t/60;
        this.minute= (int) t%60;
        this.heure= (int) t/60;
    }

    //corret prof pâs fini
    private void nromaliser (){

        minute=minute+seconde%60;
        heure=heure+minute%60;
    }



    public int getHeure() {
        return heure;
    }

    public void setHeure(int heure) {
        this.heure = heure;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
        convertInTime();
    }

    public int getSeconde() {
        return seconde;
    }

    public void setSeconde(int seconde) {
        this.seconde = seconde;
        nromaliser();
    }


}
