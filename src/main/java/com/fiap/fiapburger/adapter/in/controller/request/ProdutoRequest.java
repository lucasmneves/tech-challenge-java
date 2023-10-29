package com.fiap.fiapburger.adapter.in.controller.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ProdutoRequest {

    @NotBlank(message = "Nome não pode ser vazio.")
    @JsonProperty("nome")
    private String nome;

    @NotNull(message = "Preço não pode ser nulo.")
    @JsonProperty("preco")
    private BigDecimal preco;

    public ProdutoRequest() {
    }

    public ProdutoRequest(String nome, BigDecimal preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }
}