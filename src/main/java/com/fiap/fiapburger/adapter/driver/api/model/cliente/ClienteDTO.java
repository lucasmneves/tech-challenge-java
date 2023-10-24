package com.fiap.fiapburger.adapter.driver.api.model.cliente;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="cliente")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL)
@AllArgsConstructor
@NoArgsConstructor
@Builder()
public class ClienteDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@JsonProperty("cpf")
	private String cpf;
	
	@JsonProperty("nome")
	private String nome;
	
	@JsonProperty("email")
	private String email;
	
	public ClienteDTO(String nome, String email) {
		this.email = email;
		this.nome = nome;
	}
}
	

