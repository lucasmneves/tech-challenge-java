package com.fiap.fiapburger.core.ports.in.cliente;


import com.fiap.fiapburger.adapter.in.controller.request.ClienteRequest;
import com.fiap.fiapburger.core.domain.entities.ClienteDTO;

public interface SalvarClienteInputport {
    void salvar(ClienteRequest cliente);
}
