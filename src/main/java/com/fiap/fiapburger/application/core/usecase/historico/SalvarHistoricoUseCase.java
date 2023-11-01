package com.fiap.fiapburger.application.core.usecase.historico;

import com.fiap.fiapburger.application.core.domain.HistoricoDTO;
import com.fiap.fiapburger.application.ports.in.historico.SalvarHistoricoInputPort;
import com.fiap.fiapburger.application.ports.out.historico.SalvarHistoricoOutputPort;

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
