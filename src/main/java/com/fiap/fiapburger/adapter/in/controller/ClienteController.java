package com.fiap.fiapburger.adapter.in.controller;

import com.fiap.fiapburger.adapter.in.controller.mapper.ClienteMapper;
import com.fiap.fiapburger.adapter.in.controller.request.ClienteRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fiap.fiapburger.application.ports.in.SalvarClienteInputport;

import javax.validation.Valid;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private SalvarClienteInputport salvarClienteInputport;

    @Autowired
    private ClienteMapper clienteMapper;
    @PostMapping
    public ResponseEntity<Void> salvar(@Valid @RequestBody ClienteRequest clienteRequest){
        var cliente = clienteMapper.toCliente(clienteRequest);
        salvarClienteInputport.salvar(cliente);
        return ResponseEntity.ok().build();
    };

}
