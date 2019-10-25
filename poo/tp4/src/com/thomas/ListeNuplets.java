package com.thomas;

import java.util.Scanner;

public class ListeNuplets {
    private Nuplet [] lesNuplets;
    static private class Nuplet {
        private int[] content;
        public Nuplet (int k) {
            content = new int [k];
            Scanner sc = new Scanner(System.in);
            if (sc.hasNextInt()) {
                sc.nextInt();
            }
            if (sc.hasNextDouble() ){
                sc.nextDouble();
            }
            else {
                sc.next();
            }
    }
}
