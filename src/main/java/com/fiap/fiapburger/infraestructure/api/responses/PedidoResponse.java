package com.fiap.fiapburger.infraestructure.api.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
public class PedidoResponse implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @JsonProperty("id")
    private String id;

    @JsonProperty("senha")
    private Long senha;

    @JsonProperty("id_status")
    private String id_status;

    @JsonProperty("cpf")
    private String cpf;

    @JsonProperty("detalhes")
    private String detalhes;

    @JsonProperty("valor_total")
    private BigDecimal valor_total;

    @JsonProperty("data_hora_inicio")
    private Date data_hora_inicio;

    @JsonProperty("data_hora_fim")
    private Date data_hora_fim;

    @JsonProperty("id_pagamento")
    private String id_pagamento;

    @JsonProperty("id_satisfacao")
    private String id_satisfacao;

    @JsonProperty("itens_pedido")
    private List<ItensPedidoResponse> itensPedido;
}
