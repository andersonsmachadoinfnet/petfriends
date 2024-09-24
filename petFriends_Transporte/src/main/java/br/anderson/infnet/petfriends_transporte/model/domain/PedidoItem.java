package br.anderson.infnet.petfriends_transporte.model.domain;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name="TPedidoItem")
public class PedidoItem implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private  String pedidoId;
    private   Float quantidade;

    public PedidoItem() {
    }

    public String getPedidoId() {
        return pedidoId;
    }

    public void setPedidoId(String pedidoId) {
        this.pedidoId = pedidoId;
    }

    public Float getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Float quantidade) {
        this.quantidade = quantidade;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
