package com.fiap.fiapburger.infraestructure.api.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;

public class ProdutoResponse {

    @JsonProperty("id")
    private String id;

    @JsonProperty("nome")
    private String nome;

    @JsonProperty("preco")
    private BigDecimal preco;

    @JsonProperty("descricao")
    private String descricao;

    @JsonProperty("url_imagem")
    private String urlImagem;

    @JsonProperty("categoria")
    private String categoria;

    public ProdutoResponse() {
    }

    public ProdutoResponse(String id, String nome, BigDecimal preco) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
    }

    public ProdutoResponse(String id, String nome, String categoria, String descricao, String preco) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = BigDecimal.valueOf(Double.parseDouble(preco.replace(",","")));
        this.categoria = categoria;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getUrlImagem() {
        return urlImagem;
    }

    public void setUrlImagem(String urlImagem) {
        this.urlImagem = urlImagem;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
