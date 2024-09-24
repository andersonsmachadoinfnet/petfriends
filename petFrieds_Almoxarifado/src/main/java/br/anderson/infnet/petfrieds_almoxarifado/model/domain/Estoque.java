package br.anderson.infnet.petfrieds_almoxarifado.model.domain;

import java.util.Objects;

public class Estoque {
    private final Float qtd;

    public Estoque(Float qtd) {
        if (qtd == null || qtd < 0) {
            throw new IllegalArgumentException("Estoque não pode ser negativo");
        }
        this.qtd = qtd;
    }

    public Float getQtd() {
        return this.qtd;
    }

    public Estoque devolver(Estoque outro) {
        if (outro == null) {
            throw new IllegalArgumentException("Outro valor não pode ser nulo");
        }
        return new Estoque(this.qtd + outro.getQtd());
    }

    public Estoque vender(Estoque outro) {
        if (outro == null) {
            throw new IllegalArgumentException("Outro valor não pode ser nulo");
        }
        return new Estoque(this.qtd - outro.getQtd());
    }

    @Override
    public boolean equals(Object objeto) {
        final Estoque outro = (Estoque) objeto;
        return Objects.equals(this.qtd, outro.getQtd());
    }
}
