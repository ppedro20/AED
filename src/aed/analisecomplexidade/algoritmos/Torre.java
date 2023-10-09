package aed.analisecomplexidade.algoritmos;

import java.util.LinkedList;
import java.util.NoSuchElementException;

public class Torre {
    private char nome;
    private int[] baseeDiscos;
    private int numDiscos;

    public Torre(char nome, int numMaxDiscos) {
        this.nome = nome;
        baseeDiscos = new int[numMaxDiscos + 1];
        numDiscos = 0;
        baseeDiscos[0] = 3 * numMaxDiscos;
    }

    public void preencherComDiscos() {
        int length = baseeDiscos.length;
        for (int i = 1; i < length; i++)
            baseeDiscos[i] = length - i;
        numDiscos = length - 1;
    }
    public void moverDisco(Torre tD){
        if(numDiscos==0){
            throw new NoSuchElementException("Torre de Origem Vazia");
        }
        if (tD.numDiscos == tD.baseeDiscos.length-1) {
            throw new ArrayIndexOutOfBoundsException("Torre de Destino Cheia");
        }
        if (baseeDiscos[numDiscos]>= tD.baseeDiscos[tD.numDiscos]) {
            throw new IllegalArgumentException("Disco a mover é superior ao disco do topo da torre de Destino");
        }

        tD.baseeDiscos[++tD.numDiscos] = baseeDiscos[numDiscos];
        baseeDiscos[numDiscos--] = 0;

    }

}
