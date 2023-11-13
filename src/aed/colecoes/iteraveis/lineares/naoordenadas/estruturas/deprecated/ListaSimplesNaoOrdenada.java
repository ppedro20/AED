package aed.colecoes.iteraveis.lineares.naoordenadas.estruturas.deprecated;

import aed.colecoes.iteraveis.ColecaoIteravel;
import aed.colecoes.iteraveis.IteradorIteravel;
import aed.colecoes.iteraveis.lineares.naoordenadas.ColecaoIteravelLinearNaoOrdenada;

import java.io.Serializable;
import java.util.NoSuchElementException;

/**
 * @author Actual code:
 * Carlos Urbano<carlos.urbano@ipleiria.pt>
 * Catarina Reis<catarina.reis@ipleiria.pt>
 * Marco Ferreira<marco.ferreira@ipleiria.pt>
 * João Ramos<joao.f.ramos@ipleiria.pt>
 * Original code: José Magno<jose.magno@ipleiria.pt>
 */
@Deprecated

public class ListaSimplesNaoOrdenada<T> implements ColecaoIteravelLinearNaoOrdenada<T> {
    private static final long serialVersionUID = 1L;

    protected No noInicial;
    protected No noFinal;
    protected int numeroElementos;

    public ListaSimplesNaoOrdenada() {
        noFinal = noInicial = null;
        numeroElementos = 0;
    }

    public ListaSimplesNaoOrdenada(ColecaoIteravel<T> colecaoIteravel) {
        this();

        IteradorIteravel<T> iterador = colecaoIteravel.iterador();
        if (iterador.podeAvancar()) {
            noInicial = noFinal = new No(iterador.avancar());
        }
        while (iterador.podeAvancar()) {
            noFinal = new No(iterador.avancar(), noFinal);
        }

        numeroElementos = colecaoIteravel.getNumeroElementos();
    }

    protected No getNoAnterior(T elem) {
        if (noInicial == null || noInicial.elemento.equals(elem)) {
            return null;
        }

        No ant = noInicial;
        while (ant.seguinte != null && !ant.seguinte.elemento.equals(elem)) {
            ant = ant.seguinte;
        }

        return ant;
    }

    protected No getNoAnteriorPorReferencia(T elem) {
        if (noInicial == null || noInicial.elemento == elem) {
            return null;
        }

        No ant = noInicial;
        while (ant.seguinte != null && ant.seguinte.elemento != elem) {
            ant = ant.seguinte;
        }

        return ant;
    }

    protected No getNoAnteriorPorIndice(int indice) {
        if (indice < 0 || indice >= numeroElementos) {
            throw new IndexOutOfBoundsException();
        }

        if (indice == 0) {
            return null;
        }

        No ant = noInicial;
        while (--indice > 0) {
            ant = ant.seguinte;
        }

        return ant;
    }


    @Override
    public void inserirNoInicio(T elem) {
        noInicial = new No(elem);

        if (++numeroElementos == 1) {
            noFinal = noInicial;
        }
    }

    @Override
    public void inserirNoFim(T elem) {
        if (++numeroElementos == 1) {
            noFinal = noInicial = new No(elem);
        } else {
            noFinal = new No(elem, noFinal);
        }
    }


    @Override
    public void inserirPorIndice(int indice, T elem) {
        if (indice == 0) {
            inserirNoInicio(elem);
        } else if (indice == numeroElementos) {
            inserirNoFim(elem);
        } else {
            new No(elem, getNoAnteriorPorIndice(indice));
            numeroElementos++;
        }
    }

    @Override
    public T removerDoInicio() {
        if (numeroElementos == 0) {
            return null;
        }

        No aux = noInicial;
        if (--numeroElementos == 0) {
            noFinal = noInicial = null;
        } else {
            noInicial = noInicial.seguinte;
        }

        return aux.elemento;
    }

    @Override
    public T removerDoFim() {
        if (numeroElementos == 0) {
            return null;
        }

        No aux = noFinal;
        if (numeroElementos == 1) {
            noFinal = noInicial = null;
        } else {
            No ant = getNoAnteriorPorIndice(numeroElementos - 1);
            ant.seguinte = null;
            noFinal = ant;
        }

        numeroElementos--;

        return aux.elemento;
    }

    private T removerNoSeguinte(No ant) {
        No aux = ant.seguinte;

        if (aux == noFinal) {
            noFinal = ant;
        }

        ant.seguinte = aux.seguinte;
        numeroElementos--;

        return aux.elemento;
    }

    @Override
    public T remover(T elem) {
        if (numeroElementos == 0) {
            return null;
        }

        if (noInicial.elemento.equals(elem)) {
            return removerDoInicio();
        }

        No ant = getNoAnterior(elem);

        return ant.seguinte != null ? removerNoSeguinte(ant) : null;
    }

    @Override
    public T removerPorReferencia(T elem) {
        if (numeroElementos == 0) {
            return null;
        }

        if (noInicial.elemento == elem) {
            return removerDoInicio();
        }

        No ant = getNoAnteriorPorReferencia(elem);

        return ant.seguinte != null ? removerNoSeguinte(ant) : null;
    }

    @Override
    public T removerPorIndice(int indice) {
        No ant = getNoAnteriorPorIndice(indice);

        return ant != null ? removerNoSeguinte(ant) : removerDoInicio();

    }

    @Override
    public T consultarPorIndice(int indice) {
        No ant = getNoAnteriorPorIndice(indice);

        return ant != null ? ant.seguinte.elemento : noInicial.elemento;
    }

    @Override
    public boolean contem(T elem) {
        No ant = getNoAnterior(elem);
        return noInicial != null && (ant == null      // noInicial.elemento.equals(elem)
                || ant.seguinte != null);

    }

    @Override
    public boolean contemReferencia(T elem) {
        No ant = getNoAnteriorPorReferencia(elem);
        return noInicial != null && (ant == null      // noInicial.elemento == elem
                || ant.seguinte != null);

    }

    @Override
    public int getNumeroElementos() {
        return numeroElementos;
    }

    @Override
    public IteradorIteravel<T> iterador() {
        return new Iterador();
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("Lista Simples Não Ordenada = {\n");
        No aux = noInicial;
        while (aux != null) {
            s.append(aux.elemento).append("\n");
            aux = aux.seguinte;
        }
        s.append("}\n");
        return s.toString();
    }


    public class No implements Serializable {
        protected static final long serialVersionUID = 1L;

        protected T elemento;
        protected No seguinte;

        // Criação de nó com elemento elem antes do noInicial da lista
        protected No(T elem) {
            elemento = elem;
            seguinte = noInicial;
        }

        // Criação de nó com elemento elem e inserção após o nó ant (!= null)
        protected No(T elem, No ant) {
            elemento = elem;
            seguinte = ant.seguinte;
            ant.seguinte = this;
        }
    }

    public class Iterador implements IteradorIteravel<T> {
        protected No corrente;
        protected No seguinte;

        protected Iterador() {
            reiniciar();
        }

        @Override
        public void reiniciar() {
            corrente = null;
            seguinte = noInicial;
        }

        @Override
        public T corrente() {
            if (corrente == null) {
                throw new NoSuchElementException();
            }

            return corrente.elemento;
        }

        @Override
        public boolean podeAvancar() {
            return seguinte != null;
        }

        @Override
        public T avancar() {
            if (!podeAvancar()) {
                throw new NoSuchElementException();
            }

            corrente = seguinte;
            seguinte = seguinte.seguinte;
            return corrente.elemento;
        }
    }
}
