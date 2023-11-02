package com.fiap.fiapburger.adapter.in.controller;

import com.fiap.fiapburger.adapter.in.controller.request.HistoricoRequest;
import com.fiap.fiapburger.adapter.out.repository.mapper.HistoricoMapper;
import com.fiap.fiapburger.application.ports.in.historico.SalvarHistoricoInputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;

@RestController
@RequestMapping("/historico")
public class HistoricoController {
    @Autowired
    private SalvarHistoricoInputPort salvarHistoricoInputPort;
    /*@Autowired
    private DeletarHistoricoInputPort deletarHistoricoInputPort;
    @Autowired
    private EditarHistoricoInputPort editarHistoricoInputPort;
    @Autowired
    private BuscarHistoricoInputPort buscarHistoricoInputPort;*/
    @Autowired
    private HistoricoMapper historicoMapper;

    @PostMapping
    public ResponseEntity<Void> salvar(@Valid @RequestBody HistoricoRequest historicoRequest, UriComponentsBuilder uriComponentsBuilder){
        var historico = historicoMapper.toHistoricoDTO(historicoRequest);
        salvarHistoricoInputPort.salvar(historico);
        return ResponseEntity.created(uriComponentsBuilder.path("/historico/{id}").buildAndExpand(historico.getId()).toUri()).build();
    }
}
