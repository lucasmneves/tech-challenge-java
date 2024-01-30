package com.fiap.fiapburger.infraestructure.adapters.pagamento;

import com.fiap.fiapburger.infraestructure.api.mappers.PagamentoMapper;
import com.fiap.fiapburger.infraestructure.api.responses.PagamentoResponse;
import com.fiap.fiapburger.infraestructure.persistence.repositories.PagamentoRepository;
import com.fiap.fiapburger.infraestructure.persistence.entities.PagamentoEntity;
import com.fiap.fiapburger.core.ports.out.pagamento.ListarMeioPagamentoOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.List;

@Component
public class ListarMeioPagamentoAdapter implements ListarMeioPagamentoOutputPort {

    @Autowired
    private PagamentoRepository pagamentoRepository;

    @Autowired
    PagamentoMapper pagamentoMapper;

    @Override
    public List<PagamentoResponse> listaMeio() {

        List<PagamentoEntity> pagamento = pagamentoRepository.findAll();
        pagamento.remove(0);
        return pagamentoMapper.toListaPagamentoResponse(pagamento);

    }

}
