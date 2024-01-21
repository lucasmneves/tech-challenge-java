package com.fiap.fiapburger.core.ports.in.historico;

import com.fiap.fiapburger.adapter.in.controller.request.HistoricoRequest;
import com.fiap.fiapburger.core.domain.entities.HistoricoDTO;


public interface SalvarHistoricoInputPort {
    void salvar(HistoricoRequest historicoDTO);
}
