package aed.pesquisa.utilizacao;

import aed.ComparacaoInteiros;
import aed.ordenacao.algoritmos.QuickSort;
import aed.pesquisa.algoritmos.AlgoritmoPesquisa;
import aed.pesquisa.algoritmos.PesquisaTernariaIterativa;
import aed.pesquisa.algoritmos.PesquisaTernariaRecursiva;
import aed.utils.VetorDeInteiros;

import java.util.Random;

public class MainPraticaPesquisaTernaria {
    public static void main(String[] args) {
       PesquisaTernariaRecursiva<Integer> pesquisaTernariaRecursiva = new PesquisaTernariaRecursiva<>(ComparacaoInteiros.CRITERIO);
       PesquisaTernariaIterativa<Integer> pesquisaTernariaIterativa = new PesquisaTernariaIterativa<>(ComparacaoInteiros.CRITERIO);

       Integer[] elementos = {1,3,5,6,8,8,9,11,13,15,17,20,22,23,25,26,27,30,32,33,36,38,42,45,48,50,55,57,60,61,64,66,70};
       pesquisaTernariaRecursiva.apresentar(40,30,elementos);
       pesquisaTernariaIterativa.apresentar(40,11,elementos);

    }
}
