package com.fiap.fiapburger.adapter.driver.api.model;

import java.io.Serializable;
import java.util.UUID;

public class CarrinhoDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private UUID id;
    private Long numeroPedido;
    private String codigoStatus;
    private String descricaoStatus;
    private PedidoDTO pedido;
    private Float total;

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getCodigoStatus() {
        return codigoStatus;
    }

    public void setCodigoStatus(String codigoStatus) {
        this.codigoStatus = codigoStatus;
    }

    public String getDescricaoStatus() {
        return descricaoStatus;
    }

    public void setDescricaoStatus(String descricaoStatus) {
        this.descricaoStatus = descricaoStatus;
    }

    public Long getNumeroPedido() {
        return numeroPedido;
    }

    public void setNumeroPedido(Long numeroPedido) {
        this.numeroPedido = numeroPedido;
    }

    public PedidoDTO getPedido() {
        return pedido;
    }

    public void setPedido(PedidoDTO pedido) {
        this.pedido = pedido;
    }
}
