package com.fiap.fiapburger.application.ports.in.cliente;


import com.fiap.fiapburger.application.core.domain.ClienteDTO;

public interface SalvarClienteInputport {
    void salvar(ClienteDTO cliente);
}
