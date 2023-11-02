package com.fiap.fiapburger.application.ports.out.historico;

import com.fiap.fiapburger.application.core.domain.HistoricoDTO;

public interface SalvarHistoricoOutputPort {
    void salvar(HistoricoDTO historicoDTO);
}
