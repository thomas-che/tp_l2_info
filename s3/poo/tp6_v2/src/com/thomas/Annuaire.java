package com.thomas;

import annuaire.NumTel;

import java.util.*;

public class Annuaire {

    private Map<annuaire.Personne,ListeNumTel> annuaire;

    public Annuaire (){
        annuaire=new HashMap<>();
    }

    public boolean ajouterEntree(annuaire.Personne p, ListeNumTel nums){
        //if (annuaire.containsKey(p)){
        //    return false;
        //}
        //annuaire.put(p, nums);
        //return true;

        if (annuaire.putIfAbsent(p, nums) == null){
            return true;
        }
        return false;
    }

    public ListeNumTel numeros(annuaire.Personne p){
        return annuaire.get(p);
    }
// prof ; pr avoir un ensemble de personne
    public Iterator<annuaire.Personne> personnes() {
        Set<annuaire.Personne> pers = annuaire.keySet();
        return pers.iterator();
    }

// prof
    public void ajouterNumeroFin(annuaire.Personne p, NumTel n) {
        ListeNumTel listeNum = numeros(p);
        if (listeNum != null) {
            listeNum.ajouterFin(n);
        } else {
            listeNum = new ListeNumTel(n);
            annuaire.put(p, listeNum);
        }

        // ou plus simple prof
        ListeNumTel listeNum = annuaire.putIfAbsent(p, new ListeNumTel(n));
        if (listeNum != null) {
            listeNum.ajouterFin(n);
        }
    }

// prof
    public NumTel premierNumero (annuaire.Personne p){
        NumTel num = null;
        ListeNumTel listeNum = numeros(p);
        if (listeNum != null){
            num=listeNum.premierNumero();
        }
        return num;
    }

    public void supprimer (annuaire.Personne p){
        annuaire.remove(p);
    }

    public String toString(){
        String s="";

        Set<Map.Entry<annuaire.Personne,ListeNumTel>> lesEntree = annuaire.entrySet();
        Iterator<Map.Entry<annuaire.Personne,ListeNumTel>> it = lesEntree.iterator();
        while (it.hasNext()){
            Map.Entry<annuaire.Personne,ListeNumTel> uneEntree= it.next();
            s+= uneEntree.toString()+"\n";

            // ou si veux une mise en forme particuliere
            //annuaire.Personne p = uneEntree.getKey();
            //ListeNumTel liste = uneEntree.getValue();
            //s+= "cle :"+p+" a comme valeur :"+liste+"\n";
        }
        return s;
    }

}
