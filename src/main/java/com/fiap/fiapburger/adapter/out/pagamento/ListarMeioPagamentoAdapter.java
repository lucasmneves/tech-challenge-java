package com.fiap.fiapburger.adapter.out.pagamento;

import com.fiap.fiapburger.adapter.in.controller.mapper.PagamentoMapper;
import com.fiap.fiapburger.adapter.in.controller.response.PagamentoResponse;
import com.fiap.fiapburger.adapter.out.repository.PagamentoRepository;
import com.fiap.fiapburger.adapter.out.repository.entity.PagamentoEntity;
import com.fiap.fiapburger.application.ports.out.pagamento.ListarMeioPagamentoOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.List;
import java.util.Optional;

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
