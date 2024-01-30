package com.fiap.fiapburger.infraestructure.persistence.entities;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name="cliente")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL)
@Getter
@Setter
public class ClienteEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@JsonProperty("cpf")
	private String cpf;
	
	@JsonProperty("nome")
	private String nome;
	
	@JsonProperty("email")
	private String email;
		
}
