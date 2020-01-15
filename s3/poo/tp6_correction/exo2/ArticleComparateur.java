/*
 * ArticleComparateur.java
 *
 * Created on 27 novembre 2006, 22:34
 */

package tp6.exo2;

import java.util.Comparator;

/**
 *
 * @author  lkahlem
 */
public class ArticleComparateur implements Comparator<Article>{
    
    /** Creates a new instance of ArticleComparateur */
   public int compare(Article a, Article b){
       
        String descrA= a.getDescriptif();
         String descrB= b.getDescriptif();
         return descrA.compareTo(descrB);
   }
}
