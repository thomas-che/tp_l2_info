package exo5;


public class Main {
    public static void main(String[] args) {
        Pile p = new Pile();

        p.empiler("a");
        p.empiler("B");
        p.empiler("c");
        p.empiler("d");
        p.empiler("e");
        System.out.println(p.toString());
        System.out.println(p.afficher());




    }
}
