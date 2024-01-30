package com.fiap.fiapburger.core.usecase.historico;

import com.fiap.fiapburger.infraestructure.api.requests.HistoricoRequest;
import com.fiap.fiapburger.infraestructure.persistence.mapper.HistoricoMapper;
import com.fiap.fiapburger.core.ports.in.historico.SalvarHistoricoInputPort;
import com.fiap.fiapburger.core.ports.out.historico.SalvarHistoricoOutputPort;

public class SalvarHistoricoUseCase implements SalvarHistoricoInputPort{

    private final SalvarHistoricoOutputPort salvarHistoricoOutputPort;
    private final HistoricoMapper historicoMapper;

    public SalvarHistoricoUseCase(SalvarHistoricoOutputPort salvarHistoricoOutputPort, HistoricoMapper historicoMapper) {
        this.salvarHistoricoOutputPort = salvarHistoricoOutputPort;
        this.historicoMapper = historicoMapper;
    }

    @Override
    public void salvar(HistoricoRequest historicoRequest) {
        var historico = historicoMapper.toHistoricoDTO(historicoRequest);
        salvarHistoricoOutputPort.salvar(historico);
    };
}
