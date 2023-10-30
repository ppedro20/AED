package aed.modelo.contactos.comparadores;

import aed.Comparacao;
import aed.modelo.contactos.Contacto;
import aed.modelo.contactos.Data;

public enum ComparadorUltimoNomeAscendente implements Comparacao<Contacto> {
    CRITERIO;

    @Override
    public int comparar(Contacto o1, Contacto o2) {

        int comp = o1.getUltimoNome().compareTo(o2.getUltimoNome());

        if (comp != 0) {
            return comp;
        }
        return -Data.compare(o1.getDataNascimento(), o2.getDataNascimento());
    }
}
