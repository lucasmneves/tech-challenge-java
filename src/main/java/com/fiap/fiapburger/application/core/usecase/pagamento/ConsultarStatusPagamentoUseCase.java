
package com.fiap.fiapburger.application.core.usecase.pagamento;

import com.fiap.fiapburger.adapter.in.controller.response.ConsultarStatusPagamentoResponse;
import com.fiap.fiapburger.adapter.in.controller.response.EfetuarPagamentoResponse;
import com.fiap.fiapburger.application.ports.in.pagamento.ConsultarStatusPagamentoInputPort;
import com.fiap.fiapburger.application.ports.in.pagamento.EfetuarPagamentoInputPort;
import com.fiap.fiapburger.application.ports.out.pagamento.ConsultarStatusPagamentoOutputPort;
import com.fiap.fiapburger.application.ports.out.pagamento.EfetuarPagamentoOutputPort;


public class ConsultarStatusPagamentoUseCase implements ConsultarStatusPagamentoInputPort {
    private final ConsultarStatusPagamentoOutputPort consultarStatusPagamentoOutputPort;
    public ConsultarStatusPagamentoUseCase(ConsultarStatusPagamentoOutputPort consultarStatusPagamentoOutputPort) {
        this.consultarStatusPagamentoOutputPort = consultarStatusPagamentoOutputPort;
    }
    @Override
    public ConsultarStatusPagamentoResponse consultarStatusPagamento(ConsultarStatusPagamentoResponse consultarStatusPagamentoResponse) {

        consultarStatusPagamentoResponse.setStatus("Confirmado");
        consultarStatusPagamentoResponse.setMensagem("Pagamento aprovado!");

        return this.consultarStatusPagamentoOutputPort.consultarStatusPagamento(consultarStatusPagamentoResponse);
    }
}

