package aed.pesquisa.utilizacao;

import aed.ComparacaoInteiros;
import aed.ordenacao.algoritmos.QuickSort;
import aed.pesquisa.algoritmos.AlgoritmoPesquisa;
import aed.pesquisa.algoritmos.PesquisaTernariaRecursiva;
import aed.utils.VetorDeInteiros;

import java.util.Random;

public class MainPraticaPesquisaTernaria {
    public static void main(String[] args) {
        AlgoritmoPesquisa<Integer> pesquisaTernariaRecursiva =
                new PesquisaTernariaRecursiva<>(ComparacaoInteiros.CRITERIO);

        Integer[] elementos = VetorDeInteiros.criarAleatorioInteger(20, -10, 10, false);
        new QuickSort<>(ComparacaoInteiros.CRITERIO).apresentar(20,elementos);

        //obter um elemento random de 0-20
        int elemento = new Random(1).nextInt(21) - 10;
        pesquisaTernariaRecursiva.apresentar(1,elemento,elementos);
    }
}
