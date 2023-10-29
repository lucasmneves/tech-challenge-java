package com.fiap.fiapburger.adapter.out.repository.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name="produtos")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL)
@Getter
@Setter
public class ProdutoEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	private String nome;
	private String descricao;
	private String url_imagem;
	private BigDecimal preco;
	private String categoria;
		
}
