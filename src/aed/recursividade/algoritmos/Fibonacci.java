package aed.recursividade.algoritmos;

public class Fibonacci {

    public static long execute(int n) {

        if (n < 0) {
            throw new IllegalArgumentException("Fibonacci(" + n + ") is an invalid argument : should be positive");
        }
        return recursiveExecute(n);
    }

    private static long recursiveExecute(int n) {

        return n < 2 ? n : recursiveExecute(n - 2) + recursiveExecute(n - 1);
    }

    public static void show(int n) {
        try {
            System.out.println("Fibonacci(" + n + ") = " + execute(n));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
