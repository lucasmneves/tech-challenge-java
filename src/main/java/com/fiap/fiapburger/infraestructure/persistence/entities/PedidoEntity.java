package com.fiap.fiapburger.infraestructure.persistence.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name="pedido")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL)
@Getter
@Setter
public class PedidoEntity extends Date implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	private Integer senha;
	private String id_status;
	private String cpf;
	private String detalhes;
	private BigDecimal valor_total;
	private Date data_hora_inicio;
	private Date data_hora_fim;
	private String id_pagamento;
	private String id_satisfacao;
		
}
