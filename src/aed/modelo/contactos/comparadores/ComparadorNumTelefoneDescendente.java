package aed.modelo.contactos.comparadores;

import aed.Comparacao;
import aed.modelo.contactos.Contacto;

public enum ComparadorNumTelefoneDescendente implements Comparacao<Contacto> {
    CRITERIO;

    @Override
    public int comparar(Contacto o1, Contacto o2) {
        return -Long.compare(o1.getNumTelefone(), o2.getNumTelefone());
    }
}
