package com.fiap.fiapburger.core.ports.out.pagamento;

import com.fiap.fiapburger.adapter.in.controller.response.PagamentoResponse;

import java.util.List;

public interface ListarMeioPagamentoOutputPort {
    List<PagamentoResponse> listaMeio();
}
