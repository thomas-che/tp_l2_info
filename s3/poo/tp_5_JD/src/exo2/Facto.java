package exo2;

public class Facto {

    private static long factRec (int n) {
        assert 0<=n : "n :"+ n+ " est negatif...";

        if (n==0) {
            return 1;
        }
        else {
            return n*factRec(n-1);
        }
    }

    // generer doc : tool > generate JavaDoc

    /**
     * @return le factorielle de n
     * @param n doit etre : positif ou nul
     * @throws IllegalArgumentException exception lever si le parametre est negatif
     */
    public static long factorielle (int n) {
        if (0<=n)
            return factRec(n);
        else
            throw new IllegalArgumentException("nb doit etre : positif ou nul");
    }

}
