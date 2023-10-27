package com.fiap.fiapburger.application.core.usecase;

import com.fiap.fiapburger.application.core.domain.ClienteDTO;
import com.fiap.fiapburger.application.ports.in.SalvarClienteInputport;
import com.fiap.fiapburger.application.ports.out.SalvarClienteOutputPort;


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
