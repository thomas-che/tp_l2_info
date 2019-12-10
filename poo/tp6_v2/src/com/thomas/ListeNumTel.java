package com.thomas;

import annuaire.NumTel;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class ListeNumTel {
// choisi la List
    private List<annuaire.NumTel> lesTels;

    public ListeNumTel (annuaire.NumTel num){
// choix arraylist ou linkedlist ; ici peu d importance
        lesTels=new ArrayList<>();
        lesTels.add(num);
    }

    public boolean ajouter(int index, annuaire.NumTel num){
        if (index <0 || nbNumeros()<index ){
            throw new IndexOutOfBoundsException("hors limites");
        }
        if (!lesTels.contains(num)){
            lesTels.add(index , num);
            return true;
        }
        return false;
    }

    public boolean ajouterFin(annuaire.NumTel num) {
        if (!lesTels.contains(num)) {
            return lesTels.add(num);
        }
        return false;
    }

    public boolean ajouterDebut(annuaire.NumTel num) {
        return ajouter(0,num);
    }

// on doit cree une varaiable numerorecherche pour qu il est le meme type que le numtel stoquer dans lestel
    public boolean contientNumero(int num){
        annuaire.NumTel numerorecherche = new NumTel(num);
        return lesTels.contains(numerorecherche);
    }

    public Iterator<annuaire.NumTel> iterator() {
        return lesTels.iterator();
    }

    public int nbNumeros(){
        return lesTels.size();
    }

    public annuaire.NumTel numero(int index){
        if (0<index && index<nbNumeros()){
            return lesTels.get(index);
        }
        throw new IndexOutOfBoundsException("l indice n est pas correct");
    }

    public annuaire.NumTel premierNumero() {
        return lesTels.get(0);
    }

    public boolean retirer(int num) {
        if (1<nbNumeros()){
            NumTel numAretirer=new NumTel(num);
            lesTels.remove(numAretirer);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        // return "ListeNumTel{" +
        //        "lesTels=" + lesTels.toArray() +
        //        '}';

        // ou
        // return lesTels.toString();

        // ou avec un iterator
        String s="";
        Iterator<NumTel> it = lesTels.iterator();
        while (it.hasNext()){
            s+=it.next()+" ";
        }
        return s;
    }
}
