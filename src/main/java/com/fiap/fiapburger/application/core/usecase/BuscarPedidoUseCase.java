
package com.fiap.fiapburger.application.core.usecase;

import com.fiap.fiapburger.adapter.in.controller.response.ClienteResponse;
import com.fiap.fiapburger.application.ports.in.BuscarClienteInputPort;
import com.fiap.fiapburger.application.ports.out.BuscarClienteOutputPort;


public class BuscarClienteUseCase implements BuscarClienteInputPort {
    private final BuscarClienteOutputPort buscarClienteOutputPort;
    public BuscarClienteUseCase(BuscarClienteOutputPort buscarClienteOutputPort) {
        this.buscarClienteOutputPort = buscarClienteOutputPort;
    }
    @Override
    public ClienteResponse BuscaCliente(String cpf) {

       return this.buscarClienteOutputPort.buscar(cpf);
    }
}

