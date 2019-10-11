package exo3;

public class Main {
    public static void main(String[] args) {
        int sum = 0;
        for (String nb : args) {
            sum += Integer.parseInt(nb);
            System.out.println("nb="+nb+"sum ="+sum);
        }
        System.out.println(sum);


    }
}
