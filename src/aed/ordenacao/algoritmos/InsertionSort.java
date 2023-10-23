package aed.ordenacao.algoritmos;

import aed.Comparacao;

public class InsertionSort<T> extends AlgoritmoOrdenacao<T> {
    public InsertionSort(Comparacao criterio) {
        super(criterio);
    }

    @Override
    public void ordenar(T... elementos) {
        for (int i = 1; i < elementos.length; i++) {
            T atual = elementos[i];

            int j = i - 1;

            do {
                if (criterio.comparar(atual, elementos[j]) >= 0) break;

                elementos[j + 1] = elementos[j];

                j--;
            }
            while (j >= 0);

            elementos[j + 1] = atual;
        }
    }
}
