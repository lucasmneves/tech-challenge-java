package com.fiap.fiapburger.adapter.in.controller;

import com.fiap.fiapburger.adapter.in.controller.mapper.ClienteMapper;
import com.fiap.fiapburger.adapter.in.controller.request.ClienteRequest;
import com.fiap.fiapburger.adapter.in.controller.response.ClienteResponse;
import com.fiap.fiapburger.application.ports.in.BuscarClienteInputPort;
import com.fiap.fiapburger.application.ports.in.DeletarClienteInputPort;
import com.fiap.fiapburger.application.ports.in.EditarClienteInputport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.fiap.fiapburger.application.ports.in.SalvarClienteInputport;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private SalvarClienteInputport salvarClienteInputport;
    @Autowired
    private EditarClienteInputport editarClienteInputport;
    @Autowired
    private BuscarClienteInputPort buscarClienteInputPort;
    @Autowired
    private DeletarClienteInputPort deletarClienteInputPort;

    @Autowired
    private ClienteMapper clienteMapper;
    @PostMapping
    public ResponseEntity<Void> salvar(@Valid @RequestBody ClienteRequest clienteRequest, UriComponentsBuilder uriComponentsBuilder){
        var cliente = clienteMapper.toCliente(clienteRequest);
        salvarClienteInputport.salvar(cliente);
        return ResponseEntity.created(uriComponentsBuilder.path("/cliente/{cpf}").buildAndExpand(cliente.getCpf()).toUri()).build();
    };

    @PatchMapping
    public ResponseEntity<String> editar(@Valid @RequestBody ClienteRequest clienteRequest){
        var cliente = clienteMapper.toCliente(clienteRequest);
        editarClienteInputport.editar(cliente);
        return ResponseEntity.ok("Cliente " + cliente.getNome() + " atualizado com sucesso!");
    };
   @GetMapping("/{cpf}")
    public ResponseEntity<ClienteResponse> buscar(@PathVariable String cpf){
        var cliente = buscarClienteInputPort.BuscaCliente(cpf);
        return ResponseEntity.ok(cliente);
    };

   @DeleteMapping("/{cpf}")
    public ResponseEntity<String> deletar(@PathVariable String cpf, UriComponentsBuilder uriComponentsBuilder){
       deletarClienteInputPort.deletar(cpf);
       return ResponseEntity.noContent().build();
   }
}
