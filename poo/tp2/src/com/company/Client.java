package com.company;

public class Client {
    private int idClient ;
    private String nom ;
    private String prenom;
    private String societe;
    boolean actif = true;

    public Client(int idClient, String nom, String prenom, String societe) {
        this.idClient = idClient;
        this.nom = nom;
        this.prenom = prenom;
        this.societe = societe;
    }

    public Client (int idClient, String nom) {
        this.idClient = idClient;
        this.nom = nom;
    }

    public Client () {

    }


    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getIdClient() {
        return idClient;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getSociete() {
        return societe;
    }

    public boolean isActif() {
        return actif;
    }

}
