package com.fiap.fiapburger.core.ports.out.cliente;


import com.fiap.fiapburger.core.domain.entities.ClienteDTO;

public interface SalvarClienteOutputPort {
    void salvar(ClienteDTO cliente);
}
