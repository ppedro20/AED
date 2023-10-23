package aed.ordenacao.utilizacao;

import aed.ComparacaoInteiros;
import aed.ordenacao.algoritmos.InsertionSort;
import aed.ordenacao.algoritmos.QuickSort;

public class MainInsertionSort {

    public static void main(String[] args) {
        InsertionSort<Integer> insertionSort = new InsertionSort<>(ComparacaoInteiros.CRITERIO);
        insertionSort.apresentar(20, 3, 7, 2, 5, 4, 1, 6, 8, 9);
    }
}