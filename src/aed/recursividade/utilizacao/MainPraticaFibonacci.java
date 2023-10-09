package aed.recursividade.utilizacao;

import aed.recursividade.algoritmos.Fibonacci;

public class MainPraticaFibonacci {

    public static void main(String[] args) {

        int[] ns = {5, 0, -10, 40, 45};

        for (int n : ns) {
            Fibonacci.show(n);
        }

        for (int n = 5; n < 21; n += 3) {
            Fibonacci.show(n);
        }
    }
}
