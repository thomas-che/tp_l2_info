package com.thomas;

/** explacation:
 *      cree une exception particuliere qui sera relever dans : checkInt(Scanner sc ) et checkIntJour(Scanner sc )
 *      ce qui permet dans le mais avec un try/catch de demander au user si il veux continuer(1)<=>recomencer saisie ou
 *      s arrter(0) et donc retourner au menu car dans le catch apres afficher 'retour menu' on fais un break et donc
 *      on arrete le switch
 */
public class ZeroToBreakSwithException extends Exception {
    public ZeroToBreakSwithException(String msg){
        super(msg);
        //System.out.println("Fin saisie, retour menu");
    }
}
