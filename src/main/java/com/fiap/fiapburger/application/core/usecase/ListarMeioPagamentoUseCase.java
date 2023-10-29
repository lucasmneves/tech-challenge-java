
package com.fiap.fiapburger.application.core.usecase;

import com.fiap.fiapburger.adapter.in.controller.response.PagamentoResponse;
import com.fiap.fiapburger.adapter.in.controller.response.PedidoResponse;
import com.fiap.fiapburger.application.ports.in.BuscarPedidoInputPort;
import com.fiap.fiapburger.application.ports.in.ListarMeioPagamentoInputPort;
import com.fiap.fiapburger.application.ports.out.BuscarPedidoOutputPort;
import com.fiap.fiapburger.application.ports.out.ListarMeioPagamentoOutputPort;


public class ListarMeioPagamentoUseCase implements ListarMeioPagamentoInputPort {
    private final ListarMeioPagamentoOutputPort listarMeioPagamentoOutputPort;
    public ListarMeioPagamentoUseCase(ListarMeioPagamentoOutputPort listarMeioPagamentoOutputPort) {
        this.listarMeioPagamentoOutputPort = listarMeioPagamentoOutputPort;
    }
    @Override
    public PagamentoResponse listaMeio() {
       return this.listarMeioPagamentoOutputPort.listaMeio();
    }
}
