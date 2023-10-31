package com.fiap.fiapburger.adapter.in.controller.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;

public class ProdutoResponse {

    @JsonProperty("id")
    private String id;

    @JsonProperty("nome")
    private String nome;

    @JsonProperty("preco")
    private BigDecimal preco;


    public ProdutoResponse() {
    }

    public ProdutoResponse(String id, String nome, BigDecimal preco) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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