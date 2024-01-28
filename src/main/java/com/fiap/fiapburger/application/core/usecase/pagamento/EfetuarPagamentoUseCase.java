
package com.fiap.fiapburger.application.core.usecase.pagamento;

import com.fiap.fiapburger.adapter.in.controller.request.EfetuarPagamentoRequest;
import com.fiap.fiapburger.adapter.in.controller.response.EfetuarPagamentoResponse;
import com.fiap.fiapburger.application.ports.in.pagamento.EfetuarPagamentoInputPort;
import com.fiap.fiapburger.application.ports.out.pagamento.EfetuarPagamentoOutputPort;

import java.math.BigDecimal;


public class EfetuarPagamentoUseCase implements EfetuarPagamentoInputPort {
    private final EfetuarPagamentoOutputPort efetuarPagamentoOutputPort;
    public EfetuarPagamentoUseCase(EfetuarPagamentoOutputPort efetuarPagamentoOutputPort) {
        this.efetuarPagamentoOutputPort = efetuarPagamentoOutputPort;
    }
    @Override
    public EfetuarPagamentoResponse efetuarPagamento(EfetuarPagamentoResponse efetuarPagamentoResponse) {

        efetuarPagamentoResponse.setStatus("Pendente");
        efetuarPagamentoResponse.setQrCode("0000028930293029309COM.MERCADOLIBRE012983012780as9880-28379-2938291-sa1203891702856749012831s08ag89s7Testing21983xx12382718");
        efetuarPagamentoResponse.setUrlWebhook("localhost:8989/pagamento/" + efetuarPagamentoResponse.getIdPedido());
        return this.efetuarPagamentoOutputPort.efetuarPagamento(efetuarPagamentoResponse);
    }
}

