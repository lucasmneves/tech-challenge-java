package com.fiap.fiapburger.application.ports.out.cliente;

import com.fiap.fiapburger.adapter.in.controller.response.ClienteResponse;

public interface BuscarClienteOutputPort {

    ClienteResponse buscar (String cpf);
}
