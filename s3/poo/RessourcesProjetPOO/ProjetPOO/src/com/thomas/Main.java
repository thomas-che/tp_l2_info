package com.thomas;

public class Main {

    public static void main(String[] args) {

        Salle s1 = new Salle("salle 1",32,5);
        System.out.println(s1);
        Salle s2 = new Salle("salle 2",32,5);
        System.out.println(s2);

        Film f1 = new Film("f1","r1",120);
        System.out.println(f1);
        Film f2 = new Film("f1","r1",120);
        System.out.println(f2);

        GestionProgrammationSemaine g = new GestionProgrammationSemaine();

        g.ajouterFilm();

    }
}
