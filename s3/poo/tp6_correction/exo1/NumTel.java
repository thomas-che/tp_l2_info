package tp6.exo1;
/**
 * Repr�sente un num�ro de t�l�phone. Un numero de t�l�phone est d�fini par un
 * couple :<br>
 * <UL>
 * <LI>un entier : le num�ro de t�l�phone proprement dit.</LI>
 * <LI>une lettre qui indique le type de num�ro ( 'T' : poste fixe
 * professionnel, 'D' poste fixe domicile, 'P' : portable, 'F' :fax).</LI>
 * </UL>
 * 
 * */

public class NumTel {

	// ----------------------------------------------
	// constantes
	// ----------------------------------------------
	/**
	 * telephone fixe professionnel
	 */
	public static final char FIXE_PROF = 'T';

	/**
	 * telephone fixe domicile
	 */
	public static final char FIXE_DOM = 'D';

	/**
	 * telephone portable
	 */
	public static final char PORTABLE = 'P';

	/**
	 * fax
	 */
	public static final char FAX = 'F';

	/**
	 * nature du num�ro inconnue
	 */
	public static final char INCONNU = '?';

	// ----------------------------------------------
	// attributs (variables de classes)
	// ----------------------------------------------
	private int numero;

	private char type;

	// ----------------------------------------------
	// Constructeurs
	// ----------------------------------------------

	/**
	 * cr�e un num�ro de t�l�phone d'un type donn�.
	 * 
	 * @param num
	 *            le num�ro de t�l�phone
	 * @param type
	 *            son type (si ce type n'est pas 'T','D','P' ou 'F', la valeur
	 *            INCONNU ('?') sera associ�e � ce num�ro).
	 */
	public NumTel(int num, char type) {
		this.numero = num;
		setType(type);
	}

	/**
	 * cr�e un num�ro de t�l�phone de type inconnu
	 * 
	 * @param num
	 *            le num�ro de t�l�phone
	 */
	public NumTel(int num) {
		this(num, INCONNU);
	}

	// ----------------------------------------------
	// m�thodes
	// ----------------------------------------------

	// ---- accesseurs --------------------------------------
	/**
	 * retourne le num�ro de t�l�phone
	 * 
	 * @return le num�ro.
	 */
	public int getNumero() {
		return numero;
	}

	/**
	 * retourne le type de ce num�ro de t�l�phone
	 * 
	 * @return le type.
	 */
	public char getType() {
		return type;
	}

	// ---- modifieurs --------------------------------------
	/**
	 * change le type de ce num�ro de t�l�phone
	 * 
	 * @param type
	 *            le nouveau type pour ce num�ro. (si ce type n'est pas
	 *            'T','D','P' ou 'F', la valeur INCONNU ('?') sera associ�e � ce
	 *            num�ro).
	 */
	public void setType(char type) {
		switch (type) {
		case FIXE_PROF:
		case FIXE_DOM:
		case PORTABLE:
		case FAX:
			this.type = type;
			break;
		default:
			this.type = INCONNU;
		}
	}

	// -------------------------------------------------------
	// m�thodes h�rit�es de la classe Object et red�finies
	// -------------------------------------------------------

	/**
	 * renvoie une repr�sentation textuelle du num�ro de t�l�phone sous la forme
	 * d'une cha�ne de caract�res. Cette chaine et de la forme suivante :<br>
	 * <I>num�ro</I> <B>(</B><I>Type</I><B>)</B>).
	 * 
	 * @return la chaine correspondant au num�ro de t�l�phone et � son type
	 */
	public String toString() {
		return numero + " (" + type + ")";
	}

	/**
	 * teste l'�galit� de ce num�ro de t�l�phone avec un autre. L'�galit� porte
	 * uniquement sur le num�ro et ne tient pas compte du type.
	 * 
	 * @param o
	 *            le num�ro de t�l�phone � comparer avec ce num�ro.
	 * @return <code>false</code> si l'objet o n'est pas de type NumTel ou si
	 *         son num�ro n'est pas identique � celui de l'objet NumTel
	 *         r�cepteur du message, <code>false</code> sinon.
	 */
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o== null) return false;
	    if (o.getClass()!= this.getClass())
				return false;
		NumTel num = (NumTel) o;

		return this.numero == num.numero;
	}

	/**
	 * red�finition de la m�thode hashCode pour rester coh�rent avec la m�thode
	 * equals. deux NumTel �gaux doivent produirent le m�me hashCode. voir le
	 * javadoc de la classe Object.
	 * 
	 * @return la valeur de hashCode
	 */
	public int hashCode() {
		return numero;
	}

}// NumTel
