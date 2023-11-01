package com.fiap.fiapburger.application.ports.out.cliente;


import com.fiap.fiapburger.application.core.domain.ClienteDTO;

public interface SalvarClienteOutputPort {
    void salvar(ClienteDTO cliente);
}
