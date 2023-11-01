package com.fiap.fiapburger.application.ports.out.pagamento;

import com.fiap.fiapburger.adapter.in.controller.response.PagamentoResponse;
import com.fiap.fiapburger.adapter.in.controller.response.PedidoResponse;

public interface ListarMeioPagamentoOutputPort {
    PagamentoResponse listaMeio();
}
