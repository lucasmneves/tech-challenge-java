package com.fiap.fiapburger.application.core.usecase.cliente;

import com.fiap.fiapburger.application.core.domain.ClienteDTO;
import com.fiap.fiapburger.application.ports.in.cliente.SalvarClienteInputport;
import com.fiap.fiapburger.application.ports.out.cliente.SalvarClienteOutputPort;


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
