
package com.fiap.fiapburger.core.usecase.pagamento;

import com.fiap.fiapburger.adapter.in.controller.response.EfetuarPagamentoResponse;
import com.fiap.fiapburger.core.ports.in.pagamento.EfetuarPagamentoInputPort;
import com.fiap.fiapburger.core.ports.out.pagamento.EfetuarPagamentoOutputPort;


public class EfetuarPagamentoUseCase implements EfetuarPagamentoInputPort {
    private final EfetuarPagamentoOutputPort efetuarPagamentoOutputPort;
    public EfetuarPagamentoUseCase(EfetuarPagamentoOutputPort efetuarPagamentoOutputPort) {
        this.efetuarPagamentoOutputPort = efetuarPagamentoOutputPort;
    }
    @Override
    public EfetuarPagamentoResponse efetuarPagamento(EfetuarPagamentoResponse efetuarPagamentoResponse) {

        efetuarPagamentoResponse.setStatus("Pendente");
        efetuarPagamentoResponse.setQrCode("0000028930293029309COM.MERCADOLIBRE012983012780as9880-28379-2938291-sa1203891702856749012831s08ag89s7Testing21983xx12382718");

        return this.efetuarPagamentoOutputPort.efetuarPagamento(efetuarPagamentoResponse);
    }
}

