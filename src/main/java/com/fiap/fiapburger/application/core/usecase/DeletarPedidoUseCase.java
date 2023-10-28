package com.fiap.fiapburger.application.core.usecase;

import com.fiap.fiapburger.application.ports.in.DeletarClienteInputPort;
import com.fiap.fiapburger.application.ports.out.DeletarClienteOutputPort;

public class DeletarClienteUseCase implements DeletarClienteInputPort {

    private DeletarClienteOutputPort deletarClienteOutputPort;

    public DeletarClienteUseCase(DeletarClienteOutputPort deletarClienteOutputPort) {
        this.deletarClienteOutputPort = deletarClienteOutputPort;
    }

    @Override
    public void deletar(String cpf) {
        deletarClienteOutputPort.deletar(cpf);
    }
}
