package aed.recursividade.utilizacao;

import aed.recursividade.algoritmos.Fatorial;

public class MainPraticaFatorial {

    public static void main(String[] args) {

        //Fatorial.show(5);
        //Fatorial.show(0);
        //Fatorial.show(-5);
        //Fatorial.show(21);

        int[] ns = {5,0,-5,21};

        for (int n : ns) {
            Fatorial.show(n);
        }

    }
}
