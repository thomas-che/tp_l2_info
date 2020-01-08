package com.thomas;

import java.util.*;

public class Spectacle {
    protected int numero;
    protected String titre;


    private Set<String> interprete;


    public Spectacle (String titre){
        this.titre=titre;
        interprete = new TreeSet<>();
    }


    public void ajouterInterprete (String nomInterprete){
        interprete.add(nomInterprete);
    }


/** ----GET------ */
    public String getTitre() {
        return titre;
    }
    public int getNumero() {
        return numero;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Spectacle spectacle = (Spectacle) o;
        return numero == spectacle.numero &&
                Objects.equals(titre, spectacle.titre) &&
                Objects.equals(interprete, spectacle.interprete);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numero, titre, interprete);
    }

    @Override
    public String toString() {
        return "\nSpectacle{" +
                "numero=" + numero +
                ", titre='" + titre + '\'' +
                ", interprete=" + interprete +
                '}';
    }
}
