package aed.recursividade.algoritmos;

public class Fatorial {
    public static double execute(int n) {

        if (n < 0) {
            throw new IllegalArgumentException("Fatorial(" + n + ") is an invalid argument : should be positive");
        }
        return recursiveExecute(n);
    }

    private static double recursiveExecute(int n) {
        return n < 2 ? 1 : n * recursiveExecute(n - 1);
    }

    public static void show(int n){
        try {
            System.out.println("Fatorial(" + n + ") = " + execute(n));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
