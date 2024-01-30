package com.fiap.fiapburger.infraestructure.api.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class ItensPedidoResponse implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @JsonProperty("id_produto")
    private String idProduto;

    @JsonProperty("valor")
    private BigDecimal valor;

    @JsonProperty("nome")
    private String nome;

}
