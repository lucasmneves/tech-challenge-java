package com.fiap.fiapburger.core.usecase.cliente;

import com.fiap.fiapburger.core.domain.entities.ClienteDTO;
import com.fiap.fiapburger.core.ports.in.cliente.EditarClienteInputport;
import com.fiap.fiapburger.core.ports.out.cliente.EditarClienteOutputPort;

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
