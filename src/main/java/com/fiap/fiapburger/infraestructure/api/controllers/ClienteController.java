package com.fiap.fiapburger.infraestructure.api.controllers;

import com.fiap.fiapburger.infraestructure.api.requests.ClienteRequest;
import com.fiap.fiapburger.infraestructure.api.responses.ClienteResponse;
import com.fiap.fiapburger.core.ports.in.cliente.BuscarClienteInputPort;
import com.fiap.fiapburger.core.ports.in.cliente.DeletarClienteInputPort;
import com.fiap.fiapburger.core.ports.in.cliente.EditarClienteInputport;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.fiap.fiapburger.core.ports.in.cliente.SalvarClienteInputport;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    private final SalvarClienteInputport salvarClienteInputport;
    private final EditarClienteInputport editarClienteInputport;
    private final BuscarClienteInputPort buscarClienteInputPort;
    private final DeletarClienteInputPort deletarClienteInputPort;

    public ClienteController(SalvarClienteInputport salvarClienteInputport, EditarClienteInputport editarClienteInputport, BuscarClienteInputPort buscarClienteInputPort, DeletarClienteInputPort deletarClienteInputPort) {
        this.salvarClienteInputport = salvarClienteInputport;
        this.editarClienteInputport = editarClienteInputport;
        this.buscarClienteInputPort = buscarClienteInputPort;
        this.deletarClienteInputPort = deletarClienteInputPort;
    }

    @PostMapping
    public ResponseEntity<Void> salvar(@Valid @RequestBody ClienteRequest clienteRequest, UriComponentsBuilder uriComponentsBuilder){
        //todo validar a criacao do mesmo cliente;
        salvarClienteInputport.salvar(clienteRequest);
        return ResponseEntity.created(uriComponentsBuilder.path("/cliente/{cpf}").buildAndExpand(clienteRequest.getCpf()).toUri()).build();
    };

    @PatchMapping
    public ResponseEntity<String> editar(@Valid @RequestBody ClienteRequest clienteRequest){
        editarClienteInputport.editar(clienteRequest);
        return ResponseEntity.ok("Cliente " + clienteRequest.getNome() + " atualizado com sucesso!");
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
