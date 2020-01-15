package exo2;

public class Main {
    public static void main(String[] args) {

        Temps monTemps = new Temps(37000);
        monTemps.setMinute(12);
        System.out.println(monTemps.getHeure()+monTemps.getMinute()+monTemps.getSeconde());



    }
}
