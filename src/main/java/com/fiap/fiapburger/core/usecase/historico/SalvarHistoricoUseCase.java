package com.fiap.fiapburger.core.usecase.historico;

import com.fiap.fiapburger.core.domain.entities.HistoricoDTO;
import com.fiap.fiapburger.core.ports.in.historico.SalvarHistoricoInputPort;
import com.fiap.fiapburger.core.ports.out.historico.SalvarHistoricoOutputPort;

public class SalvarHistoricoUseCase implements SalvarHistoricoInputPort{

    private SalvarHistoricoOutputPort salvarHistoricoOutputPort;

    public SalvarHistoricoUseCase(SalvarHistoricoOutputPort salvarHistoricoOutputPort) {
        this.salvarHistoricoOutputPort = salvarHistoricoOutputPort;
    }

    @Override
    public void salvar(HistoricoDTO historicoDTO) {
        salvarHistoricoOutputPort.salvar(historicoDTO);
    };
}
