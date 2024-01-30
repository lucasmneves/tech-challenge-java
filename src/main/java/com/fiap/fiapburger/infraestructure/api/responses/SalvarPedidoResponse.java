package com.fiap.fiapburger.infraestructure.api.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
public class SalvarPedidoResponse implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @JsonProperty("id_pedido")
    private String id;

}
