package exo2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // pr avoir le msg de l assertion : // Run > Edit configuration ... > VM option > -ea

        String str = "";
        Scanner sc = new Scanner(System.in);

        //while  ( !(str =="q") ) { moi
        while  ( !(str.equals("q")) && !(str.equals("Q")) ) {  // correction prof : str.equals("Q")
            System.out.println("saisie un nb positif ou null OU q/Q pour quiter");
            if (sc.hasNextInt()) {
                int n = sc.nextInt();
                if (0<=n) {
                    System.out.println("le factorielle de "+n+" est : "+ Facto.factorielle(n) );
                }
                else {
                    System.out.println("Vous vous etes tromper : n doit etre positif ou nul, Recommencer !");
                }
            }
            else {
                str=sc.next();
            }
        }
    }
}
