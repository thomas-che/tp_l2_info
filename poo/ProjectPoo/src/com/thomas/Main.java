package com.thomas;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        /** todo: test si idFilm/idPieceTheatre existe avant de passer a la saisie des var */

        GestionProgrammationSemaine g = new GestionProgrammationSemaine();




        String str = "";
        Scanner sc = new Scanner(System.in);

        int quiter=12;
        while  ( quiter != 9 ) {
            String menu =   "\n-----------MENU-----------"+
                            "\n 0 ==> renitialiser" +
                            "\n 1 ==> ajouter film" +
                            "\n 2 ==> ajouter piece theatre"+
                            "\n 3 ==> ajouter interprete"+
                            "\n 4 ==> ajouter sceance film"+
                            "\n 5 ==> ajouter sceance piece theatre"+
                            "\n 6 ==> vendre place film"+
                            "\n 7 ==> vendre place piece theatre"+
                            "\n 8 ==> chiffre affaire + taux remplisage"+
                            "\n 9 ==> quitter"+
                            "\n--------------------------";
            System.out.println(menu);
            if (sc.hasNextInt()) {
                int n = sc.nextInt();
                if (0<=n && n<=9) {
                    switch (n) {
                        case 0:
                            System.out.println("-----------------------------------");
                            System.out.println("Renitialiser :");
                            g.reinitialiserProgrammation();
                            System.out.println("Renitialiser fini");
                            break;
                        case 1:
                            System.out.println("-----------------------------------");
                            System.out.println("Ajouter Film :");

                            System.out.println("Entrer titre film :");
                            String titreF = sc.next();
                            System.out.println("Entrer le nom du realisateur du film :");
                            String nomRealisateur = sc.next();
                            System.out.println("Entrer la duree du film :");
                            //int duree = g.checkInt(sc);
                            int duree =-1;
                            try {
                                duree = g.checkInt(sc);
                            } catch (ZeroToBreakSwithException e){
                                System.out.println(e.getMessage());
                                break;
                            }


                            try {
                                g.ajouterFilm(titreF, nomRealisateur, duree);
                            } catch (Exception e){
                                System.out.println("\n#ERROR#\n\t"+e.getMessage()+"\n#ERROR#");
                            }
                            break;
                        case 2:
                            System.out.println("-----------------------------------");
                            System.out.println("Ajouter piece de theatre :");

                            System.out.println("Entrer titre piece de theatre :");
                            String titreP = sc.next();
                            System.out.println("Entrer le nom du realisateur du piece de theatre :");
                            String meteurSC = sc.next();
                            System.out.println("Entrer le nb d entract de la piece de theatre :");
                            //int nbEntract = g.checkInt(sc);
                            int nbEntract =-1;
                            try {
                                nbEntract = g.checkInt(sc);
                            } catch (ZeroToBreakSwithException e){
                                System.out.println(e.getMessage());
                                break;
                            }

                            try {
                                g.ajouterPiece(titreP, meteurSC, nbEntract);
                            } catch (Exception e){
                                System.out.println("\n#ERROR#\n\t"+e.getMessage()+"\n#ERROR#");
                            }
                            break;
                        case 3:
                            System.out.println("-----------------------------------");
                            System.out.println("Ajouter un nom d'interprète à un spectacle");

                            //System.out.println(g.lesFilms());
                            //g.afficherListFilm(g);  // ne permet pas de s arreter si pas de film
                            if (g.lesFilms() != null ){
                                System.out.println(g.lesFilms());
                            }
                            else {
                                System.out.println("===> Aucun Film");
                            }
                            //System.out.println(g.lesPieces());
                            //g.afficheListPieceTheatre(g);
                            if (g.lesPieces() != null ){
                                System.out.println(g.lesPieces());
                            }
                            else {
                                System.out.println("===> Aucune Piece de theatre");
                            }
                            if (g.lesFilms() == null && g.lesPieces() == null ){
                                break;
                            }

                            /** todo: check id spectacle existe : fait*/
                            System.out.println("Entrer le numero du spectacle :");

                            //int numSpectacle = g.checkInt(sc);

                            //------------------------------
                            // amelioration : peux pas entrer un spectacle qui n existe pas
                            //------------------------------
                            int numSpectacle =-1;
                            try {
                                numSpectacle = g.checkInt(sc);
                            } catch (ZeroToBreakSwithException e){
                                System.out.println(e.getMessage());
                                break;
                            }

                            // amelioration demande en boucle jusqu a se que l on entre un num spectacle correct
                            /*while (g.getSpectacle(numSpectacle) == null){
                                System.out.println("Entrer le numero du spectacle VALIDE:");
                                //numSpectacle = g.checkInt(sc);
                                numSpectacle =-1;
                                try {
                                    numSpectacle = g.checkInt(sc);
                                } catch (ZeroToBreakSwithException e){
                                    System.out.println(e.getMessage());
                                    break;
                                }
                            }*/
                            if(g.getSpectacle(numSpectacle) == null){ // ne leve pas d exception donc doit faire un test ==null
                                System.out.println("\n#ERROR#\n\t"+"===> num Spectacle inconu"+"\n#ERROR#");
                                break;
                            }

                            System.out.println("Entrer le nom de l interprete :");
                            String interprete = sc.next();

                            try {
                                g.ajouterInterprete(numSpectacle,interprete);
                            } catch (Exception e){
                                System.out.println("\n#ERROR#\n\t"+e.getMessage()+"\n#ERROR#");
                            }

                            break;
                        case 4:
                            System.out.println("-----------------------------------");
                            System.out.println("Ajouter une séance pour un film");
                            //g.afficherListFilm(g); // ne permet pas de s arreter si pas de film
                            if (g.lesFilms() != null ){
                                System.out.println(g.lesFilms());
                            }
                            else {
                                System.out.println("===> Aucun Film");
                                break;
                            }

                            System.out.println("Entrer id du film :");
                            //int idFilm = g.checkInt(sc);
                            int idFilm =-1;
                            try {
                                idFilm = g.checkInt(sc);
                            } catch (ZeroToBreakSwithException e){
                                System.out.println(e.getMessage());
                                break;
                            }

                            System.out.println("Entrer num du de la semaine(lundi=1, mardi=2, ...) :");
                            //int idjourF = g.checkIntJour(sc);
                            int idjourF =-1;
                            try {
                                idjourF = g.checkIntJour(sc);
                            } catch (ZeroToBreakSwithException e){
                                System.out.println(e.getMessage());
                                break;
                            }

                            System.out.println("Entrer heure debut du film :");
                            int heureDebutF = g.checkIntHeure(sc);

                            System.out.println("Entrer minute debut du film :");
                            int minuteDebutF = g.checkIntMinute(sc);

                            System.out.println(g.lesSallesFilm());
                            System.out.println("Entrer id salle du film :");
                            //int idSalleF = g.checkInt(sc);

                            int idSalleF =-1;
                            //int idSalleFTMP = g.checkInt(sc);
                            int idSalleFTMP =-1;
                            try {
                                idSalleFTMP = g.checkInt(sc);
                            } catch (ZeroToBreakSwithException e){
                                System.out.println(e.getMessage());
                                break;
                            }

                            // amelioration: demande en boucle jusqu a temps que l on rentre un bon id de salle
                            /*while (!g.existeSalleFilm(idSalleFTMP)){
                                System.out.println("===> Salle inexistante");
                                System.out.println("Entrer id salle du film :");
                                System.out.println(g.lesSallesFilm());
                                //idSalleFTMP=g.checkInt(sc);
                                idSalleFTMP =-1;
                                try {
                                    idSalleFTMP = g.checkInt(sc);
                                } catch (ZeroToBreakSwithException e){
                                    System.out.println(e.getMessage());
                                    break;
                                }
                            }*/
                            idSalleF = idSalleFTMP;

                            Horaire horaireDebutF = new Horaire(heureDebutF,minuteDebutF);

                            try {
                                g.ajouterSeanceFilm(idFilm,idjourF,horaireDebutF,idSalleF);
                            } catch (Exception e){
                                System.out.println("\n#ERROR#\n\t"+e.getMessage()+"\n#ERROR#");
                            }
                            break;
                        case 5:
                            System.out.println("-----------------------------------");
                            System.out.println("Ajouter une séance pour une pièce de théâtre");
                            //g.afficheListPieceTheatre(g);
                            if (g.lesPieces() != null ){
                                System.out.println(g.lesPieces());
                            }
                            else {
                                System.out.println("===> Aucune Piece de theatre");
                                break;
                            }

                            System.out.println("Entrer id de la piece de theatre :");
                            //int idPieceT = g.checkInt(sc);
                            int idPieceT =-1;
                            try {
                                idPieceT = g.checkInt(sc);
                            } catch (ZeroToBreakSwithException e){
                                System.out.println(e.getMessage());
                                break;
                            }

                            System.out.println("Entrer num du de la semaine(lundi=1, mardi=2, ...) :");
                            //int idjourPieceT = g.checkIntJour(sc);
                            int idjourPieceT =-1;
                            try {
                                idjourPieceT = g.checkIntJour(sc);
                            } catch (ZeroToBreakSwithException e){
                                System.out.println(e.getMessage());
                                break;
                            }

                            boolean seanceCeJour = false;
                            try {
                                seanceCeJour = g.existeSeanceCeJour(idPieceT,idjourPieceT);
                            } catch (Exception e){
                                System.out.println("\n#ERROR#\n\t"+e.getMessage()+"\n#ERROR#");
                                break;
                            }

                            if (seanceCeJour){ // ne leve pas d exception donc doit faire un test
                                //System.out.println("\n ===> Il existe déjà une séance programmée ce jour");
                                System.out.println("\n#ERROR#\n\t"+"===> Il existe déjà une séance programmée ce jour"+"\n#ERROR#");
                            }
                            else {
                                System.out.println("Entrer heure debut de la piece de theatre :");
                                int heureDebutP = g.checkIntHeure(sc);

                                System.out.println("Entrer minute debut  de la piece de theatre :");
                                //int minuteDebutP = sc.nextInt();
                                int minuteDebutP = g.checkIntMinute(sc);

                                System.out.println(g.lesSallesTheatre());
                                System.out.println("Entrer id salle  de la piece de theatre :");

                                int idSalleP = -1;
                                //int idSallePTMP=g.checkInt(sc);
                                int idSallePTMP =-1;
                                try {
                                    idSallePTMP = g.checkInt(sc);
                                } catch (ZeroToBreakSwithException e){
                                    System.out.println(e.getMessage());
                                    break;
                                }
                                // amelioration: demande en boucle jusqu a temps que l on rentre un bon id de salle
                                /*while (!g.existeSalleTheatre(idSallePTMP)){
                                    System.out.println("===> Salle inexistante");
                                    System.out.println("Entrer id salle  de la piece de theatre :");
                                    System.out.println(g.lesSallesTheatre());
                                    //idSallePTMP=g.checkInt(sc);
                                    idSallePTMP =-1;
                                    try {
                                        idSallePTMP = g.checkInt(sc);
                                    } catch (ZeroToBreakSwithException e){
                                        System.out.println(e.getMessage());
                                        break;
                                    }
                                }*/
                                idSalleP = idSallePTMP;


                                Horaire horaireDebutP = new Horaire(heureDebutP,minuteDebutP);
                                try {
                                    g.ajouterSeanceTheatre(idPieceT,idjourPieceT,horaireDebutP,idSalleP);
                                } catch (Exception e){
                                    System.out.println("\n#ERROR#\n\t"+e.getMessage()+"\n#ERROR#");
                                }
                            }

                            break;
                        case 6:
                            System.out.println("-----------------------------------");
                            System.out.println("Vendre des places pour un film");
                            //g.afficherListFilm(g); // ne permet pas de s arreter si pas de film
                            if (g.lesFilms() != null ){
                                System.out.println(g.lesFilms());
                            }
                            else {
                                System.out.println("===> Aucun Film");
                                break;
                            }

                            System.out.println("Entrer id film :");
                            //int idFilmVendre = g.checkInt(sc);
                            int idFilmVendre =-1;
                            try {
                                idFilmVendre = g.checkInt(sc);
                            } catch (ZeroToBreakSwithException e){
                                System.out.println(e.getMessage());
                                break;
                            }

                            try {
                                System.out.println(g.lesSeancesFilm(idFilmVendre));
                            } catch (Exception e){
                                System.out.println("\n#ERROR#\n\t"+e.getMessage()+"\n#ERROR#");
                                break;
                            }

                            /** todo: pb psk ne paux pas sortir de la boucle => checkIntJour avec execption */
                            //------------------------------
                            // amelioration : peux pas entrer une seance qui n existe pas
                            //------------------------------
                            boolean existeSeanceFilm = false;
                            int idjourFVendre = -1; // instancie var avec valeur absurde
                            int heureDebutFVendre = -1; // instancie var avec valeur absurde
                            int minuteDebutFVendre = -1; // instancie var avec valeur absurde
                            while (!existeSeanceFilm){

                                System.out.println("Choix du jour :");
                                //idjourFVendre =g.checkIntJour(sc);
                                idjourFVendre =-1;
                                try {
                                    idjourFVendre = g.checkIntJour(sc);
                                } catch (ZeroToBreakSwithException e){
                                    System.out.println(e.getMessage());
                                    break;
                                }

                                System.out.println("Choix heure debut seance:");
                                heureDebutFVendre =g.checkIntHeure(sc);

                                System.out.println("Choix minute debut seance:");
                                minuteDebutFVendre = g.checkIntMinute(sc);

                                // pas besoin de try/catch car on test plus haut si idFilmVendre existe, si il n existe pas alors break
                                existeSeanceFilm = g.existeSeanceFilm(idFilmVendre,idjourFVendre,heureDebutFVendre,minuteDebutFVendre);
                                if (!existeSeanceFilm){// ne leve pas d exception donc doit faire un test
                                    //System.out.println("\n===> Séance inexistante");
                                    System.out.println("\n#ERROR#\n\t"+"===> Séance inexistante"+"\n#ERROR#");
                                }
                            }

                            int nbPlaceDispo=-1;
                            try {
                                nbPlaceDispo = g.getNbPlacesDispo(idFilmVendre,idjourFVendre,heureDebutFVendre,minuteDebutFVendre);
                            } catch (Exception e){
                                System.out.println("\n#ERROR#\n\t"+e.getMessage()+"\n#ERROR#");
                                break;
                            }
                            System.out.println("\n===> Il reste "+nbPlaceDispo+" places dans la salle ");

                            Horaire horaireDebutFilmVendre = new Horaire(heureDebutFVendre,minuteDebutFVendre);
                            System.out.println("Saisie nombre de places tarif normal :");
                            //int nbPlaceTarifNormal = g.checkInt(sc);
                            int nbPlaceTarifNormal =-1;
                            try {
                                nbPlaceTarifNormal = g.checkInt(sc);
                            } catch (ZeroToBreakSwithException e){
                                System.out.println(e.getMessage());
                                break;
                            }

                            System.out.println("Saisie nombre de places tarif reduit :");
                            //int nbPlaceTarifReduit = g.checkInt(sc);
                            int nbPlaceTarifReduit =-1;
                            try {
                                nbPlaceTarifReduit = g.checkInt(sc);
                            } catch (ZeroToBreakSwithException e){
                                System.out.println(e.getMessage());
                                break;
                            }

                            //------------------------------
                            // amelioration : permet de ne pas vendre de place; alors que prof vend place normal
                            //------------------------------
                            /*if ((nbPlaceTarifNormal+nbPlaceTarifReduit) <= nbPlaceDispo){
                                g.vendrePlaceFilmTN(idFilmVendre,idjourFVendre,horaireDebutFilmVendre,nbPlaceTarifNormal);
                                g.vendrePlaceFilmTR(idFilmVendre,idjourFVendre,horaireDebutFilmVendre,nbPlaceTarifReduit);
                                System.out.println("\n===> Place bien ajouter");
                            }
                            else {
                                System.out.println("\n===> Place NON ajouter : place normal + place reduction > place dispo");
                            }*/

                            try {
                                g.vendrePlaceFilmTN(idFilmVendre,idjourFVendre,horaireDebutFilmVendre,nbPlaceTarifNormal);
                                g.vendrePlaceFilmTR(idFilmVendre,idjourFVendre,horaireDebutFilmVendre,nbPlaceTarifReduit);
                            } catch (Exception e){
                                System.out.println("\n#ERROR#\n\t"+e.getMessage()+"\n#ERROR#");
                                break;
                            }
                            System.out.println("\n===> Place bien ajouter");

                            break;
                        case 7:
                            System.out.println("-----------------------------------");
                            System.out.println("Vendre des places pour piece theatre");
                            //g.afficheListPieceTheatre(g);
                            if (g.lesPieces() != null ){
                                System.out.println(g.lesPieces());
                            }
                            else {
                                System.out.println("===> Aucune Piece de theatre");
                                break;
                            }

                            System.out.println("Entrer id piece theatre :");
                            //int idPieceVendre = g.checkInt(sc);
                            int idPieceVendre =-1;
                            try {
                                idPieceVendre = g.checkInt(sc);
                            } catch (ZeroToBreakSwithException e){
                                System.out.println(e.getMessage());
                                break;
                            }

                            try {
                                System.out.println(g.lesSeancesTheatre(idPieceVendre));
                            } catch (Exception e){
                                System.out.println("\n#ERROR#\n\t"+e.getMessage()+"\n#ERROR#");
                                break;
                            }

                            /** todo: pb psk ne paux pas sortir de la boucle => checkIntJour avec execption */
                            //------------------------------
                            // amelioration : peux pas entrer une seance qui n existe pas
                            //------------------------------
                            boolean existeSeancePiece = false;
                            int idjourPVendre = -1; // instancie var avec valeur absurde
                            while (!existeSeancePiece){

                                System.out.println("Choix du jour :");
                                //idjourPVendre=g.checkIntJour(sc);
                                idjourPVendre =-1;
                                try {
                                    idjourPVendre = g.checkIntJour(sc);
                                } catch (ZeroToBreakSwithException e){
                                    System.out.println(e.getMessage());
                                    break;
                                }

                                existeSeancePiece = g.existeSeanceCeJour(idPieceVendre,idjourPVendre);
                                if (!existeSeancePiece){
                                    System.out.println("\n===> Séance inexistante");
                                }
                            }

                            int nbPlaceDispoP = -1;
                            try {
                                nbPlaceDispoP = g.getNbPlacesDispo(idPieceVendre,idjourPVendre);
                            } catch (Exception e){
                                System.out.println("\n#ERROR#\n\t"+e.getMessage()+"\n#ERROR#");
                                break;
                            }
                            System.out.println("\n===> Il reste "+nbPlaceDispoP+" places standard dans la salle ");
                            System.out.println("Saisie nombre de places standard :");
                            //int nbPlaceStandard = g.checkInt(sc);
                            int nbPlaceStandard =-1;
                            try {
                                nbPlaceStandard = g.checkInt(sc);
                            } catch (ZeroToBreakSwithException e){
                                System.out.println(e.getMessage());
                                break;
                            }

                            int nbFauteieulDispoP = -1;
                            try {
                                nbFauteieulDispoP = g.getNbFauteuilsDispo(idPieceVendre,idjourPVendre);
                            } catch (Exception e){
                                System.out.println("\n#ERROR#\n\t"+e.getMessage()+"\n#ERROR#");
                                break;
                            }
                            System.out.println("\n===> Il reste "+nbFauteieulDispoP+" fauteuils dans la salle ");
                            System.out.println("Saisie nombre de fauteuil :");
                            //int nbFauteuil = g.checkInt(sc);
                            int nbFauteuil =-1;
                            try {
                                nbFauteuil = g.checkInt(sc);
                            } catch (ZeroToBreakSwithException e){
                                System.out.println(e.getMessage());
                                break;
                            }

                            //------------------------------
                            // amelioration : permet de ne pas vendre de place; alors que prof vend place normal
                            // dans le senario 17) on doit afficher pas asser de fauteuil mais pb car on vent quand meme les place normal
                            //------------------------------
                            /*if ((nbPlaceStandard+nbFauteuil) <= (nbPlaceDispoP+nbFauteieulDispoP)){
                                g.vendrePlacePieceTN(idPieceVendre,idjourPVendre,nbPlaceStandard);
                                g.vendrePlaceFauteuilPiece(idPieceVendre,idjourPVendre,nbFauteuil);
                                System.out.println("\n===> Place bien ajouter");
                            }
                            else {
                                System.out.println("\n===> Place NON ajouter : place standard + fauteuil > place standard dispo + fauteuil dispo");
                            }*/
                            try {
                                g.vendrePlacePieceTN(idPieceVendre,idjourPVendre,nbPlaceStandard);
                                g.vendrePlaceFauteuilPiece(idPieceVendre,idjourPVendre,nbFauteuil);
                            } catch (Exception e){
                                System.out.println("\n#ERROR#\n\t"+e.getMessage()+"\n#ERROR#");
                                break;
                            }
                            System.out.println("\n===> Place bien ajouter");

                            break;
                        case 8:
                            System.out.println("-----------------------------------");
                            System.out.println("Chiffre affaire et taux remplisage");

                            //g.afficherListFilm(g);  // ne permet pas de s arreter si pas de film
                            //g.afficheListPieceTheatre(g); // ne permet pas de s arreter si pas de piece
                            if (g.lesFilms() != null ){
                                System.out.println(g.lesFilms());
                            }
                            else {
                                System.out.println("===> Aucun Film");
                            }
                            if (g.lesPieces() != null ){
                                System.out.println(g.lesPieces());
                            }
                            else {
                                System.out.println("===> Aucune Piece de theatre");
                            }
                            if (g.lesFilms() == null && g.lesPieces() == null ){
                                break;
                            }

                            System.out.println("Entrer id spectacle :");
                            //int idSpectacle = g.checkInt(sc);
                            int idSpectacle =-1;
                            try {
                                idSpectacle = g.checkInt(sc);
                            } catch (ZeroToBreakSwithException e){
                                System.out.println(e.getMessage());
                                break;
                            }

                            if(g.getSpectacle(idSpectacle) == null){ // ne leve pas d exception donc doit faire un test ==null
                                System.out.println("\n#ERROR#\n\t"+"===> id Spectacle inconu"+"\n#ERROR#");
                                break;
                            }

                            java.text.DecimalFormat df = new java.text.DecimalFormat("0.##");
                            double chiffreAfaire = g.chiffreAffaires(idSpectacle);
                            double tauxRemplisage = g.getTauxRemplissage(idSpectacle);

                            System.out.println("Chiffre affaire :"+df.format(chiffreAfaire)+" €");
                            System.out.println("Taux remplisage :"+df.format(tauxRemplisage)+" %");

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
