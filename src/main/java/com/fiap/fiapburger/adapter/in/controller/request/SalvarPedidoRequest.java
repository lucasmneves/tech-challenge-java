package com.fiap.fiapburger.adapter.in.controller.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;

@Data
public class SalvarPedidoRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    //private String id;
    //private String senha;
    //private String id_status;
    @NotBlank
    @JsonProperty("cpf")
    private String cpf;

    //private Double valor_total;

    //private Date data_hora_inicio;

    //private Date data_hora_fim;

    //private String id_pagamento;

    //private String id_satisfacao;
}
