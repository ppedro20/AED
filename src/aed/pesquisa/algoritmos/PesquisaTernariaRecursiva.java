package aed.pesquisa.algoritmos;

import aed.Comparacao;

public class PesquisaTernariaRecursiva<T> extends AlgoritmoPesquisa<T> {

    public PesquisaTernariaRecursiva(Comparacao<T> criterio) {
        super(criterio);
    }

    @Override
    public int pesquisar(T elemento, T... elementos) {
        if (elementos.length == 0 || criterio.comparar(elemento, elementos[0]) < 0 || criterio.comparar(elemento, elementos[elementos.length - 1]) > 0)
            return NAO_ENCONTRADO;
        return pesquisarRecursivo(elemento, 0, elementos.length - 1, elementos);
    }

    private int pesquisarRecursivo(T elemento, int ESQ, int DIR, T... elementos){
        if(DIR < ESQ)
            return NAO_ENCONTRADO;

        int terco = (DIR-ESQ)/3;
        int t1 = terco;

        //comparar elemento com t1
        int comp = criterio.comparar(elemento,elementos[t1]);

        //elemento é menor que t1
        if(comp < 0)
            return pesquisarRecursivo(elemento,ESQ,t1-1,elementos);

        //elemento é maior que t1
        if(comp > 0){
            int t2 = t1+terco;
            comp = criterio.comparar(elemento,elementos[t2]);

            //elemento menor que t2
            if(comp < 0)
                return pesquisarRecursivo(elemento,t1+1,t2-1,elementos);

            //elemento maior que t2
            if(comp > 0)
                return pesquisarRecursivo(elemento,t2+1,DIR,elementos);
            return t2;
        }
        return t1;
    }
}
