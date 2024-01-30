package com.fiap.fiapburger.core.ports.in.historico;

import com.fiap.fiapburger.infraestructure.api.requests.HistoricoRequest;


public interface SalvarHistoricoInputPort {
    void salvar(HistoricoRequest historicoDTO);
}
