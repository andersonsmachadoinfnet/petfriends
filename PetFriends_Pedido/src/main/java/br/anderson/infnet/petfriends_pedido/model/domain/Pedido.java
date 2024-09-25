package br.anderson.infnet.petfriends_pedido.model.domain;

import br.anderson.infnet.petfriends_pedido.model.auxiliar.PedidoStatus;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="TPedido")
public class Pedido implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private          Integer id;
    private     PedidoStatus Status;
    @Column(name="CLIENTE_ID")
    private          Integer idCliente; // Faz referência a outro agregado
    @OneToMany(mappedBy = "pedidoId")
    private List<PedidoItem> pedidoItems = new ArrayList<>();
    //private   ValorMonetario valorTotal;

    public Pedido() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public PedidoStatus getStatus() {
        return Status;
    }

    public void setStatus(PedidoStatus status) {
        Status = status;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public List<PedidoItem> getPedidoItem() {
        return pedidoItems;
    }

    public void setPedidoItem(List<PedidoItem> pedidoItems) {
        this.pedidoItems = pedidoItems;
    }
}
