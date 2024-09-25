package br.anderson.infnet.petfriends_pedido.model.domain;

import java.io.Serializable;
import java.util.Objects;

public class Quantidade implements Serializable {

    private final Float qtd;

    public Quantidade(Float qtd) {
        if (qtd == null || qtd < 0) {
            throw new IllegalArgumentException("Quantidade não pode ser negativo");
        }
        this.qtd = qtd;
    }

    public Float getQtd() {
        return this.qtd;
    }

    public Quantidade incrementar(Quantidade qtd) {
        if (qtd == null) {
            throw new IllegalArgumentException("Quantidade não pode ser nulo");
        }
        return new Quantidade(this.qtd+qtd.getQtd());
    }

    public Quantidade decrementar(Quantidade qtd) {
        if (qtd == null) {
            throw new IllegalArgumentException("Quantidade não pode ser nulo");
        }
        return new Quantidade(this.qtd-qtd.getQtd());
    }

    @Override
    public boolean equals(Object objeto) {
        final Quantidade outro = (Quantidade) objeto;
        return Objects.equals(this.qtd, outro.getQtd());
    }
}
