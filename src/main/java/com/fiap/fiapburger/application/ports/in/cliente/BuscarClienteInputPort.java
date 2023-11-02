package com.fiap.fiapburger.application.ports.in.cliente;

import com.fiap.fiapburger.adapter.in.controller.response.ClienteResponse;

public interface BuscarClienteInputPort {
    ClienteResponse BuscaCliente(String cpf);
}
