/*
 * ListeNumTel.java
 *
 * Created on 22 juillet 2007, 17:36
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

/**
 *
 * @author lkahlem
 */
package tp6.exo1;
import java.util.*;

public class ListeNumTel {
     private List<NumTel> lesTels;
    /** Creates a new instance of ListeNumTel */
    public ListeNumTel(NumTel num) {
       lesTels = new ArrayList<NumTel>();
       lesTels.add(num);
    }
	 
	public boolean ajouter(int index, NumTel num) {
    	boolean ajoute = false;
        if (!lesTels.contains(num)){
           lesTels.add(index,num);
           ajoute = true;
        }
        return ajoute;
    }

    public boolean ajouterFin(NumTel num) {
    	boolean ajoute = false;
        if (!lesTels.contains(num))
		
            ajoute= lesTels.add(num);
    	return ajoute;
    }



    public boolean ajouterDebut(NumTel num) {
        return ajouter(0,num);
    }

 
    public NumTel premierNumero() {
        return lesTels.get(0);
    }

    public NumTel numero(int index) {
	 if (index < 0 || index >= lesTels.size())
		throw new IndexOutOfBoundsException ("Dépassement de taille");
     return lesTels.get(index);
    }

    public boolean contientNumero(int num) {
        NumTel numeroRecherche = new NumTel(num);
        return lesTels.contains(numeroRecherche);
    }

    public int nbNumeros() {
        return lesTels.size();
    }

    public Iterator<NumTel> iterator() {
        return lesTels.iterator();
    }

    public boolean retirer(int num) {
    	boolean retrait = false;
        if (lesTels.size()>=2) {
        	NumTel numARetirer= new NumTel(num);
        	retrait = lesTels.remove(numARetirer);
        }
        return retrait;     
    }
    public String toString(){
       //return lesTels.toString();
	   String s ="";
	   /*for (NumTel n : lesTels) {
			s += n.toString() + " ";
	   }*/
	   Iterator<NumTel> it = lesTels.iterator();
	   while ( it.hasNext()){
			s+= it.next() + " ";
	   }
	   
	   return s;
    }
    
}
