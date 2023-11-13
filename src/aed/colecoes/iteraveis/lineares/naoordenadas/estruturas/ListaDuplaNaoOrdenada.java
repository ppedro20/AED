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
        return null;
    }

    @Override
    public T removerPorReferencia(T elem) {
        return null;
    }

    @Override
    public T removerPorIndice(int indice) {
        return null;
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

    }

    @Override
    public void inserirNoFim(T elem) {
        new No(elem,base);
        numElems++;
    }

    @Override
    public void inserirPorIndice(int indice, T elem) {

    }

    @Override
    public T removerDoInicio() {
        return null;
    }

    @Override
    public T removerDoFim() {
        return null;
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
        public No(T elem, No seg){
            elemento = elem;                            //2
            anterior = seg.anterior;                    //3
            seguinte = seg;                             //4
            seg.anterior = anterior.seguinte = this;    //5 & 6
        }

    }
}
