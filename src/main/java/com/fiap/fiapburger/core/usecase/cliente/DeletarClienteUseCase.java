package com.fiap.fiapburger.core.usecase.cliente;

import com.fiap.fiapburger.core.ports.in.cliente.DeletarClienteInputPort;
import com.fiap.fiapburger.core.ports.out.cliente.DeletarClienteOutputPort;

public class DeletarClienteUseCase implements DeletarClienteInputPort {

    private final DeletarClienteOutputPort deletarClienteOutputPort;

    public DeletarClienteUseCase(DeletarClienteOutputPort deletarClienteOutputPort) {
        this.deletarClienteOutputPort = deletarClienteOutputPort;
    }

    @Override
    public void deletar(String cpf) {
        deletarClienteOutputPort.deletar(cpf);
    }
}
