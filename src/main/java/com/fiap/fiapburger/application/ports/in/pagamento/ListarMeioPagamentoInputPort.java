package com.fiap.fiapburger.application.ports.in.pagamento;

import com.fiap.fiapburger.adapter.in.controller.response.PagamentoResponse;
import com.fiap.fiapburger.adapter.in.controller.response.PedidoResponse;

import java.util.List;

public interface ListarMeioPagamentoInputPort {
    List<PagamentoResponse> listaMeio();
}
