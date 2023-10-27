package com.fiap.fiapburger.application.ports.in;

import com.fiap.fiapburger.application.core.domain.ClienteDTO;

public interface EditarClienteInputport {
    void editar(ClienteDTO cliente);
}
