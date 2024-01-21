package com.fiap.fiapburger.core.ports.in.cliente;

import com.fiap.fiapburger.adapter.in.controller.request.ClienteRequest;
import com.fiap.fiapburger.core.domain.entities.ClienteDTO;

public interface EditarClienteInputport {
    void editar(ClienteRequest clienteRequest);
}
