package com.fiap.fiapburger.core.application.ports;

import com.fiap.fiapburger.core.domain.ClienteDTO;

public interface ClienteService {

	public ClienteDTO criaCliente(ClienteDTO cliente);
	public ClienteDTO editaCliente(ClienteDTO cliente);
	public ClienteDTO buscaCliente(String id);
	public ClienteDTO excluiCliente(String id);
}
