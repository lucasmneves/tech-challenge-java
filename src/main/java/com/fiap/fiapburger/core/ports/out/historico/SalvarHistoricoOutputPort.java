package com.fiap.fiapburger.core.ports.out.historico;

import com.fiap.fiapburger.core.domain.entities.HistoricoDTO;

public interface SalvarHistoricoOutputPort {
    void salvar(HistoricoDTO historicoDTO);
}
