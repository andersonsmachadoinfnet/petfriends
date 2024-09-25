package br.anderson.infnet.petsfriends_transporte.model.infra;

import java.io.Serializable;
import java.util.Date;

public class EventoNotaDisponibilizada implements Serializable {
    private Integer idPedido;
    private Integer idCliente;
    private    Date data;
    private  String endereco;

    public EventoNotaDisponibilizada() {}
    public EventoNotaDisponibilizada(Integer idPedido, Integer idCliente, Date data, String endereco) {
        this.idPedido = idPedido;
        this.idCliente = idCliente;
        this.data = data;
        this.endereco = endereco;
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

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
