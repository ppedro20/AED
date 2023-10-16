package aed.analisecomplexidade.utilizacao;


import aed.analisecomplexidade.algoritmos.PontosMaisProximos;
import aed.utils.Par;
import aed.utils.VetorDePoint2D;

public class MainPontosMaisProximos {
    public static void main(String[] args) {

        PontosMaisProximos pontosMaisProximos = new PontosMaisProximos();

        int[] p = {1,5,10};

        for (int i : p)
            pontosMaisProximos.show(VetorDePoint2D.criarAleatorio(i));

    }
}

