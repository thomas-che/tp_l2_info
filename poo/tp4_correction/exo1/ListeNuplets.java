/**
 * 
 */
package tp4.exo1;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author utilisateur
 *
 */
public class ListeNuplets {
	private Nuplet[] lesTuples;
	/**
	 * 
	 */

	public ListeNuplets(int...lesTailles) {
		lesTuples = new Nuplet[lesTailles.length];
		for (int i = 0; i < lesTuples.length; i++)
			lesTuples[i] = new Nuplet(lesTailles[i]);
	}



	
	
	
	
	public void trier (){

		Arrays.sort(lesTuples);
	}
	
	
	
	
	
	public String toString(){

		return Arrays.toString(lesTuples);
	}
	public Nuplet getNuplet (int index){
		if ( index >=0 && index < lesTuples.length)
			return lesTuples[index];
		else 
			return null;
	}
	
	static class Nuplet implements Comparable<Nuplet>{
		private int[] content;

			public Nuplet(int k) {
				Scanner sc = new Scanner (System.in);
				content = new int[k];
				for (int i = 0; i<content.length;i++){
					int entier=-1;
					do{
						System.out.println("Saisir un entier :");
						if ( sc.hasNextInt()){
							entier = sc.nextInt();
							content[i]=entier;
						}
						else 
						sc.next();
					}while (entier<0);
				}
				
			}
			public int getElement(int index){
				if ( index >=0 && index < content.length)
					return content[index];
				else 
					return -1;
			}
			public int nbElements(){
				return  content.length;
			}

			public String toString(){
				String s = "( ";
				for (int i = 0; i<content.length-1;i++){
					s += content[i] +", ";
				}
				s += content[content.length-1]+" ";
				return s+")";
			}
	

			/* (non-Javadoc)
			 * @see java.lang.Comparable#compareTo(java.lang.Object)
			 */
			@Override
			public int compareTo(Nuplet n) {
				int [] contenu = n.content;
				int i=0;
				while (i<content.length && i<contenu.length){
					if (content[i]<contenu[i])
						return -1;
					else {
						if ( content[i]>contenu[i])
						return 1;
						else {
							i++;
						}
							
					}
				}
				if (content.length == contenu.length)
					return 0;
				else if (i<content.length)
						return 1;
					else 
						return -1;
				
			}
			
		}


}
