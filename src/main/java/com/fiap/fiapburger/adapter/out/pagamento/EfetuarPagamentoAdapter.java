package com.fiap.fiapburger.adapter.out.pagamento;

import com.fiap.fiapburger.adapter.in.controller.mapper.PagamentoMapper;
import com.fiap.fiapburger.adapter.in.controller.request.EfetuarPagamentoRequest;
import com.fiap.fiapburger.adapter.in.controller.response.EfetuarPagamentoResponse;
import com.fiap.fiapburger.adapter.in.controller.response.PagamentoResponse;
import com.fiap.fiapburger.adapter.out.repository.PagamentoRepository;
import com.fiap.fiapburger.adapter.out.repository.PedidoRepository;
import com.fiap.fiapburger.adapter.out.repository.entity.PagamentoEntity;
import com.fiap.fiapburger.adapter.out.repository.entity.PedidoEntity;
import com.fiap.fiapburger.application.core.exception.ClienteNaoEncontradoException;
import com.fiap.fiapburger.application.core.exception.ExceptionsMessageEnum;
import com.fiap.fiapburger.application.ports.out.pagamento.EfetuarPagamentoOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class EfetuarPagamentoAdapter implements EfetuarPagamentoOutputPort {

    @Autowired
    private PagamentoRepository pagamentoRepository;

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    PagamentoMapper pagamentoMapper;

    @Override
    public EfetuarPagamentoResponse efetuarPagamento(EfetuarPagamentoResponse efetuarPagamentoResponse) {

        Optional<PagamentoEntity> pagamento = pagamentoRepository.findById("3"); //Tipo pagto - Mercado pago
        Optional<PedidoEntity> pedido = pedidoRepository.findById(efetuarPagamentoResponse.getIdPedido());

        Optional<PedidoEntity> pedidoEntity = pedidoRepository.findById(efetuarPagamentoResponse.getIdPedido());
        if(pedidoEntity.isPresent()){
            pedidoEntity.get().setId_status("3");
            pedidoRepository.save(pedidoEntity.get());
        }else{
            throw new ClienteNaoEncontradoException(ExceptionsMessageEnum.PEDIDO_NAO_ENCONTRADO.value());
        }

        efetuarPagamentoResponse.setTipoPagamento(pagamento.get().getNome());
        efetuarPagamentoResponse.setValor(pedido.get().getValor_total());

        return efetuarPagamentoResponse;
    }
}
