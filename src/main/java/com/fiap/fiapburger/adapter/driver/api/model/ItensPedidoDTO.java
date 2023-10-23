package com.fiap.fiapburger.adapter.driver.api.model;

import java.io.Serializable;

public class ItensPedidoDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String item;
    private Float valor;

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }


}
