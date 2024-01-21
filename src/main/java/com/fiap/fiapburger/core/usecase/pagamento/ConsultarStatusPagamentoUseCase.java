
package com.fiap.fiapburger.core.usecase.pagamento;

import com.fiap.fiapburger.adapter.in.controller.response.ConsultarStatusPagamentoResponse;
import com.fiap.fiapburger.core.ports.in.pagamento.ConsultarStatusPagamentoInputPort;
import com.fiap.fiapburger.core.ports.out.pagamento.ConsultarStatusPagamentoOutputPort;


public class ConsultarStatusPagamentoUseCase implements ConsultarStatusPagamentoInputPort {
    private final ConsultarStatusPagamentoOutputPort consultarStatusPagamentoOutputPort;
    public ConsultarStatusPagamentoUseCase(ConsultarStatusPagamentoOutputPort consultarStatusPagamentoOutputPort) {
        this.consultarStatusPagamentoOutputPort = consultarStatusPagamentoOutputPort;
    }
    @Override
    public ConsultarStatusPagamentoResponse consultarStatusPagamento(String idPedido) {

        ConsultarStatusPagamentoResponse statusPagamento = new ConsultarStatusPagamentoResponse();
        statusPagamento.setIdPedido(idPedido);
        statusPagamento.setStatus("Confirmado");
        statusPagamento.setMensagem("Pagamento aprovado!");

        return this.consultarStatusPagamentoOutputPort.consultarStatusPagamento(statusPagamento);
    }
}

