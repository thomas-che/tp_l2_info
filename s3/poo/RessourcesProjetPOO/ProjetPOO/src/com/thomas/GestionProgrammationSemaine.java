package com.thomas;

public class GestionProgrammationSemaine implements IProgrammationSemaine {

    @Override
    public Film rechercherFilm(String titre, String realisateur) {
        return null;
    }

    @Override
    public void ajouterFilm(String titre, String realisateur, int duree) {

    }

    @Override
    public void ajouterInterprete(int numSpectacle, String interprete) {

    }

    @Override
    public PieceTheatre rechercherPiece(String titre, String metteurEnScene) {
        return null;
    }

    @Override
    public void ajouterPiece(String titre, String metteurEnScene, int nbEntractes) {

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
    public boolean existeFilm(int idFilm) {
        return false;
    }

    @Override
    public boolean existePiece(int idPiece) {
        return false;
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

    public ajou
}
