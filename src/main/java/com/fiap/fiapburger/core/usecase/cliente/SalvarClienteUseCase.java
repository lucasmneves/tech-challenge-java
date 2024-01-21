package com.fiap.fiapburger.core.usecase.cliente;

import com.fiap.fiapburger.adapter.in.controller.mapper.ClienteMapper;
import com.fiap.fiapburger.adapter.in.controller.request.ClienteRequest;
import com.fiap.fiapburger.core.domain.entities.ClienteDTO;
import com.fiap.fiapburger.core.ports.in.cliente.SalvarClienteInputport;
import com.fiap.fiapburger.core.ports.out.cliente.SalvarClienteOutputPort;
import org.springframework.beans.factory.annotation.Autowired;

public class SalvarClienteUseCase implements SalvarClienteInputport {

    private final SalvarClienteOutputPort salvarClienteOutputPort;
    @Autowired
    private ClienteMapper clienteMapper;
    public SalvarClienteUseCase(SalvarClienteOutputPort salvarClienteOutputPort) {
        this.salvarClienteOutputPort = salvarClienteOutputPort;
    }
    @Override
    public void salvar(ClienteRequest clienteRequest) {
        var cliente = clienteMapper.toCliente(clienteRequest);
        salvarClienteOutputPort.salvar(cliente);
    }
}
