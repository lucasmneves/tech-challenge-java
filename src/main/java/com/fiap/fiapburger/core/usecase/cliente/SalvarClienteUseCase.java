package com.fiap.fiapburger.core.usecase.cliente;

import com.fiap.fiapburger.core.domain.entities.ClienteDTO;
import com.fiap.fiapburger.core.ports.in.cliente.SalvarClienteInputport;
import com.fiap.fiapburger.core.ports.out.cliente.SalvarClienteOutputPort;


public class SalvarClienteUseCase implements SalvarClienteInputport {

    private final SalvarClienteOutputPort salvarClienteOutputPort;

    public SalvarClienteUseCase(SalvarClienteOutputPort salvarClienteOutputPort) {
        this.salvarClienteOutputPort = salvarClienteOutputPort;
    }
    @Override
    public void salvar(ClienteDTO cliente) {

        salvarClienteOutputPort.salvar(cliente);
    }
}
