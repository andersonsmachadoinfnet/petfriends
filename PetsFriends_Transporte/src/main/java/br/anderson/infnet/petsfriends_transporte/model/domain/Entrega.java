package br.anderson.infnet.petsfriends_transporte.model.domain;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="TEntrega")
public class Entrega {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private          Integer id;
    @Column(name="PEDIDO_ID")
    private          Integer idPedido;
    @Column(name="CLIENTE_ID")
    private          Integer idCliente; // Faz referência a outro agregado
    @OneToMany(mappedBy = "entregaId")
    private List<EntregaVolumes> pedidoItems = new ArrayList<>();
    private   Endereco endereco;

    public Entrega() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Integer idPedido) {
        this.idPedido = idPedido;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public List<EntregaVolumes> getPedidoItems() {
        return pedidoItems;
    }

    public void setPedidoItems(List<EntregaVolumes> pedidoItems) {
        this.pedidoItems = pedidoItems;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
