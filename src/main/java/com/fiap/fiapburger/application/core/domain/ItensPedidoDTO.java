package com.fiap.fiapburger.application.core.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class ItensPedidoDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;
    private String id_produto;
    private String id_pedido;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId_produto() {
        return id_produto;
    }

    public void setId_produto(String id_produto) {
        this.id_produto = id_produto;
    }

    public String getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(String id_pedido) {
        this.id_pedido = id_pedido;
    }
}
