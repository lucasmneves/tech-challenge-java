package com.fiap.fiapburger.core.ports.in.cliente;

import com.fiap.fiapburger.infraestructure.api.requests.ClienteRequest;

public interface EditarClienteInputport {
    void editar(ClienteRequest clienteRequest);
}
