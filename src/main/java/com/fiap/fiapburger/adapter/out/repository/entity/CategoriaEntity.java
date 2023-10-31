package com.fiap.fiapburger.adapter.out.repository.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name="categoria")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CategoriaEntity implements Serializable {
    @Serial
    private static final long serialVersionUID = -1234567891011121314L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Categoria_id_seq")
    @SequenceGenerator(name = "Categoria_id_seq", sequenceName = "Categoria_id_seq", allocationSize = 1)
    @JsonProperty("id")
    private Long id;

    @Column(name = "nome", nullable = false, length = 80)
    @JsonProperty("nome")
    private String nome;

    @Column(name = "descricao", nullable = false, length = 127)
    @JsonProperty("descricao")
    private String descricao;

    @OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<ProdutoEntity> produtos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Set<ProdutoEntity> getProdutos() {
        return produtos;
    }

    public void setProdutos(Set<ProdutoEntity> produtos) {
        this.produtos = produtos;
    }
}