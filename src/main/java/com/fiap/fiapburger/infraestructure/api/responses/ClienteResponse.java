package com.fiap.fiapburger.infraestructure.api.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serial;
import java.io.Serializable;

@Data
public class ClienteResponse implements Serializable {

    @Serial
    private static final long serialVersionUID = 8188265389338064145L;

    @NotBlank
    @JsonProperty("cpf")
    private String cpf;

    @NotBlank
    @JsonProperty("email")
    private String email;

    @NotBlank
    @JsonProperty("nome")
    private String nome;
}
