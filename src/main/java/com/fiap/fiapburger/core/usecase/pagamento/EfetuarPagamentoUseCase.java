
package com.fiap.fiapburger.core.usecase.pagamento;

import com.fiap.fiapburger.adapter.in.controller.mapper.PagamentoMapper;
import com.fiap.fiapburger.adapter.in.controller.request.EfetuarPagamentoRequest;
import com.fiap.fiapburger.adapter.in.controller.response.EfetuarPagamentoResponse;
import com.fiap.fiapburger.core.ports.in.pagamento.EfetuarPagamentoInputPort;
import com.fiap.fiapburger.core.ports.out.pagamento.EfetuarPagamentoOutputPort;
import org.springframework.beans.factory.annotation.Autowired;


public class EfetuarPagamentoUseCase implements EfetuarPagamentoInputPort {
    private final EfetuarPagamentoOutputPort efetuarPagamentoOutputPort;
    private final PagamentoMapper pagamentoMapper;

    public EfetuarPagamentoUseCase(EfetuarPagamentoOutputPort efetuarPagamentoOutputPort, PagamentoMapper pagamentoMapper) {
        this.efetuarPagamentoOutputPort = efetuarPagamentoOutputPort;
        this.pagamentoMapper = pagamentoMapper;
    }
    @Override
    public EfetuarPagamentoResponse efetuarPagamento(EfetuarPagamentoRequest efetuarPagamentoRequest) {

        var pagamento = pagamentoMapper.toEfetuarPagamentoResponse(efetuarPagamentoRequest);

        pagamento.setStatus("Pendente");
        pagamento.setQrCode("0000028930293029309COM.MERCADOLIBRE012983012780as9880-28379-2938291-sa1203891702856749012831s08ag89s7Testing21983xx12382718");

        return this.efetuarPagamentoOutputPort.efetuarPagamento(pagamento);
    }
}

