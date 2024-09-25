package br.anderson.infnet.petfriends_almoxarifado.model.domain;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name="TPedidoItem")
public class PedidoItem implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private    Integer id;
    private    Integer produtoId;
    private Quantidade quantidade;
    //@JoinColumn(name = "pedidoId", referencedColumnName = "ID")
    //@ManyToOne
    private    Integer pedidoId;

    public PedidoItem() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(Integer produtoId) {
        this.produtoId = produtoId;
    }

    public Quantidade getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Quantidade quantidade) {
        this.quantidade = quantidade;
    }

    public Integer getPedidoId() {
        return pedidoId;
    }

    public void setPedidoId(Integer pedidoId) {
        this.pedidoId = pedidoId;
    }
}
