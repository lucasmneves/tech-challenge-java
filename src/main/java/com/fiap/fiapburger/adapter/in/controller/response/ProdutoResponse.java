package com.fiap.fiapburger.adapter.in.controller.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;

public class ProdutoResponse {

    @JsonProperty("id")
    private String id;

    @JsonProperty("nome")
    private String nome;

    @JsonProperty("descricao")
    private String descricao;

    @JsonProperty("url_imagem")
    private String url_imagem;

    @JsonProperty("preco")
    private BigDecimal preco;

    @JsonProperty("id_categoria")
    private String id_categoria;

    public ProdutoResponse() {
    }

    public ProdutoResponse(String id, String nome, String descricao, String url_imagem, BigDecimal preco, String id_categoria) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.url_imagem = url_imagem;
        this.preco = preco;
        this.id_categoria = id_categoria;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getUrl_imagem() {
        return url_imagem;
    }

    public void setUrl_imagem(String url_imagem) {
        this.url_imagem = url_imagem;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public String getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(String id_categoria) {
        this.id_categoria = id_categoria;
    }
}