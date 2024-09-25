package br.anderson.infnet.petsfriends_transporte.model.domain;

import jakarta.persistence.*;

@Entity
@Table(name="TVolumes")
public class EntregaVolumes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private  String SKU;
    private   Float peso;
    private   Float altura;
    private   Float largura;
    private Integer entregaId;

    public EntregaVolumes(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSKU() {
        return SKU;
    }

    public void setSKU(String SKU) {
        this.SKU = SKU;
    }

    public Float getPeso() {
        return peso;
    }

    public void setPeso(Float peso) {
        this.peso = peso;
    }

    public Float getAltura() {
        return altura;
    }

    public void setAltura(Float altura) {
        this.altura = altura;
    }

    public Float getLargura() {
        return largura;
    }

    public void setLargura(Float largura) {
        this.largura = largura;
    }

    public Integer getEntregaId() {
        return entregaId;
    }

    public void setEntregaId(Integer entregaId) {
        this.entregaId = entregaId;
    }
}
