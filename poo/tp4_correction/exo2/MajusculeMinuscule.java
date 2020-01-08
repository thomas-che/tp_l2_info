/**
 * 
 */
package tp4.exo2;

import java.util.Scanner;

/**
 * @author kahlem
 *
 */
public class MajusculeMinuscule {
	  public static void main(String[] args) {
		  String[] lesMots = {"Bonjour", "HIER","Aujourd'hui"};
		
		EnsTransformable ens = new EnsTransformable(lesMots);
		Scanner sc = new Scanner (System.in);
		System.out.println("Type de transformation : a (majuscule) ou i(minuscule)");
		String mot=sc.next();
		if (mot.equals("a")){
				  ens.transformer(new Transformation() {
		                public Object transforme(Object o) {
		                	  String x = (String) o;
			                    return x.toUpperCase();
			                    }
		                });
				  System.out.println("Transformation en majuscule " + ens);
			  }
		else  if (mot.equals("i")){
				  ens.transformer(new Transformation() {
		                public Object transforme(Object o) {
		                	  String x = (String) o;
			                    return x.toLowerCase();
		                }
		            });
				  System.out.println("Transformation en minuscule " + ens);
			  }
		  sc.close();
		  }
	
		  
}

