package com.fiap.fiapburger.core.ports.out.cliente;

import com.fiap.fiapburger.adapter.in.controller.response.ClienteResponse;

public interface BuscarClienteOutputPort {

    ClienteResponse buscar (String cpf);
}
