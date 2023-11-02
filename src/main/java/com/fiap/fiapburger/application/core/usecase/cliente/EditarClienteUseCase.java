package com.fiap.fiapburger.application.core.usecase.cliente;

import com.fiap.fiapburger.application.core.domain.ClienteDTO;
import com.fiap.fiapburger.application.ports.in.cliente.EditarClienteInputport;
import com.fiap.fiapburger.application.ports.out.cliente.EditarClienteOutputPort;

public class EditarClienteUseCase implements EditarClienteInputport {
    public final EditarClienteOutputPort editarClienteOutputPort;
    public EditarClienteUseCase(EditarClienteOutputPort editarClienteOutputPort) {
        this.editarClienteOutputPort = editarClienteOutputPort;
    }
    @Override
    public void editar(ClienteDTO cliente) {

        editarClienteOutputPort.editar(cliente);
    }
}
