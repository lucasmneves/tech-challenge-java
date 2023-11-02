package com.fiap.fiapburger.application.core.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class ItensPedidoDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;
    private ProdutoDTO produto;
    private PedidoDTO pedido;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ProdutoDTO getProduto() {
        return produto;
    }

    public void setProduto(ProdutoDTO produto) {
        this.produto = produto;
    }

    public PedidoDTO getPedido() {
        return pedido;
    }

    public void setPedido(PedidoDTO pedido) {
        this.pedido = pedido;
    }
}
