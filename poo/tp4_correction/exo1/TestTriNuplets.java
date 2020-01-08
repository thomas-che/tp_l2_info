/**
 * 
 */
package tp4.exo1;

/**
 * @author utilisateur
 *
 */
public class TestTriNuplets {
	public static void main(String[] args) {
		/*
		ListeNuplets l = new ListeNuplets(3,3);

		System.out.println(l);
		l.trier();
		System.out.println(l);
		ListeNuplets.Nuplet n = l.getNuplet(2);
		
		System.out.println(n.nbElements());
		for ( int i = 0 ; i<n.nbElements(); i++)
			System.out.println(n.getElement(i));
		*/
		ListeNuplets l1 = new ListeNuplets(3,3,4,2);
		System.out.println(l1);
		l1.trier();
		System.out.println(l1);

	}
	
}
