package com.fiap.fiapburger.core.usecase.pagamento;

import com.fiap.fiapburger.infraestructure.api.responses.ConsultarStatusPagamentoResponse;
import com.fiap.fiapburger.core.ports.in.pagamento.ConsultarStatusPagamentoInputPort;
import com.fiap.fiapburger.core.ports.out.pagamento.ConsultarStatusPagamentoOutputPort;

public class ConsultarStatusPagamentoUseCase implements ConsultarStatusPagamentoInputPort {
    private final ConsultarStatusPagamentoOutputPort consultarStatusPagamentoOutputPort;
    public ConsultarStatusPagamentoUseCase(ConsultarStatusPagamentoOutputPort consultarStatusPagamentoOutputPort) {
        this.consultarStatusPagamentoOutputPort = consultarStatusPagamentoOutputPort;
    }
    @Override
    public ConsultarStatusPagamentoResponse consultarStatusPagamento(ConsultarStatusPagamentoResponse consultarStatusPagamentoResponse) {

        return this.consultarStatusPagamentoOutputPort.consultarStatusPagamento(consultarStatusPagamentoResponse);
    }
}

