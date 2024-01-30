package com.fiap.fiapburger.infraestructure.persistence.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Table(name="itens_pedido")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL)
@Getter
@Setter
public class ItensPedidoEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	@ManyToOne
	@JoinColumn(name = "produto")
	private ProdutoEntity produto;

	@ManyToOne
	@JoinColumn(name = "pedido")
	private PedidoEntity pedido;

}
