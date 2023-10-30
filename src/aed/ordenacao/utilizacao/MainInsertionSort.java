package aed.ordenacao.utilizacao;

import aed.ComparacaoInteiros;
import aed.ordenacao.algoritmos.InsertionSort;

public class MainInsertionSort {

    public static void main(String[] args) {
        InsertionSort<Integer> insertionSort = new InsertionSort<>(ComparacaoInteiros.CRITERIO);
        insertionSort.apresentar(20, 9,3,2,7,4,1,8,5,6);
    }
}