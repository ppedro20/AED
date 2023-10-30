package aed.modelo.contactos;

import aed.Comparacao;

public class Data {
    private int dia;
    private int mes;
    private int ano;

    public Data(int dia, int mes, int ano) {
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }

    public static int compare(Data dataNascimento, Data dataNascimento1) {
        int comp = Integer.compare(dataNascimento.getAno(), dataNascimento1.getAno());
        if (comp != 0) return comp;
        comp = Integer.compare(dataNascimento.getMes(), dataNascimento1.getMes());
        if (comp != 0) return comp;
        return Integer.compare(dataNascimento.getDia(), dataNascimento1.getDia());
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }
}
