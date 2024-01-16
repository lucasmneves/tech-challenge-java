package com.fiap.fiapburger.core.ports.in.cliente;

import com.fiap.fiapburger.adapter.in.controller.response.ClienteResponse;

public interface BuscarClienteInputPort {
    ClienteResponse BuscaCliente(String cpf);
}
