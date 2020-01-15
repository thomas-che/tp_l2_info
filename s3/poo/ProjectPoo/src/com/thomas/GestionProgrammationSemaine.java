package com.thomas;

import java.sql.SQLOutput;
import java.util.*;

public class GestionProgrammationSemaine implements IProgrammationSemaine {

    private SortedMap<Integer,Salle> lesSalle;
    private SortedMap<Integer,SalleTheatre> lesSalleTheatre;

    private SortedMap<Integer,Film> lesFilms;
    private SortedMap<Integer,PieceTheatre> lesPieceTheatres;

    public GestionProgrammationSemaine (){

        lesSalle = new TreeMap<>();
        Salle s1 = new Salle("salle 1",100, 12.43);
        lesSalle.put(s1.getNum(),s1);
        Salle s2 = new Salle("salle 2",105, 8);
        lesSalle.put(s2.getNum(),s2);
        Salle s3 = new Salle("salle 3",45, 14.99);
        lesSalle.put(s3.getNum(),s3);
        Salle s4 = new Salle("salle 4",200, 5.99);
        lesSalle.put(s4.getNum(),s4);

        lesSalleTheatre = new TreeMap<>();
        SalleTheatre st1 = new SalleTheatre("salle theatre 1",100,12.43,10,25.99);
        lesSalleTheatre.put(st1.getNum(),st1);
        SalleTheatre st2 = new SalleTheatre("salle theatre 2",110,8,30,19.99);
        lesSalleTheatre.put(st2.getNum(),st2);
        SalleTheatre st3 = new SalleTheatre("salle theatre 3",45,14.99,10,35.99);
        lesSalleTheatre.put(st3.getNum(),st3);
        SalleTheatre st4 = new SalleTheatre("salle theatre 4",200,5.99,50,12.99);
        lesSalleTheatre.put(st4.getNum(),st4);

        lesFilms = new TreeMap<>();
        lesPieceTheatres = new TreeMap<>();
    }

    // plus utiliser car ne permet pas de s arreter si pas de film
    public void afficherListFilm (GestionProgrammationSemaine g){
        if (g.lesFilms() != null ){
            System.out.println(g.lesFilms());
        }
        else {
            System.out.println("===> Aucun Film");

        }
    }

    // plus utiliser car ne permet pas de s arreter si pas de pice theatre
    public void afficheListPieceTheatre(GestionProgrammationSemaine g){
        if (g.lesPieces() != null ){
            System.out.println(g.lesPieces());
        }
        else {
            System.out.println("===> Aucune Piece de theatre");
        }
    }

    // checkInt avant de faire la version avec exception
    /*public int checkInt(Scanner sc ){
        String str = "";
        int num=-1;
        boolean isInt = false;
        while (!isInt){
            if (sc.hasNextInt()){
                num = sc.nextInt(); // afectation de la valeur
                isInt=true;
            }
            else {
                System.out.println("==> Enter un nb entier");
                str=sc.next();
            }
        }
        return num;
    }*/

    /**
     * permet de tester si la saisie est bien un entier
     * @param sc
     * @return un int qui sera stocker dans la une var du main
     * @throws ZeroToBreakSwithException permet d arreter le switch si on appuit sur 0
     */
   public int checkInt(Scanner sc ) throws ZeroToBreakSwithException {
        String str = "";
        int num=-1;
        boolean isInt = false;
        while (!isInt){
           if (sc.hasNextInt()){
               num = sc.nextInt(); // afectation de la valeur
               isInt=true;
           }
           else {
               int reponce=retourMenuOuContinue(sc);
               if (reponce == 1){
                   System.out.println("==> Enter un nb entier");
               }
               else {
                   throw new ZeroToBreakSwithException("\n==> Fin saisie, retour menu");
               }
           }
        }
        return num;
   }

    /*public int checkIntJour(Scanner sc){
        String str="";
        int numJour = -1; // instancie var avec valeur absurde
        boolean isInt = false;
        while (!isInt){
            if (sc.hasNextInt()){
                numJour = sc.nextInt(); // afectation de la valeur
                if(1<=numJour && numJour<=7){
                    isInt=true;
                }
                else{
                    System.out.println("==> Enter un nb entier entre 1 et 7");
                }
            }
            else {
                System.out.println("==> Enter un nb entier entre 1 et 7");
                str=sc.next();
            }
        }
        return numJour;
    }*/

    /**
     * permet de tester si la saisie est bien un entier entre 1=lundi et 7=dimanche
     * @param sc
     * @return un int qui sera stocker dans la une var du main
     * @throws ZeroToBreakSwithException permet d arreter le switch si on appuit sur 0
     */
   public int checkIntJour(Scanner sc) throws ZeroToBreakSwithException{
        String str="";
       int numJour = -1; // instancie var avec valeur absurde
       boolean isInt = false;
       while (!isInt){
           if (sc.hasNextInt()){
               numJour = sc.nextInt(); // afectation de la valeur
               if(1<=numJour && numJour<=7){
                   isInt=true;
               }
               else{
                   int reponce=retourMenuOuContinue(sc);
                   if (reponce == 1){
                       System.out.println("==> Enter un nb entier entre 1 et 7");
                   }
                   else {
                       throw new ZeroToBreakSwithException("\n==> Fin saisie, retour menu");
                   }
               }
           }
           else {
               int reponce=retourMenuOuContinue(sc);
               if (reponce == 1){
                   System.out.println("==> Enter un nb entier entre 1 et 7");
               }
               else {
                   throw new ZeroToBreakSwithException("\n==> Fin saisie, retour menu");
               }
           }
       }
       return numJour;
   }

    /**
     * on test si la saisie est bien une heure = entre 0 et 23
     * @param sc
     * @return l heure
     */
   public int checkIntHeure(Scanner sc){
        String str="";
       int heure = -1; // instancie var avec valeur absurde
       boolean isInt = false;
       while (!isInt){
           if (sc.hasNextInt()){
               heure = sc.nextInt(); // afectation de la valeur
               if(0<=heure && heure<=23){
                   isInt=true;
               }
               else{
                   System.out.println("==> Enter un nb entier entre 0 et 23");
               }
           }
           else {
               System.out.println("==> Enter un nb entier entre 0 et 23");
               str=sc.next();
           }
       }
       return heure;
   }
    /**
     * on test si la saisie est bien une minute= entre 0 et 59
     * @param sc
     * @return la minute
     */
   public int checkIntMinute(Scanner sc){
        int minute = -1;
        String str="";
       boolean isInt = false;
       while (!isInt){
           if (sc.hasNextInt()){
               minute = sc.nextInt(); // afectation de la valeur
               if(0<=minute && minute<=59){
                   isInt=true;
               }
               else{
                   System.out.println("==> Enter un nb entier entre 0 et 59");
               }
           }
           else {
               System.out.println("==> Enter un nb entier entre 0 et 59");
               str=sc.next();
           }
       }
       return minute;
   }

    /**
     * permet de demander au user si il veux continuer(1)<=>recomencer saisie ou s arreter(0)
     * @param sc
     * @return reponce 1/0 qui sera traiter dans checkInt et checkIntJour
     */
   public int retourMenuOuContinue(Scanner sc){
       System.out.println("#ERROR: Erreur de saisie: continuer=1 ; retour menu=0");
       String str ="";
       int rep = -1;
       boolean reponceCorrect=false;
       while (!reponceCorrect){
           if(sc.hasNextInt()){
               rep = sc.nextInt();
               if (rep == 1){
                   reponceCorrect=true;
                   return 1;
               }
               else if (rep == 0){
                    reponceCorrect=true;
                    return 0;
               }
               else {
                   System.out.println("==> Enter un nb entier entre 0/1");
                   str=sc.next();
               }
           }
           else {
               System.out.println("==> Enter un nb entier entre 0/1");
               str=sc.next();
           }
       }
       return rep;
   }

    @Override
    public boolean estUnFilm(int numSpectacle) {
        if (lesFilms.containsKey(numSpectacle)){
            return true;
        }
        return false;
    }

    @Override
    public boolean estUnePiece(int numSpectacle) {
       if (lesPieceTheatres.containsKey(numSpectacle)){
           return true;
       }
        return false;
    }

    // ne leve pas d exception donc doit faire un test ==null
    @Override
    public Spectacle getSpectacle(int numSpectacle) {
       if (estUnFilm(numSpectacle)){
           return lesFilms.get(numSpectacle);
       }
       if (estUnePiece(numSpectacle)){
           return lesPieceTheatres.get(numSpectacle);
       }
        return null;
    }

    @Override
    public String lesFilms() {
        String s = "-------FILM-----------\n";
        String t = "\n----------------------";
        if (0 < lesFilms.size()){
            return s+lesFilms.toString()+t;
        }
        return null;
    }

    @Override
    public String lesPieces() {
        String s = "-------PIECE THEATRE-----------\n";
        String t = "\n-------------------------------";
        if (0 < lesPieceTheatres.size()){
            return s+lesPieceTheatres.toString()+t;
        }
        return null;
    }

    @Override
    public String lesSallesFilm() {
        String s = "-------SALLE FILM-----------";
        String t = "\n----------------------------";
       String listSalleF="";
       Set lesSalleF = lesSalle.keySet();
       Iterator<Integer> it = lesSalleF.iterator();
       while (it.hasNext()){
           Integer numSalleF = it.next();
           Salle salleF = lesSalle.get(numSalleF);
           listSalleF+=salleF.affichierSalle();
       }
        return s+listSalleF+t;
    }

    @Override
    public boolean existeSalleFilm(int idSalle) {
        if (lesSalle.containsKey(idSalle)){
            return true;
        }
        else return false;
    }

    @Override
    public String lesSallesTheatre() {
        String s = "-------SALLE THEATRE-----------";
        String t = "\n-------------------------------";
        String listSalleT="";
        Set lesSalleT = lesSalleTheatre.keySet();
        Iterator<Integer> it = lesSalleT.iterator();
        while (it.hasNext()){
            Integer numSalleT = it.next();
            SalleTheatre salleT = lesSalleTheatre.get(numSalleT);
            listSalleT+=salleT.affichierSalle();
        }
        return s+listSalleT+t;
    }

    @Override
    public boolean existeSalleTheatre(int idSalle) {
        if (lesSalleTheatre.containsKey(idSalle)){
            return true;
        }
        else return false;
    }

    /** fini */
    @Override
    public Film rechercherFilm(String titre, String realisateur) {
        Set lesClefFilm = lesFilms.keySet();
        Iterator<Integer> it = lesClefFilm.iterator();
        while (it.hasNext()){
            Integer numFilm = it.next();
            Film film = lesFilms.get(numFilm);
            if (film.getTitre().equals(titre) && film.getNomRealisateur().equals(realisateur)){
                return film;
            }
        }
        return null;
    }

    /** fini */
    @Override
    public PieceTheatre rechercherPiece(String titre, String metteurEnScene) {
        Set lesClefPiece = lesPieceTheatres.keySet();
        Iterator<Integer> it = lesClefPiece.iterator();
        while (it.hasNext()){
            Integer numPiece = it.next();
            PieceTheatre piece = lesPieceTheatres.get(numPiece);
            if (piece.getTitre().equals(titre) && piece.getNomMeteurSC().equals(metteurEnScene)){
                return piece;
            }
        }
        return null;
    }

    /** fini */
    @Override
    public void ajouterFilm(String titre, String realisateur, int duree) {
        Film f = new Film(titre, realisateur, duree);
        if (rechercherFilm(titre,realisateur)==null){
            lesFilms.put(f.getNumero(),f);
        }
        else {
            throw new IllegalArgumentException("Film déjà existant");
        }

        System.out.println(lesFilms());
    }

    /** fini */
    @Override
    public void ajouterPiece(String titre, String metteurEnScene, int nbEntractes) {
        PieceTheatre p = new PieceTheatre(titre, metteurEnScene, nbEntractes);
        if (rechercherPiece(titre,metteurEnScene) == null){
            lesPieceTheatres.put(p.getNumero(),p);
        }
        else {
            throw new IllegalArgumentException("Piece de Theatre déjà existant");
        }

        System.out.println(lesPieces());
    }

    /** fini */
    @Override
    public boolean existeFilm(int idFilm) {
        if (lesFilms.containsKey(idFilm)){
            return true;
        }
        else return false;
    }

    /** fini */
    @Override
    public boolean existePiece(int idPiece) {
        if (lesPieceTheatres.containsKey(idPiece)){
            return true;
        }
        else return false;
    }

    /** fini */
    @Override
    public void ajouterInterprete(int numSpectacle, String interprete) {
       if (existeFilm(numSpectacle) ){
           Film f = lesFilms.get(numSpectacle);
           f.ajouterInterprete(interprete);
       }
       else if (existePiece(numSpectacle)){
           PieceTheatre p = lesPieceTheatres.get(numSpectacle);
           p.ajouterInterprete(interprete);
       }
       else {
           throw new IllegalArgumentException("Spectacle inexistant");
       }

        System.out.println(lesFilms());
        System.out.println(lesPieces());
    }

    /** fini */
    @Override
    public void ajouterSeanceFilm(int idFilm, int jour, Horaire debut, int idSalle) {
        if (!existeFilm(idFilm)){
            throw new IllegalArgumentException("Film inexistant");
        }
        Film film = lesFilms.get(idFilm);
        int dureeFilm = film.getDuree();
        Horaire horaireFinFilm = debut.calcHorairePlusDuree(debut,dureeFilm); // ou peut essayer avec dureeFilm (int idFilm)
        Creneau creneau = new Creneau(jour,debut,horaireFinFilm);

        if (!existeSalleFilm(idSalle)){
            throw new IllegalArgumentException("Salle inexistante");
        }
        Salle salle = lesSalle.get(idSalle);

        SeanceFilm seance = new SeanceFilm(creneau,salle);
        boolean res = film.ajouterSeanceFilm(seance);
        if (res){
            System.out.println("\n===> Seance du Film est bien ajouter");
        }
        else {
            throw new IllegalStateException ("Créneau indisponible pour dans cette salle");
        }
    }

    /** fini */
    @Override
    public boolean existeSeanceCeJour(int idPiece, int jour) {
        if (!existePiece(idPiece)){
            throw new IllegalArgumentException("Piece de theatre inexistante");
        }
        PieceTheatre pieceTheatre = lesPieceTheatres.get(idPiece);
        if (pieceTheatre.existeSeanceCeJour(jour)){
            return true;
        }
        return false;
    }

    /** fini */
    @Override
    public void ajouterSeanceTheatre(int idPiece, int jour, Horaire debut, int idSalle) {
        if (!existePiece(idPiece)){
            throw new IllegalArgumentException("Piece de theatre inexistante");
        }
        PieceTheatre pieceTheatre = lesPieceTheatres.get(idPiece);
        int dureePiece = 180;
        Horaire horaireFinP = debut.calcHorairePlusDuree(debut,dureePiece);
        Creneau creneau = new Creneau(jour,debut,horaireFinP);
        if (!existeSalleTheatre(idSalle)){
            throw new IllegalArgumentException("Salle theatre inexistante");
        }
        SalleTheatre salleT = lesSalleTheatre.get(idSalle);

        SeanceTheatre seance = new SeanceTheatre(creneau,salleT);
        boolean res = pieceTheatre.ajouterSeanceTheatre(seance);
        if (res){
            System.out.println("\n===> Seance de theatre est bien ajouter");
        }
        else {
            throw new IllegalStateException ("Créneau indisponible pour dans cette salle");
        }
    }

    /** fini */
    @Override
    public String lesSeancesTheatre(int idPiece) {
        if (!existePiece(idPiece)){
            throw new IllegalArgumentException("Piece de theatre inexistante");
        }
        String s = "-------SEANCE PIECE THEATRE-----------\n";
        String t = "\n--------------------------------------";
        PieceTheatre piece = lesPieceTheatres.get(idPiece);
        Set<Seance> seancePiece = piece.getLesSeances();
        if (seancePiece.isEmpty()){
            return s+"Aucune séance"+t;
        }
        else return s+seancePiece.toString()+t;
    }

    /** fini */
    @Override
    public String lesSeancesFilm(int idFilm) {
        if (!existeFilm(idFilm)){
            throw new IllegalArgumentException("Film inexistant");
        }
        String s = "-------SEANCE FILM-----------\n";
        String t = "\n-----------------------------";
        Film film = lesFilms.get(idFilm);
        Set<Seance> seanceFilm = film.getLesSeances();
        if (seanceFilm.isEmpty()){
            return s+"Aucune séance"+t;
        }
        else return s+seanceFilm.toString()+t;
    }

    /** fini */
    @Override // film car plusieur seance le meme jours
    public int getNbPlacesDispo(int numSpectacle, int jour, int heures, int minutes) {
        if (!existeFilm(numSpectacle)){
            throw new IllegalArgumentException("Spectacle (film) inexistant");
        }
        Horaire newHoraire = new Horaire(heures,minutes);
        Film film = lesFilms.get(numSpectacle);
        Set<Seance> seanceFilm = film.getLesSeances();
        Iterator<Seance> it = seanceFilm.iterator();
        while (it.hasNext()){
            SeanceFilm seanceF = (SeanceFilm) it.next();
            Creneau creneau = seanceF.getCreneau();
            int numJour = creneau.getNumJour();
            Horaire heureDebut = creneau.getHoraireDebut();
            if (jour == numJour && newHoraire.equals(heureDebut)){
                return seanceF.nbPlaceStandardDisponible();
            }
        }
        throw new IllegalArgumentException("Séance inexistante pour ce spectacle");
    }

    /** fini;
     * imposible seance inexitante car test avant dans le main */
    @Override
    public void vendrePlaceFilmTN(int idFilm, int jour, Horaire debut, int nbPlacesTN) {
        if (!existeFilm(idFilm)){
            throw new IllegalArgumentException("Film inexistant");
        }
        boolean seanceNonTrouver = true;
        Film film = lesFilms.get(idFilm);
        Set<Seance> seanceFilm = film.getLesSeances();
        Iterator<Seance> it = seanceFilm.iterator();
        while (it.hasNext()){
            SeanceFilm seanceF = (SeanceFilm) it.next();
            Creneau creneau = seanceF.getCreneau();
            int numJour = creneau.getNumJour();
            Horaire heureDebut = creneau.getHoraireDebut();
            if (jour == numJour && debut.equals(heureDebut)){
                int nbPlasceDispo = seanceF.nbPlaceStandardDisponible();
                if (nbPlasceDispo < nbPlacesTN){
                    throw new IllegalArgumentException("Pas assez de places disponibles");
                }
                seanceF.vendrePlacesTN(nbPlacesTN);
                seanceNonTrouver=false;
            }
        }
        if (seanceNonTrouver){
            throw new IllegalArgumentException("Séance inexistante pour ce spectacle");
        }
    }

    /** fini
     * imposible seance inexitante car test avant dans le main */
    @Override
    public void vendrePlaceFilmTR(int idFilm, int jour, Horaire debut, int nbPlacesTR) {
        if (!existeFilm(idFilm)){
            throw new IllegalArgumentException("Film inexistant");
        }
        boolean seanceNonTrouver = true;
        Film film = lesFilms.get(idFilm);
        Set<Seance> seanceFilm = film.getLesSeances();
        Iterator<Seance> it = seanceFilm.iterator();
        while (it.hasNext()){
            SeanceFilm seanceF = (SeanceFilm) it.next();
            Creneau creneau = seanceF.getCreneau();
            int numJour = creneau.getNumJour();
            Horaire heureDebut = creneau.getHoraireDebut();
            if (jour == numJour && debut.equals(heureDebut)){
                int nbPlasceDispo = seanceF.nbPlaceStandardDisponible();
                if (nbPlasceDispo < nbPlacesTR){
                    throw new IllegalArgumentException("Pas assez de places disponibles");
                }
                seanceF.vendrePlacesTR(nbPlacesTR);
                seanceNonTrouver=false;
            }
        }
        if (seanceNonTrouver){
            throw new IllegalArgumentException("Séance inexistante pour ce spectacle");
        }
    }

    /** fini */
    @Override
    public boolean existeSeanceFilm(int idFilm, int jour, int heures, int minutes) {
        if (!existeFilm(idFilm)){
            throw new IllegalArgumentException("Film inexistant");
        }
        Horaire horaireDebut = new Horaire(heures,minutes);
        Film film = lesFilms.get(idFilm);
        Set<Seance> seanceFilm = film.getLesSeances();
        Iterator<Seance> it = seanceFilm.iterator();
        while (it.hasNext()){
            SeanceFilm seanceF = (SeanceFilm) it.next();
            Creneau creneau = seanceF.getCreneau();
            int numJour = creneau.getNumJour();
            Horaire heureDebut = creneau.getHoraireDebut();
            if (jour == numJour && horaireDebut.equals(heureDebut)){
                return true;
            }
        }
        return false;
    }

    /** fini */
    @Override
    public int getNbFauteuilsDispo(int idPiece, int jour) {
        if (!existePiece(idPiece)){
            throw new IllegalArgumentException("Spectacle (piece theatre) inexistant");
        }
        PieceTheatre pieceTheatre = lesPieceTheatres.get(idPiece);
        Set<Seance> seancePiece = pieceTheatre.getLesSeances();
        Iterator<Seance> it = seancePiece.iterator();
        while (it.hasNext()){
            SeanceTheatre seanceTheatre = (SeanceTheatre) it.next();
            return seanceTheatre.nbPlaceFauteuilDisponible();
        }
        throw new IllegalArgumentException("Aucune séance ce jour");
    }

    /** fini */
    @Override
    public int getNbPlacesDispo(int idPiece, int jour) {
        if (!existePiece(idPiece)){
            throw new IllegalArgumentException("Spectacle (piece theatre) inexistant");
        }
        PieceTheatre pieceTheatre = lesPieceTheatres.get(idPiece);
        Set<Seance> seancePiece = pieceTheatre.getLesSeances();
        Iterator<Seance> it = seancePiece.iterator();
        while (it.hasNext()){
            SeanceTheatre seanceTheatre = (SeanceTheatre) it.next();
            return seanceTheatre.nbPlaceStandardDisponible();
        }
        throw new IllegalArgumentException("Aucune séance ce jour");
    }

    /** fini */
    @Override
    public void vendrePlacePieceTN(int idPiece, int jour, int nbPlacesTN) {
        if (!existePiece(idPiece)){
            throw new IllegalArgumentException("Piece de theatre inexistante");
        }
        boolean seanceNonTrouver = true;
        PieceTheatre pieceTheatre = lesPieceTheatres.get(idPiece);
        Set<Seance> seancePiece = pieceTheatre.getLesSeances();
        Iterator<Seance> it = seancePiece.iterator();
        while (it.hasNext()){
            SeanceTheatre seanceTheatre = (SeanceTheatre) it.next();

            int nbPlasceDispo = seanceTheatre.nbPlaceStandardDisponible();
            if (nbPlasceDispo < nbPlacesTN){
                throw new IllegalArgumentException("Pas assez de places disponibles");
            }
            seanceTheatre.vendrePlacesTN(nbPlacesTN);
            seanceNonTrouver =false;
        }
        if (seanceNonTrouver){
            throw new IllegalArgumentException("Séance inexistante pour ce spectacle");
        }

    }

    /** fini */
    @Override
    public void vendrePlaceFauteuilPiece(int idPiece, int jour, int nbFauteuils) {
        if (!existePiece(idPiece)){
            throw new IllegalArgumentException("Piece de theatre inexistante");
        }
        boolean seanceNonTrouver = true;
        PieceTheatre pieceTheatre = lesPieceTheatres.get(idPiece);
        Set<Seance> seancePiece = pieceTheatre.getLesSeances();
        Iterator<Seance> it = seancePiece.iterator();
        while (it.hasNext()){
            SeanceTheatre seanceTheatre = (SeanceTheatre) it.next();

            int nbFauteuilDispo = seanceTheatre.nbPlaceFauteuilDisponible();
            if (nbFauteuilDispo < nbFauteuils){
                throw new IllegalArgumentException("Pas assez de Fauteuil disponibles");
            }
            seanceTheatre.vendrePlacesTN(nbFauteuils);
            seanceNonTrouver =false;

            seanceTheatre.vendrePlacesFauteuil(nbFauteuils);
        }
        if (seanceNonTrouver){
            throw new IllegalArgumentException("Séance inexistante pour ce spectacle");
        }
    }

    /** fini */
    @Override
    public double chiffreAffaires(int numSpectacle) {
        double res = 0;
        if (existeFilm(numSpectacle) ){
            Film film = lesFilms.get(numSpectacle);
            Set<Seance> lesSeanceFilm = film.getLesSeances();
            Iterator<Seance> it = lesSeanceFilm.iterator();
            while(it.hasNext()){
                SeanceFilm seanceFilm = (SeanceFilm) it.next();
                Salle salle = seanceFilm.getSalleStandard();

                int nbPlaceStandard = seanceFilm.getNbPlaceNormalVendu();
                double prixPlaceStandard = salle.getTarifPlace();
                int nbPlaceTarifReduit = seanceFilm.getNbPlaceVenduTarifReduit();
                double prixPlaceTarifReduit = prixPlaceStandard*(0.6);

                res+=nbPlaceStandard*prixPlaceStandard + nbPlaceTarifReduit*prixPlaceTarifReduit;
            }
            return res;
        }
        else if (existePiece(numSpectacle)){
            PieceTheatre pieceTheatre = lesPieceTheatres.get(numSpectacle);
            Set<Seance> lesSeancePiece = pieceTheatre.getLesSeances();
            Iterator<Seance> it = lesSeancePiece.iterator();
            while (it.hasNext()){
                SeanceTheatre seanceTheatre = (SeanceTheatre) it.next();
                SalleTheatre salleTheatre = seanceTheatre.getSalleTheatre();

                int nbPlaceStandard = seanceTheatre.getNbPlaceNormalVendu();
                double prixPlaceStandard = salleTheatre.getTarifPlace();
                int nbFauteuil = seanceTheatre.getNbFauteilVendu();
                double prixFauteuil = salleTheatre.getTarifFauteuil();

                res+=nbPlaceStandard*prixPlaceStandard + nbFauteuil*prixFauteuil;
            }
            return res;
        }
        else {
            throw new IllegalArgumentException("Spectacle inexistant");
        }
    }

    /** fini */
    @Override
    public double getTauxRemplissage(int numSpectacle) {
        double taux = 0;
        int nbBoucle =0;

        if (existeFilm(numSpectacle) ){
            Film film = lesFilms.get(numSpectacle);
            Set<Seance> lesSeanceFilm = film.getLesSeances();
            Iterator<Seance> it = lesSeanceFilm.iterator();
            while(it.hasNext()){
                SeanceFilm seanceFilm = (SeanceFilm) it.next();

                double tauxSeanceFilm = seanceFilm.tauxRemplisage();
                taux+=tauxSeanceFilm;
                nbBoucle++;
            }
            return taux/nbBoucle;
        }
        else if (existePiece(numSpectacle)){
            PieceTheatre pieceTheatre = lesPieceTheatres.get(numSpectacle);
            Set<Seance> lesSeancePiece = pieceTheatre.getLesSeances();
            Iterator<Seance> it = lesSeancePiece.iterator();
            while (it.hasNext()){
                SeanceTheatre seanceTheatre = (SeanceTheatre) it.next();

                double tauxSeancePiece = seanceTheatre.tauxRemplisage();
                taux+=tauxSeancePiece;
                nbBoucle++;
            }
            return taux/nbBoucle;
        }
        else {
            throw new IllegalArgumentException("Spectacle inexistant");
        }
    }

    @Override
    public void reinitialiserProgrammation() {
        lesFilms.clear();
        lesPieceTheatres.clear();

        Set lesSalleF = lesSalle.keySet();
        Iterator<Integer> it = lesSalleF.iterator();
        while (it.hasNext()){
            Integer numSalleF = it.next();
            Salle salleF = lesSalle.get(numSalleF);
            salleF.viderCreneauOcuper();
        }
    }












/** a redefinir / non utilise */

    @Override
    public int dureeFilm(int idFilm) {
        return 0;
    }

    // devrait etre utiliser avant g.ajouterSeanceFilm qui appelle film.ajouterSeanceFilm dans la quelle je test si salle est dispo
    @Override
    public boolean salleStandardDisponible(int jour, Horaire debut, int duree, int idSalle) {
        return false;
    }

}
