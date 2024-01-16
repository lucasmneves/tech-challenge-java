package com.fiap.fiapburger.adapter.in.controller.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
public class SalvarPedidoRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotBlank
    @JsonProperty("cpf")
    private String cpf;

}
