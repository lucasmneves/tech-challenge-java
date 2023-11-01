package com.fiap.fiapburger.adapter.out.pagamento;

import com.fiap.fiapburger.adapter.in.controller.mapper.PagamentoMapper;
import com.fiap.fiapburger.adapter.in.controller.response.PagamentoResponse;
import com.fiap.fiapburger.adapter.out.repository.PagamentoRepository;
import com.fiap.fiapburger.adapter.out.repository.entity.PagamentoEntity;
import com.fiap.fiapburger.application.ports.out.pagamento.ListarMeioPagamentoOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ListarMeioPagamentoAdapter implements ListarMeioPagamentoOutputPort {

    @Autowired
    private PagamentoRepository pagamentoRepository;

    @Autowired
    PagamentoMapper pagamentoMapper;

    @Override
    public PagamentoResponse listaMeio() {

        Optional<PagamentoEntity> pagamento = pagamentoRepository.findById("1");

        return pagamentoMapper.toListaPagamentoResponse(pagamento.get());

    }


}
