package com.fiap.fiapburger.infraestructure.api.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
public class AtualizarStatusPedidoRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotBlank
    @JsonProperty("id")
    private String id;

    @NotBlank
    @JsonProperty("id_status")
    private String id_status;
}
