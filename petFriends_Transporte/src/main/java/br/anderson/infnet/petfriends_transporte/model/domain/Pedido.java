package br.anderson.infnet.petfriends_transporte.model.domain;

import br.anderson.infnet.petfriends_transporte.model.auxiliar.PedidoStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Pedido implements Serializable {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private       String id;
    private PedidoStatus Status;
    @Column(name="CLIENTE_ID")
    private       Integer idCliente; // Faz referência a outro agregado
    @OneToMany(mappedBy = "pedidoId")
    private List<PedidoItem> pedidoItems = new ArrayList<>();
    private   ValorMonetario valorTotal;

    public Pedido() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public List<PedidoItem> getPedidoItems() {
        return pedidoItems;
    }

    public void setPedidoItems(List<PedidoItem> pedidoItems) {
        this.pedidoItems = pedidoItems;
    }

    public ValorMonetario getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(ValorMonetario valorTotal) {
        this.valorTotal = valorTotal;
    }
}
