
package com.fiap.fiapburger.core.usecase.pagamento;

import com.fiap.fiapburger.infraestructure.api.responses.PagamentoResponse;
import com.fiap.fiapburger.core.ports.in.pagamento.ListarMeioPagamentoInputPort;
import com.fiap.fiapburger.core.ports.out.pagamento.ListarMeioPagamentoOutputPort;

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

