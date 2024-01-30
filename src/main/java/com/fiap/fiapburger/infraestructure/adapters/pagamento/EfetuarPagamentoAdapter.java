package com.fiap.fiapburger.infraestructure.adapters.pagamento;

import com.fiap.fiapburger.infraestructure.api.responses.EfetuarPagamentoResponse;
import com.fiap.fiapburger.infraestructure.persistence.repositories.PagamentoRepository;
import com.fiap.fiapburger.infraestructure.persistence.repositories.PedidoRepository;
import com.fiap.fiapburger.infraestructure.persistence.entities.PagamentoEntity;
import com.fiap.fiapburger.infraestructure.persistence.entities.PedidoEntity;
import com.fiap.fiapburger.core.domain.exception.ClienteNaoEncontradoException;
import com.fiap.fiapburger.core.domain.exception.ExceptionsMessageEnum;
import com.fiap.fiapburger.core.ports.out.pagamento.EfetuarPagamentoOutputPort;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class EfetuarPagamentoAdapter implements EfetuarPagamentoOutputPort {

    private final PagamentoRepository pagamentoRepository;
    private final PedidoRepository pedidoRepository;

    public EfetuarPagamentoAdapter(PagamentoRepository pagamentoRepository, PedidoRepository pedidoRepository) {
        this.pagamentoRepository = pagamentoRepository;
        this.pedidoRepository = pedidoRepository;
    }

    @Override
    public EfetuarPagamentoResponse efetuarPagamento(EfetuarPagamentoResponse efetuarPagamentoResponse) {

        Optional<PagamentoEntity> pagamento = pagamentoRepository.findById("3"); //Tipo pagto - Mercado pago
        Optional<PedidoEntity> pedido = pedidoRepository.findById(efetuarPagamentoResponse.getIdPedido());

        Optional<PedidoEntity> pedidoEntity = pedidoRepository.findById(efetuarPagamentoResponse.getIdPedido());
        if(pedidoEntity.isPresent()){
            pedidoEntity.get().setId_status("3");
            pedidoEntity.get().setId_pagamento("3");
            pedidoRepository.save(pedidoEntity.get());
        }else{
            throw new ClienteNaoEncontradoException(ExceptionsMessageEnum.PEDIDO_NAO_ENCONTRADO.value());
        }

        efetuarPagamentoResponse.setTipoPagamento(pagamento.get().getNome());
        efetuarPagamentoResponse.setValor(pedido.get().getValor_total());

        return efetuarPagamentoResponse;
    }
}
