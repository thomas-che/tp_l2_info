package com.thomas;

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
        if (!lesTels.contains(num)){
            lesTels.add(index , num);
            return true;
        }
        return false;
    }

    public boolean ajouterFin(annuaire.NumTel num) {
        if (!lesTels.contains(num)) {
            lesTels.add(num);
            return true;
        }
        return false;
    }

    public boolean contientNumero(int num){
        return lesTels.contains(num);
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
        return lesTels.get(1);
    }

    public boolean retirer(int num) {
        if (1<nbNumeros()){
            lesTels.remove(num);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "ListeNumTel{" +
                "lesTels=" + lesTels.toArray() +
                '}';
    }
}
