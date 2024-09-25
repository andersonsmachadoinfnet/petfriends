package br.anderson.infnet.petfriends_almoxarifado.model.domain;

import jakarta.persistence.*;

@Entity
@Table(name="TEstoque")
public class Estoque {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private    Integer id;
    private     String ean;
    private     String produto;
    private Quantidade quantidade;

    public Estoque() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEan() {
        return ean;
    }

    public void setEan(String ean) {
        this.ean = ean;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public Quantidade getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Quantidade quantidade) {
        this.quantidade = quantidade;
    }
}
