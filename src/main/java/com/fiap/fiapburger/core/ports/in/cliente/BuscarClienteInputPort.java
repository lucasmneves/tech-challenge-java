package com.fiap.fiapburger.core.ports.in.cliente;

import com.fiap.fiapburger.infraestructure.api.responses.ClienteResponse;

public interface BuscarClienteInputPort {
    ClienteResponse BuscaCliente(String cpf);
}
