package com.fiap.fiapburger.adapter.in.controller.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class ProdutoRequest {

    public ProdutoRequest(String nome, BigDecimal preco) {
        this.nome = nome;
        this.preco = preco;
    }
    @NotBlank(message = "Nome não pode ser vazio.")
    @JsonProperty("nome")
    private String nome;

    @NotNull(message = "Preço não pode ser nulo.")
    @JsonProperty("preco")
    private BigDecimal preco;

    @JsonProperty("descricao")
    private String descricao;

    @NotNull(message = "Id categoria não pode ser nulo.")
    @JsonProperty("id_categoria")
    private String id_categoria;

    @JsonProperty("url_imagem")
    private String url_imagem;

}