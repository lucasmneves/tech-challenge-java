package com.fiap.fiapburger.adapter.in.controller.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class AdicionarItensPedidoRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonProperty("pedido")
    private String idPedido;

    @JsonProperty("produto")
    private String idProduto;

}
