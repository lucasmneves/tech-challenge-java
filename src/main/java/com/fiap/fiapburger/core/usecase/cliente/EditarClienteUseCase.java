package com.fiap.fiapburger.core.usecase.cliente;

import com.fiap.fiapburger.adapter.in.controller.mapper.ClienteMapper;
import com.fiap.fiapburger.adapter.in.controller.request.ClienteRequest;
import com.fiap.fiapburger.core.domain.entities.ClienteDTO;
import com.fiap.fiapburger.core.ports.in.cliente.EditarClienteInputport;
import com.fiap.fiapburger.core.ports.out.cliente.EditarClienteOutputPort;
import org.springframework.beans.factory.annotation.Autowired;

public class EditarClienteUseCase implements EditarClienteInputport {
    public final EditarClienteOutputPort editarClienteOutputPort;
    private final ClienteMapper clienteMapper;
    public EditarClienteUseCase(EditarClienteOutputPort editarClienteOutputPort, ClienteMapper clienteMapper) {
        this.editarClienteOutputPort = editarClienteOutputPort;
        this.clienteMapper = clienteMapper;
    }
    @Override
    public void editar(ClienteRequest clienteRequest) {
        var cliente = clienteMapper.toCliente(clienteRequest);
        editarClienteOutputPort.editar(cliente);
    }
}
