package com.fiap.fiapburger.application.ports.in.historico;

import com.fiap.fiapburger.application.core.domain.HistoricoDTO;
import lombok.Data;


public interface SalvarHistoricoInputPort {
    void salvar(HistoricoDTO historicoDTO);
}
