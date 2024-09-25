package br.anderson.infnet.petsfriends_transporte.model.domain;

import java.io.Serializable;
import java.util.Objects;

public class Endereco implements Serializable {
    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String estado;

    public Endereco(String logradouro, String numero, String complemento, String bairro, String cidade, String estado) {
        if (logradouro == null || logradouro == "") {
            throw new IllegalArgumentException("Logradouro não informado");
        }
        if (numero == null || numero == "") {
            throw new IllegalArgumentException("Número não informado");
        }
        if (complemento == null || complemento == "") {
            throw new IllegalArgumentException("Complemento não informado");
        }
        if (bairro == null || bairro == "") {
            throw new IllegalArgumentException("Bairro não informado");
        }
        if (cidade == null || cidade == "") {
            throw new IllegalArgumentException("Cidade não informado");
        }
        if (estado == null || estado == "") {
            throw new IllegalArgumentException("Estado não informado");
        }
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
    }

    @Override
    public boolean equals(Object objeto) {
        final Endereco outro = (Endereco) objeto;
        return
                (Objects.equals(this.logradouro, outro.getLogradouro()) ||
                 Objects.equals(this.numero, outro.getNumero()) ||
                 Objects.equals(this.complemento, outro.getComplemento()) ||
                 Objects.equals(this.bairro, outro.getBairro()) ||
                 Objects.equals(this.cidade, outro.getCidade()) ||
                 Objects.equals(this.estado, outro.getEstado()));
    }

    public String getLogradouro() {
        return logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEstado() {
        return estado;
    }
}
