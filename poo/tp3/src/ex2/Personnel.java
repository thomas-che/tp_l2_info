package ex2;

import java.time.LocalDate;

public class Personnel {
    private Employe [] tabEmploye = new Employe[1000];
    private Employe [] ancienTabEmploye;
    private int nbEmploye =0;

    public void calcNbEmploye () {
        int i= 0;
        for(Employe e : tabEmploye) {
            if (e == null) {
                this.nbEmploye = i;
            } else {
                i++;
            }
        }
    }

    public Employe rechercherEmploye (int matricule) {
        for(int i = 0; i < nbEmploye; i++){  //pb cat null.getMatrucule1() n exiqte pas donc faire un for avec un i
            if (tabEmploye[i].getMatricule1() == matricule){
                return tabEmploye[i];
            }
        }
        return null;
    }

    public boolean ajouterEmploye (Employe e) {
        if (rechercherEmploye(e.getMatricule1()) == null) {
            if (nbEmploye < tabEmploye.length) {
                tabEmploye[nbEmploye]=e;
                nbEmploye++;
                return true;
            } else {
                ancienTabEmploye = tabEmploye;
                Employe[] tabEmploye = new Employe[ancienTabEmploye.length * 2];
                for (int i = 0; i <= ancienTabEmploye.length; i++) {
                    tabEmploye[i] = ancienTabEmploye[i];
                }
                tabEmploye[nbEmploye]=e;
                nbEmploye++;
                return true;
            }
        }   // peux utiliser: tabEmploye = Arrays.copyOf(tabEmployer,tabEmployer.lenght*2)
            // pour copier le tableau
        else {
            return false;
        }
    }

    public double montantSalairesBrutsMensuels() {
        double ttsalaire = 0.0;
        for (int i = 0; i < nbEmploye; i++){
            ttsalaire+=tabEmploye[i].calculerSalaireBrutMensuel();
        }
        return ttsalaire;
    }

    @Override
    public String toString() {
        String str="debut: \n";
        for(int i = 0; i < nbEmploye; i++){  //pb cat null.getMatrucule1() n exiqte pas donc faire un for avec un i
            str+=tabEmploye[i].toString()+"\n";
        }
        return str+" \n fin";
    }
}
