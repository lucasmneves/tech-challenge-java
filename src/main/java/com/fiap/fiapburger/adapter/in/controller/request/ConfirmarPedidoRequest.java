package com.fiap.fiapburger.adapter.in.controller.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class ConfirmarPedidoRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonProperty("pedido")
    private String idPedido;

    @JsonProperty("detalhes")
    private String detalhes;

}
