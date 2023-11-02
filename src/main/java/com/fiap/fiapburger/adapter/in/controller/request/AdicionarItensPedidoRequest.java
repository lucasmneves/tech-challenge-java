package com.fiap.fiapburger.adapter.in.controller.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
public class AdicionarItensPedidoRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonProperty("pedido")
    private String idPedido;

    @JsonProperty("produto")
    private String idProduto;

}
