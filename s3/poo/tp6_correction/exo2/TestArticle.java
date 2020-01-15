/**
 * 
 */
package tp6.exo2;

import java.util.*;


/**
 * @author kahlem
 *
 */
public class TestArticle {
public static void main(String[] args) {
        
        Set<Article> ensemble = new HashSet<Article>();
        Article a1 = new Article(15, "d");
        ensemble.add(a1);
        Article a2 = new Article(5, "b");
        ensemble.add(a2);
        Article a3 = new Article(12, "a");
        ensemble.add(a3);
        Article a4 = new Article(2, "c");
        ensemble.add(a4);
     
       
     
        //test d'�limination des doublons
        Article a5 = new Article(12, "a");
        ensemble.add(a5);
        //affichage des articles non tri�s par num�ro
        System.out.println("Affichage des articles de l'ensemble -pas de tri " );
        System.out.println(ensemble);
        
        System.out.println("contient  :" +ensemble.contains(new Article (15, "d")));
       
        //On cr�e un ensemble dans lequel les �l�ments pourront �tre tri�s suivant la m�thode CompareTo
        SortedSet<Article> ensembleTrieParNumero = new TreeSet<Article>();
        ensembleTrieParNumero.addAll(ensemble);
        //affichage des articles non tri�s par num�ro
        System.out.println("Affichage des articles de l'ensemble tri�s suivant le num�ro " );
        System.out.println(ensembleTrieParNumero);
        
        ArticleComparateur comp = new ArticleComparateur();
        SortedSet<Article> ensembleTrieParDescr = new TreeSet<Article>(comp);
        ensembleTrieParDescr.addAll(ensemble);
        System.out.println("Affichage des articles de l'ensemble tri�s suivant le descriptif -cr�ation d'une classe ArtcileComparateur " );
        System.out.println(ensembleTrieParDescr);
        
          //utlisation d'une classe interne anonyme 
        //implantant l'interface Comparator pour fournir une comparaison des articles
        //par leur descriptif
    
      SortedSet<Article> ensembleTrieParDescrBis = new TreeSet<Article>(new Comparator<Article>(){
                public int compare(Article a, Article b){
                    String descrA= a.getDescriptif();
                    String descrB= b.getDescriptif();
                    return descrA.compareTo(descrB);
                }
            });
         ensembleTrieParDescrBis.addAll(ensemble);
         System.out.println("Affichage des articles de l'ensemble tri�s suivant le descriptif -cr�ation d'une classe interne anonyme " );
        System.out.println(ensembleTrieParDescrBis);
    }
    
}
