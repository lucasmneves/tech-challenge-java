package com.fiap.fiapburger.application.ports.in;

import com.fiap.fiapburger.adapter.in.controller.response.PagamentoResponse;
import com.fiap.fiapburger.adapter.in.controller.response.PedidoResponse;

public interface ListarMeioPagamentoInputPort {
    PagamentoResponse listaMeio();
}
