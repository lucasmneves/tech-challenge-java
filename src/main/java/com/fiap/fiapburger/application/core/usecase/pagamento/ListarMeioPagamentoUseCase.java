
package com.fiap.fiapburger.application.core.usecase.pagamento;

import com.fiap.fiapburger.adapter.in.controller.response.PagamentoResponse;
import com.fiap.fiapburger.application.ports.in.pagamento.ListarMeioPagamentoInputPort;
import com.fiap.fiapburger.application.ports.out.pagamento.ListarMeioPagamentoOutputPort;

import java.util.List;


public class ListarMeioPagamentoUseCase implements ListarMeioPagamentoInputPort {
    private final ListarMeioPagamentoOutputPort listarMeioPagamentoOutputPort;
    public ListarMeioPagamentoUseCase(ListarMeioPagamentoOutputPort listarMeioPagamentoOutputPort) {
        this.listarMeioPagamentoOutputPort = listarMeioPagamentoOutputPort;
    }
    @Override
    public List<PagamentoResponse> listaMeio() {
        return this.listarMeioPagamentoOutputPort.listaMeio();
    }
}

