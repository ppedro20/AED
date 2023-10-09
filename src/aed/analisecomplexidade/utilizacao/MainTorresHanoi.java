package aed.analisecomplexidade.utilizacao;

import aed.analisecomplexidade.algoritmos.TorresHanoi;

public class MainTorresHanoi {

    public static void main(String[] args) {

        //n - num de discos
        //tg - torre origem
        //ta - torre auxiliar
        //td - torre destino

        int [] numDiscos = {3,0,4,5};

        for (int n : numDiscos) {
            TorresHanoi.show(n);
        }

    }
}