package com.thomas;

import java.util.Arrays;
import java.util.Scanner;

public class ListeNuplets {

    static class Nuplet implements Comparable<Nuplet> {
        private int[] content;

        public Nuplet(int k) {
            content = new int[k];
            Scanner sc = new Scanner(System.in);
            for (int i = 0; i < content.length; i++) {
                int j = -1;
                // prof utilise le do while
                do {
                    System.out.println("entrer un entier");
                    if (sc.hasNextInt()) {
                        j = sc.nextInt();
                        content[i] = j;

                    }
                    //if (sc.hasNextDouble() ){
                    //    sc.nextDouble();
                    //}
                    else {
                        System.out.println("vous n avez pas enter un entier");
                        sc.next();
                    }
                } while (j < 0);
            }

        }

        @Override
        public String toString() {
            return "Nuplet{" +
                    "content=" + Arrays.toString(content) +
                    '}';
        }

        public int nbElements() {
            return content.length;
        }

        public int getElement(int index) {
            if (index < nbElements() && 0 < index) {
                return content[index];
            } else {
                return -1;
            }
        }

        //ne fonctionne pas
        @Override
        public int compareTo(Nuplet nuplet) {
            int i=0;
            /*while  (i<this.content.length || i< nuplet.length ){
                if ( this.content[i] < nuplet[i] ) {
                    return 1;
                }
                else if ( nuplet[i] < this.content[i] ) {
                    return -1;
                }
                i++;
            }*/
            return 0;
        }
    }

    private Nuplet [] lesNuplets;
    public ListeNuplets (int...lesTailles) {

        lesNuplets = new  Nuplet [lesTailles.length] ;
        for (int i : lesTailles) {
            lesNuplets[i] = new Nuplet ( lesTailles[i] );
        }

    }

    // genere automatiquement
    @Override
    public String toString() {
        return "ListeNuplets{" +
                "lesNuplets=" + Arrays.toString(lesNuplets) +
                '}';
    }

    public Nuplet getNuplet (int index){
        if (index < lesNuplets.length && 0<index) {
            return lesNuplets[index];
        }
        return null;

    }

    public void trier() {
        Arrays.sort(lesNuplets);
    }



}
