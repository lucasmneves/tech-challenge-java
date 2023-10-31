package com.fiap.fiapburger.adapter.out.repository.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.io.Serializable;

@Entity
@Table(name = "produtos")
public class ProdutoEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;

	@Column(name = "nome", nullable = false, length = 80)
	private String nome;

	@Column(name = "descricao", length = 127)
	private String descricao;

	@Column(name = "url_imagem")
	private String urlImagem;

	@Column(name = "preco", nullable = false)
	private BigDecimal preco;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "categoria_id", referencedColumnName = "id")
	private CategoriaEntity categoria;

	// Construtores
	public ProdutoEntity() {}

	public ProdutoEntity(String id, String nome, String descricao, String urlImagem, BigDecimal preco, CategoriaEntity categoria) {
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.urlImagem = urlImagem;
		this.preco = preco;
		this.categoria = categoria;
	}

	// Getters e setters
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

	public String getUrlImagem() {
		return urlImagem;
	}

	public void setUrlImagem(String urlImagem) {
		this.urlImagem = urlImagem;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public CategoriaEntity getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaEntity categoria) {
		this.categoria = categoria;
	}
}