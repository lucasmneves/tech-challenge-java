package com.fiap.fiapburger.infraestructure.api.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
public class ClienteRequest implements Serializable {

    private static final long serialVersionUID = 1769503439301673405L;

    @NotBlank(message = "CPF não pode ser vazio!")
    @JsonProperty("cpf")
    private String cpf;

    @NotBlank(message = "Email não pode ser vazio!")
    @JsonProperty("email")
    private String email;

    @NotBlank(message = "Nome não pode ser vazio!")
    @JsonProperty("nome")
    private String nome;

}
