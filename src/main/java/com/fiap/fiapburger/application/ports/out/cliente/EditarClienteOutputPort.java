package com.fiap.fiapburger.application.ports.out.cliente;

import com.fiap.fiapburger.application.core.domain.ClienteDTO;

public interface EditarClienteOutputPort {
    void editar(ClienteDTO cliente);
}
