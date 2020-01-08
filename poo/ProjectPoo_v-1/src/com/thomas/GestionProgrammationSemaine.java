package com.thomas;

import java.util.Iterator;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

public class GestionProgrammationSemaine implements IProgrammationSemaine {

    private SortedMap<Integer,Film> lesFilms;
    private SortedMap<Integer,PieceTheatre> lesPieceTheatres;

    public GestionProgrammationSemaine (){
        lesFilms = new TreeMap<>();
        lesPieceTheatres = new TreeMap<>();
    }


    public String afficheListFilm(){
        return lesFilms.toString();
    }

    public String afficheListPieceTheatre(){
        return lesPieceTheatres.toString();
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
            //throw new IllegalArgumentException("Film deja renter");
            System.out.println("Film deja renter");
        }

        System.out.println(afficheListFilm());
    }

    /** fini */
    @Override
    public void ajouterPiece(String titre, String metteurEnScene, int nbEntractes) {
        PieceTheatre p = new PieceTheatre(titre, metteurEnScene, nbEntractes);
        if (rechercherPiece(titre,metteurEnScene) == null){
            lesPieceTheatres.put(p.getNumero(),p);
        }
        else {
            //throw new IllegalArgumentException("Piece de Theatre deja renter");
            System.out.println("Piece de Theatre deja renter");
        }

        System.out.println(afficheListPieceTheatre());
    }

    /** fini */
    @Override
    public boolean existeFilm(int idFilm) {
        Set lesClefF = lesFilms.keySet();
        Iterator<Integer> it = lesClefF.iterator();
        while (it.hasNext()) {
            Integer numFilm = it.next();
            Film f = lesFilms.get(numFilm);
            if (f.getNumero() == idFilm) {
                return true;
            }
        }
        return false;
    }

    /** fini */
    @Override
    public boolean existePiece(int idPiece) {
        Set lesClefP = lesPieceTheatres.keySet();
        Iterator<Integer> it = lesClefP.iterator();
        while (it.hasNext()) {
            Integer numPiece = it.next();
            PieceTheatre p = lesPieceTheatres.get(numPiece);
            if (p.getNumero() == idPiece) {
                return true;
            }
        }
        return false;
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

        System.out.println(afficheListFilm());
        System.out.println(afficheListPieceTheatre());
    }








    @Override
    public void ajouterSeanceFilm(int idFilm, int jour, Horaire debut, int idSalle) {

    }

    @Override
    public boolean existeSeanceCeJour(int idPiece, int jour) {
        return false;
    }

    @Override
    public void ajouterSeanceTheatre(int idPiece, int jour, Horaire debut, int idSalle) {

    }

    @Override
    public double chiffreAffaires(int numSpectacle) {
        return 0;
    }

    @Override
    public double getTauxRemplissage(int numSpectacle) {
        return 0;
    }

    @Override
    public void vendrePlaceFilmTN(int idFilm, int jour, Horaire debut, int nbPlacesTN) {

    }

    @Override
    public void vendrePlaceFilmTR(int idFilm, int jour, Horaire debut, int nbPlacesTR) {

    }

    @Override
    public void vendrePlacePieceTN(int idPiece, int jour, int nbPlacesTN) {

    }

    @Override
    public void vendrePlaceFauteuilPiece(int idPiece, int jour, int nbFauteuils) {

    }

    @Override
    public String lesFilms() {
        return null;
    }

    @Override
    public String lesPieces() {
        return null;
    }

    @Override
    public String lesSallesFilm() {
        return null;
    }

    @Override
    public String lesSallesTheatre() {
        return null;
    }

    @Override
    public String lesSeancesTheatre(int idPiece) {
        return null;
    }

    @Override
    public String lesSeancesFilm(int idFilm) {
        return null;
    }

    @Override
    public int getNbPlacesDispo(int numSpectacle, int jour, int heures, int minutes) {
        return 0;
    }




    @Override
    public boolean existeSeanceFilm(int idFilm, int jour, int heures, int minutes) {
        return false;
    }

    @Override
    public boolean existeSalleFilm(int idSalle) {
        return false;
    }

    @Override
    public boolean existeSalleTheatre(int idSalle) {
        return false;
    }

    @Override
    public int dureeFilm(int idFilm) {
        return 0;
    }

    @Override
    public boolean salleStandardDisponible(int jour, Horaire debut, int duree, int idSalle) {
        return false;
    }

    @Override
    public void reinitialiserProgrammation() {

    }

    @Override
    public int getNbFauteuilsDispo(int idPiece, int jour) {
        return 0;
    }

    @Override
    public int getNbPlacesDispo(int idPiece, int jour) {
        return 0;
    }

    @Override
    public boolean estUnFilm(int numSpectacle) {
        return false;
    }

    @Override
    public boolean estUnePiece(int numSpectacle) {
        return false;
    }

    @Override
    public Spectacle getSpectacle(int numSpectacle) {
        return null;
    }
}
