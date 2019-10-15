package exo5;

import java.util.MissingFormatArgumentException;

public class Pile {
    private Maillon sommet;


    public void empiler (String s) {
        sommet = new Maillon (s,sommet);  // prof


    }

    public String depiler () {
       // Maillon m = getSommet();
        String valeur=sommet.valeur; // prof
        sommet = sommet.suivant;// prof corection : sommet.suivant
        return valeur; //prof
    }

    public Maillon getSommet (){
        return sommet;
    }

    public boolean estVide () {
        Maillon som = getSommet();
        if (som == null) {
            return false;
        } else {
            return true;
        }
    }

    public String afficher () {
        String str = new String();
        Maillon m =getSommet();
        str+="sommet :"+sommet+" m.valeur = "+m.valeur+" m.suivant = "+m.suivant;
        while (m.suivant != null) {
                str+="sommet :"+sommet+" m.valeur = "+m.valeur+" m.suivant = "+m.suivant;
                depiler();
        }
        return str;


    }





}
