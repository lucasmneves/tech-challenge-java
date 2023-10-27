package com.fiap.fiapburger.adapter.driver.api.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PedidoDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private List<ItensPedidoDTO> itensPedido;

    public List<ItensPedidoDTO> getItensPedido() {
        return itensPedido;
    }

    public void setItensPedido(List<ItensPedidoDTO> itensPedido) {
        this.itensPedido = itensPedido;
    }
}
