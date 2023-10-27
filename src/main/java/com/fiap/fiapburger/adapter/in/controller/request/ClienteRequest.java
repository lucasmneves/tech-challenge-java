package com.fiap.fiapburger.adapter.in.controller.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serial;
import java.io.Serializable;

@Data
public class ClienteRequest implements Serializable {

    private static final long serialVersionUID = 1769503439301673405L;

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
