package com.fiap.fiapburger.core.ports.in.pagamento;

import com.fiap.fiapburger.adapter.in.controller.response.PagamentoResponse;

import java.util.List;

public interface ListarMeioPagamentoInputPort {
    List<PagamentoResponse> listaMeio();
}
