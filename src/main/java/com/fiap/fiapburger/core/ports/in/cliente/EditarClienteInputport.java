package com.fiap.fiapburger.core.ports.in.cliente;

import com.fiap.fiapburger.core.domain.entities.ClienteDTO;

public interface EditarClienteInputport {
    void editar(ClienteDTO cliente);
}
