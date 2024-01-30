package com.fiap.fiapburger.core.ports.out.pagamento;

import com.fiap.fiapburger.infraestructure.api.responses.PagamentoResponse;

import java.util.List;

public interface ListarMeioPagamentoOutputPort {
    List<PagamentoResponse> listaMeio();
}
