package com.fiap.fiapburger.core.ports.out.cliente;

import com.fiap.fiapburger.infraestructure.api.responses.ClienteResponse;

public interface BuscarClienteOutputPort {

    ClienteResponse buscar (String cpf);
}
