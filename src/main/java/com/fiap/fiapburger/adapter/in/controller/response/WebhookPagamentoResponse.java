package com.fiap.fiapburger.adapter.in.controller.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class WebhookPagamentoResponse implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @JsonProperty("pedido")
    private String idPedido;

    @JsonProperty("meio_pagamento")
    private String tipoPagamento;

    @JsonProperty("valor")
    private BigDecimal valor;

    @JsonProperty("status")
    private String status;

    @JsonProperty("senha")
    private Integer senha;

    @JsonProperty("mensagem")
    private String mensagem;
}
