package com.fiap.fiapburger.application.ports.in;

import com.fiap.fiapburger.adapter.in.controller.response.ClienteResponse;

public interface BuscarClienteInputPort {
    ClienteResponse BuscaCliente(String cpf);
}
