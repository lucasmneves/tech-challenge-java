package com.fiap.fiapburger.core.ports.in.historico;

import com.fiap.fiapburger.core.domain.entities.HistoricoDTO;


public interface SalvarHistoricoInputPort {
    void salvar(HistoricoDTO historicoDTO);
}
