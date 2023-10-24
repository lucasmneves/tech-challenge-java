package com.fiap.fiapburger.adapter.driver.api.services;

import com.fiap.fiapburger.adapter.driver.api.model.cliente.ClienteDTO;

public interface ClienteService {

	public ClienteDTO criaCliente(ClienteDTO cliente);
	public ClienteDTO editaCliente(ClienteDTO cliente);
	public ClienteDTO buscaCliente(String id);
	public ClienteDTO excluiCliente(String id);
}
