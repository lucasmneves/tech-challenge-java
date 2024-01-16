package com.fiap.fiapburger.core.ports.out.cliente;

import com.fiap.fiapburger.core.domain.entities.ClienteDTO;

public interface EditarClienteOutputPort {
    void editar(ClienteDTO cliente);
}
