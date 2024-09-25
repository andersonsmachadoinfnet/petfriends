package br.anderson.infnet.petfriends_almoxarifado.model.domain.infra;

import java.io.Serializable;
import java.util.Date;

public class EventoClienteComprou implements Serializable {
    private Integer idPedido;
    private Integer idCliente;
    private Date    data;
    private String  obs;

    public EventoClienteComprou() {
    }

    public EventoClienteComprou(Integer idPedido, Integer idCliente, Date data, String obs) {
        this.idPedido = idPedido;
        this.idCliente= idCliente;
        this.data     = data;
        this.obs      = obs;
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

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }
}
