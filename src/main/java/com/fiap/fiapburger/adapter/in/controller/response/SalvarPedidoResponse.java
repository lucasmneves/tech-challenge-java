package com.fiap.fiapburger.adapter.in.controller.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
public class SalvarPedidoResponse implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @JsonProperty("id_pedido")
    private String id;

}
