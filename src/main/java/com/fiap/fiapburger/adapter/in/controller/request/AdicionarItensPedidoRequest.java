package com.fiap.fiapburger.adapter.in.controller.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
public class EditarPedidoRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonProperty("id_pedido")
    private String idPedido;

    @JsonProperty("id_produto")
    private ArrayList<String> idProduto;

}
