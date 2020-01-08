package com.thomas;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        GestionProgrammationSemaine g = new GestionProgrammationSemaine();


        String str = "";
        Scanner sc = new Scanner(System.in);

        int quiter=12;
        while  ( quiter != 9 ) {
            String menu =   "\n-----------MENU-----------"+
                            "\nrenitialiser ==> 0" +
                            "\najouter film ==> 1" +
                            "\najouter piece theatre ==> 2"+
                            "\najouter interprete ==> 3"+
                            "\nquiter ==> 9"+
                            "\n--------------------------";
            System.out.println(menu);
            if (sc.hasNextInt()) {
                int n = sc.nextInt();
                if (0<=n && n<=9) {
                    switch (n) {
                        case 0:
                            System.out.println("Choix 0");
                            break;
                        case 1:
                            System.out.println("-----------------------------------");
                            System.out.println("Ajouter Film :");

                            System.out.print("\nEntrer titre film :");
                            String titreF = sc.next();
                            System.out.print("\nEntrer le nom du realisateur du film :");
                            String nomRealisateur = sc.next();
                            System.out.print("\nEntrer la duree du film :");
                            int duree =sc.nextInt();

                            g.ajouterFilm(titreF, nomRealisateur, duree);
                            break;
                        case 2:
                            System.out.println("-----------------------------------");
                            System.out.println("Ajouter piece de theatre :");

                            System.out.print("\nEntrer titre piece de theatre :");
                            String titreP = sc.next();
                            System.out.print("\nEntrer le nom du realisateur du piece de theatre :");
                            String meteurSC = sc.next();
                            System.out.print("\nEntrer le nb d entract de la piece de theatre :");
                            int nbEntract =sc.nextInt();

                            g.ajouterPiece(titreP, meteurSC, nbEntract);
                            break;
                        case 3:
                            System.out.println("-----------------------------------");
                            System.out.println("Ajouter un nom d'interprète à un spectacle");

                            //System.out.println(g.afficherSpectacle());

                            System.out.print("\nEntrer le numero du spectacle :");
                            int numSpectacle = sc.nextInt();
                            System.out.print("\nEntrer le nom de l interprete :");
                            String interprete = sc.next();

                            g.ajouterInterprete(numSpectacle,interprete);
                            break;
                        case 9:
                            System.out.println("Fin");
                            quiter = 9;
                            break;
                    }
                }
                else {
                    System.out.println("Vous vous etes tromper, un nb entre 0 et 9  Recommencer !");
                }
            }
            else {
                System.out.println("Vous vous etes tromper, Recommencer !");
                str=sc.next();
            }
        }
    }
}
