package com.fiap.fiapburger.adapter.out.historico;

import com.fiap.fiapburger.adapter.out.repository.HistoricoRepository;
import com.fiap.fiapburger.adapter.out.repository.mapper.HistoricoMapper;
import com.fiap.fiapburger.application.core.domain.HistoricoDTO;
import com.fiap.fiapburger.application.ports.out.historico.SalvarHistoricoOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SalvarHistoricoAdapter implements SalvarHistoricoOutputPort {

    @Autowired
    HistoricoRepository historicoRepository;

    @Autowired
    HistoricoMapper historicoMapper;
    @Override
    public void salvar(HistoricoDTO historicoDTO) {
        var historicoEntity = historicoMapper.toHistoricoEntity(historicoDTO);
        historicoRepository.save(historicoEntity);
    }
}
