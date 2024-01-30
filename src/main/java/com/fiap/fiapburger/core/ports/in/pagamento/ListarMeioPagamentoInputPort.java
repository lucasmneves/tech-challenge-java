package com.fiap.fiapburger.core.ports.in.pagamento;

import com.fiap.fiapburger.infraestructure.api.responses.PagamentoResponse;
import java.util.List;

public interface ListarMeioPagamentoInputPort {
    List<PagamentoResponse> listaMeio();
}
