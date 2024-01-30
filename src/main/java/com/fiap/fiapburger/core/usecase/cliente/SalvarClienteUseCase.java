package com.fiap.fiapburger.core.usecase.cliente;

import com.fiap.fiapburger.infraestructure.api.mappers.ClienteMapper;
import com.fiap.fiapburger.infraestructure.api.requests.ClienteRequest;
import com.fiap.fiapburger.core.ports.in.cliente.SalvarClienteInputport;
import com.fiap.fiapburger.core.ports.out.cliente.SalvarClienteOutputPort;

public class SalvarClienteUseCase implements SalvarClienteInputport {

    private final SalvarClienteOutputPort salvarClienteOutputPort;
    private final ClienteMapper clienteMapper;
    public SalvarClienteUseCase(SalvarClienteOutputPort salvarClienteOutputPort, ClienteMapper clienteMapper) {
        this.salvarClienteOutputPort = salvarClienteOutputPort;
        this.clienteMapper = clienteMapper;
    }
    @Override
    public void salvar(ClienteRequest clienteRequest) {
        var cliente = clienteMapper.toCliente(clienteRequest);
        salvarClienteOutputPort.salvar(cliente);
    }
}
