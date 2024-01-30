package com.fiap.fiapburger.infraestructure.api.controllers;

import com.fiap.fiapburger.infraestructure.api.requests.HistoricoRequest;
import com.fiap.fiapburger.core.ports.in.historico.SalvarHistoricoInputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;

@RestController
@RequestMapping("/historico")
public class HistoricoController {
    @Autowired
    private SalvarHistoricoInputPort salvarHistoricoInputPort;
    @PostMapping
    public ResponseEntity<Void> salvar(@Valid @RequestBody HistoricoRequest historicoRequest, UriComponentsBuilder uriComponentsBuilder){
        salvarHistoricoInputPort.salvar(historicoRequest);
        return ResponseEntity.created(uriComponentsBuilder.path("/historico/{id}").buildAndExpand(historicoRequest.getId()).toUri()).build();
    }
}
