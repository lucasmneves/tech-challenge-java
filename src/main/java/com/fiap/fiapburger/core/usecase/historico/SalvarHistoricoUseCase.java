package com.fiap.fiapburger.core.usecase.historico;

import com.fiap.fiapburger.adapter.in.controller.request.HistoricoRequest;
import com.fiap.fiapburger.adapter.out.repository.mapper.HistoricoMapper;
import com.fiap.fiapburger.core.domain.entities.HistoricoDTO;
import com.fiap.fiapburger.core.ports.in.historico.SalvarHistoricoInputPort;
import com.fiap.fiapburger.core.ports.out.historico.SalvarHistoricoOutputPort;
import org.springframework.beans.factory.annotation.Autowired;

public class SalvarHistoricoUseCase implements SalvarHistoricoInputPort{

    private final SalvarHistoricoOutputPort salvarHistoricoOutputPort;
    @Autowired
    private HistoricoMapper historicoMapper;

    public SalvarHistoricoUseCase(SalvarHistoricoOutputPort salvarHistoricoOutputPort) {
        this.salvarHistoricoOutputPort = salvarHistoricoOutputPort;
    }

    @Override
    public void salvar(HistoricoRequest historicoRequest) {
        var historico = historicoMapper.toHistoricoDTO(historicoRequest);
        salvarHistoricoOutputPort.salvar(historico);
    };
}