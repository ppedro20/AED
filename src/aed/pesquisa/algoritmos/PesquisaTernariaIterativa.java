package aed.pesquisa.algoritmos;

import aed.Comparacao;

public class PesquisaTernariaIterativa<T> extends AlgoritmoPesquisa<T> {

    public PesquisaTernariaIterativa(Comparacao<T> criterio) {
        super(criterio);
    }

    @Override
    public int pesquisar(T elemento, T... elementos) {
        if (elementos.length == 0 || criterio.comparar(elemento, elementos[0]) < 0 || criterio.comparar(elemento, elementos[elementos.length - 1]) > 0)
            return NAO_ENCONTRADO;
        return pesquisarIterativo(elemento, 0, elementos.length - 1, elementos);
    }

    private int pesquisarIterativo(T elemento, int esq, int dir, T... elementos) {

        while (dir >= esq) {

            int terco = (dir - esq) / 3;
            int t1 = esq + terco;
            int t2 = dir - terco;

            int comp = criterio.comparar(elemento, elementos[t1]);

            //elem menor que t1
            if (comp < 0) {
                dir = t1 - 1;
                continue;
            }

            //elem maior que t1
            if(comp > 0){
                esq = t1+1;

                comp = criterio.comparar(elemento,elementos[t1]);
                //elem menor que t2
                if(comp < 0){
                    dir = t2-1;
                    continue;
                }
                //elem maior que t2
                if(comp > 0){
                    esq = t2+1;
                    continue;
                }
                continue;
            }

            esq++;
        }
        return NAO_ENCONTRADO;
    }
}
