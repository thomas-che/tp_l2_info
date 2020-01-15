package tp6.exo1;
/*
 * Annuaire.java
 *
 * Created on 23 juillet 2007, 21:49
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
import java.util.*;
/**
 *
 * @author lkahlem
 */
public class Annuaire {
    Map<Personne, ListeNumTel> annuaire;
    
    /** Creates a new instance of Annuaire */
    public Annuaire() {
        annuaire = new HashMap<Personne, ListeNumTel>();
    }
    
    public boolean ajouterEntree(Personne p, ListeNumTel nums) {
        if ( annuaire.putIfAbsent(p,nums)==null){  
            return true;
        }
        return false;
    }

	 public ListeNumTel numeros(Personne p) {
    	return annuaire.get(p);
    }
	
	 public Iterator<Personne> personnes() {
        Set<Personne> pers = annuaire.keySet();
        return pers.iterator();
    }
	
    public void ajouterNumeroFin(Personne p, NumTel n) {
    	ListeNumTel listeNum =numeros(p);
        if (listeNum!= null){
            listeNum.ajouterFin(n);
        }
        else {    
            listeNum = new ListeNumTel(n);
            annuaire.put(p,listeNum);
        }
		
		/*
		ListeNumTel listeNum =annuaire.putIfAbsent(p, new ListeNumTel(n));
		if (listeNum!=null)
			listeNum.ajouterFin(n)
		*/
    }

    public void ajouterNumeroDebut(Personne p, NumTel n) {
         ListeNumTel listeNum=numeros(p);
        if (listeNum!= null){
            listeNum.ajouterDebut(n);
        }
        else {    
            listeNum = new ListeNumTel(n);
            annuaire.put(p,listeNum);
        }
    }

    public NumTel premierNumero(Personne p) {
    	NumTel num= null;
       ListeNumTel listeNum=numeros(p);
       if (listeNum!= null){
            num= listeNum.premierNumero();
        }
        return num;
    }

   

   

    public String toString() {
    	String s = "";
        Set<Map.Entry<Personne, ListeNumTel>> lesEntrees= annuaire.entrySet();
        Iterator<Map.Entry<Personne, ListeNumTel>> it = lesEntrees.iterator();
        while (it.hasNext()){
            Map.Entry<Personne, ListeNumTel> uneEntree = it.next();
            s = s+uneEntree.toString()+ "\n";
            //Personne p = uneEntree.getKey();
            //IListeNumTel liste =  uneEntree.getValue();
            //s = s + p + " " + liste + "\n";
        }
        //return annuaire.toString();
        return s;
    }

    public void supprimer(Personne p) {
        annuaire.remove(p);
    }

    public void supprimer(Personne p, int n) {
          ListeNumTel listeNum=numeros(p);
          if (listeNum!= null){
			if(listeNum.nbNumeros()==1) 
					supprimer(p);
			else
				listeNum.retirer(n);
          }
           
    }
    /** 
    *  donne l'annuaire de toutes les personnes de l'annuaire dont le nom 
    *  est une chaîne donnée.
    *  @param s1 la chaine pour la recherche
    *  @return l'annuaire des personnes de l'annuaire dont le nom est s1
    */
    public Set<Personne> entreesPourChaine(String s1){
        Set<Personne> lesPersonnes = new HashSet<Personne>();
        Iterator<Personne> it = personnes();
        while (it.hasNext()){
            Personne suivant = it.next();
            if (suivant.getNom().equalsIgnoreCase(s1))
                lesPersonnes.add(suivant);
        }
        return lesPersonnes;
    }
        
        
    
    public static void main(String[] args) {

    // crée un annuaire vide
    Annuaire an = new Annuaire();
    
    // ajoute deux personnes à l'annuaire
    Personne p1 = new  Personne(Personne.MLLE,"DURAND","Sophie");
    an.ajouterEntree(p1,new ListeNumTel(new NumTel(151171,'D')));
    an.ajouterEntree(new Personne(Personne.MR,"DUPONT","Jean"),
                             new ListeNumTel(new NumTel(151170,'P')));
    an.ajouterEntree(new Personne(Personne.MR,"DUPAIN", "Luc"), new ListeNumTel(new NumTel(122761,'D'))); 
    an.ajouterEntree(new Personne(Personne.MR,"DUPAIN", "Louis"), new ListeNumTel(new NumTel(146761,'P'))); 
    an.ajouterEntree(new Personne(Personne.MR,"ALBAN", "Robert"), new ListeNumTel(new NumTel(140361,'P')));

    // imprime l'annuaire
    System.out.println("-----------annuaire-----------");
    System.out.println(an);
    System.out.println("------------------------------");
    
    // Recherche des numéros de Sophie DURAND
    System.out.println("numeros de " + p1);
    System.out.println(an.numeros(p1));

    // Recherche des numéros de Jean DUPONT
    Personne p2 = new Personne(Personne.MR,"DUPONT","Jean");
    System.out.println("numeros de " + p2);
    System.out.println(an.numeros(p2));
    
    an.ajouterNumeroFin(p1, new NumTel(02344343,'D'));
     an.ajouterNumeroDebut(p1, new NumTel(1111,'?'));
   
     System.out.println("numeros de " + p1);
    System.out.println(an.numeros(p1));
    
    System.out.println("Les personnes de l'annuaire : ");
    Iterator<Personne> it = an.personnes();
    while (it.hasNext())
        System.out.println(it.next());
    
    
    //recherche DUPAIN
    Set<Personne> lesDuPAin = an.entreesPourChaine("DUPAIN");
    it =lesDuPAin.iterator();
    System.out.println("les DUPAIN");
    while (it.hasNext()){
        Personne p= it.next();
        System.out.println(p + " "+an.numeros(p));
    }
     
  }
 
}
