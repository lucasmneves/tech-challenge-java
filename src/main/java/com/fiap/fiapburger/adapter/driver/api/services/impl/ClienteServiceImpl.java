package com.fiap.fiapburger.adapter.driver.api.services.impl;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fiap.fiapburger.adapter.driven.infra.ClienteRepository;
import com.fiap.fiapburger.adapter.driver.api.controller.checkout.exception.ClienteNaoEncontradoException;
import com.fiap.fiapburger.adapter.driver.api.controller.checkout.exception.ExceptionsMessageEnum;
import com.fiap.fiapburger.adapter.driver.api.model.cliente.ClienteDTO;
import com.fiap.fiapburger.adapter.driver.api.services.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService{

	private final ClienteRepository repository;
	
	@Autowired
	public ClienteServiceImpl(ClienteRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public ClienteDTO criaCliente(ClienteDTO client) {
		return this.repository.save(client);
	}
	@Override
	public ClienteDTO editaCliente(ClienteDTO c) {
		
		Optional<ClienteDTO> client = repository.findById(c.getCpf());
		
		if(client.isPresent()) {
			client.get().setEmail(c.getEmail());
			client.get().setNome(c.getNome());
			this.repository.save(client.get());
			return c;
		}else{
			
			throw new ClienteNaoEncontradoException(ExceptionsMessageEnum.CLIENTE_NAO_ENCONTRADO.value());
			
		}
	}

	@Override
	public ClienteDTO buscaCliente(String id) {
		Optional<ClienteDTO> client = repository.findById(id);
		
		if(client.isPresent())
			return client.get();
		
		throw new ClienteNaoEncontradoException(ExceptionsMessageEnum.CLIENTE_NAO_ENCONTRADO.value());
	}
	
	@Override
	public ClienteDTO excluiCliente(String id) {
		
		Optional<ClienteDTO> client = repository.findById(id);
		
		
		if(client.isPresent()) {
			repository.deleteById(id);
			return client.get();
		};
		
		throw new ClienteNaoEncontradoException(ExceptionsMessageEnum.CLIENTE_NAO_ENCONTRADO.value());
	}
}
