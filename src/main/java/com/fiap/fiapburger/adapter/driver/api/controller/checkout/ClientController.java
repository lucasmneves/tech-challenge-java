package com.fiap.fiapburger.adapter.driver.api.controller.checkout;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fiap.fiapburger.adapter.driver.api.model.cliente.ClienteDTO;
import com.fiap.fiapburger.adapter.driver.api.services.impl.ClienteServiceImpl;

@RestController
@RequestMapping("/client")
public class ClientController {

	private final ClienteServiceImpl service;
	
	@Autowired
	ClientController(ClienteServiceImpl service){
		this.service = service;
	}
	
	@PostMapping("/register")
	public ResponseEntity<ClienteDTO> registerClient(@RequestBody @Validated ClienteDTO client) {
		return new ResponseEntity<ClienteDTO>(this.service.criaCliente(client), HttpStatus.OK);
	}
	
	@PutMapping("/edit")
	public ResponseEntity<ClienteDTO> editClient(@RequestBody @Validated ClienteDTO client) {
		return new ResponseEntity<ClienteDTO>(this.service.editaCliente(client),HttpStatus.OK);
	}
	
	@GetMapping("/search/{id}")
	public ResponseEntity<ClienteDTO> searchClient(@PathVariable String id) {
		return new ResponseEntity<ClienteDTO>(this.service.buscaCliente(id),HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ClienteDTO> deleteClient(@PathVariable String id) {
		return new ResponseEntity<ClienteDTO>(this.service.excluiCliente(id),HttpStatus.OK);
	}
	
	
}