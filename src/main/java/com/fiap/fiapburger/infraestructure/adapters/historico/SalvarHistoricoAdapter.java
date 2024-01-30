package com.fiap.fiapburger.infraestructure.adapters.historico;

import com.fiap.fiapburger.infraestructure.persistence.repositories.HistoricoRepository;
import com.fiap.fiapburger.infraestructure.persistence.mapper.HistoricoMapper;
import com.fiap.fiapburger.core.domain.entities.HistoricoDTO;
import com.fiap.fiapburger.core.ports.out.historico.SalvarHistoricoOutputPort;
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
