
package com.fiap.fiapburger.core.usecase.cliente;

import com.fiap.fiapburger.infraestructure.api.responses.ClienteResponse;
import com.fiap.fiapburger.core.ports.in.cliente.BuscarClienteInputPort;
import com.fiap.fiapburger.core.ports.out.cliente.BuscarClienteOutputPort;


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

