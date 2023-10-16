package aed.analisecomplexidade.utilizacao;

import aed.analisecomplexidade.algoritmos.Maximo;
import aed.utils.VetorDeInteiros;

public class MainMaximo {

    public static void main(String[] args) {

        Maximo maximo = new Maximo();
        //ex 2.b
        maximo.show(1, -2, 5, 7, 4, 3, 2);

        //ex 2.c
        maximo.show(VetorDeInteiros.criarAleatorioInt(5, -50, 50, true));

    }
}
