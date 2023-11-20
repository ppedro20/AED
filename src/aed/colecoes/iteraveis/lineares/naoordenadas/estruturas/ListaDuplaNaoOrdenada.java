package aed.colecoes.iteraveis.lineares.naoordenadas.estruturas;

import aed.colecoes.iteraveis.IteradorIteravel;
import aed.colecoes.iteraveis.lineares.naoordenadas.ColecaoIteravelLinearNaoOrdenada;


public class ListaDuplaNaoOrdenada<T> implements ColecaoIteravelLinearNaoOrdenada<T> {

    private No base;
    private int numElems;

    public ListaDuplaNaoOrdenada() {
        base = new No();
        numElems = 0;
    }

    @Override
    public IteradorIteravel<T> iterador() {
        return null;
    }

    @Override
    public int getNumeroElementos() {
        return 0;
    }

    @Override
    public T remover(T elem) {
        return numElems == 0 ? null : removerNo(getNo(elem));
    }

    private No getNo(T elem) {
        No cor = base.seguinte;
        while (cor != base && !cor.elemento.equals(elem)) {
            cor = cor.seguinte;
        }
        return cor;
    }

    @Override
    public T removerPorReferencia(T elem) {
        No no = getNoPorReferencia(elem);
        return no == base ? null : removerNo(no);
    }

    private No getNoPorReferencia(T elem) {
        No cor = base.seguinte;
        while (cor != base && cor.elemento != elem) {
            cor = cor.seguinte;
        }
        return cor;
    }

    @Override
    public T removerPorIndice(int indice) {
        return removerNo(getNoPorIndice(indice));
    }

    @Override
    public T consultarPorIndice(int indice) {
        return null;

    }

    @Override
    public boolean contem(T elem) {
        return false;
    }

    @Override
    public boolean contemReferencia(T elem) {
        return false;
    }

    @Override
    public void inserirNoInicio(T elem) {
        new No(elem, base.seguinte);
        numElems++;
    }

    @Override
    public void inserirNoFim(T elem) {
        new No(elem, base);
        numElems++;
    }

    @Override
    public void inserirPorIndice(int indice, T elem) {
        new No(elem, getNoPorIndice(indice));
        numElems++;

    }

    private No getNoPorIndice(int indice) {
        if (indice < 0 || indice >= numElems) {
            throw new IndexOutOfBoundsException();
        }

        No cor;
        if (indice < numElems / 2) {
            cor = base.seguinte;
            while (indice-- > 0) {
                cor = cor.seguinte;
            }
        } else {
            cor = base.anterior;
            while (++indice < numElems) {
                cor = cor.anterior;
            }
        }

        return cor;
    }

    public T removerNo(No no) {
        no.seguinte.anterior = no.seguinte;
        no.anterior.seguinte = no.anterior;
        numElems--;

        return no.elemento;
    }

    @Override
    public T removerDoInicio() {
        return numElems == 0 ? null : removerNo(base.seguinte);
    }

    @Override
    public T removerDoFim() {
        return numElems == 0 ? null : removerNo(base.anterior);
    }

    public class No {
        private T elemento;
        private No seguinte;
        private No anterior;

        //criacao de no base
        public No() {
            elemento = null;
            seguinte = anterior = this;
        }

        // inserir elemento ELEM antes do no SEG
        public No(T elem, No seg) {
            elemento = elem;                            //2
            anterior = seg.anterior;                    //3
            seguinte = seg;                             //4
            seg.anterior = anterior.seguinte = this;    //5 & 6
        }

    }
}
