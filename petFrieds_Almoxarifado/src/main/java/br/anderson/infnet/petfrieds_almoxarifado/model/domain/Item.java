package br.anderson.infnet.petfrieds_almoxarifado.model.domain;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name="TItem")
public class Item implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private  String nome;
    private Estoque quantidade;

    public Item() {
    }
    public Item(String nome, Estoque quantidade) {
        this.nome = nome;
        this.quantidade = quantidade;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Estoque getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Estoque quantidade) {
        this.quantidade = quantidade;
    }
}
