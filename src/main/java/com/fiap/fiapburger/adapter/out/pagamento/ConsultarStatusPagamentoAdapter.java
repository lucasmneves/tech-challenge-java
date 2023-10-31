package com.fiap.fiapburger.adapter.out.pagamento;

import com.fiap.fiapburger.adapter.in.controller.mapper.PagamentoMapper;
import com.fiap.fiapburger.adapter.in.controller.response.ConsultarStatusPagamentoResponse;
import com.fiap.fiapburger.adapter.in.controller.response.EfetuarPagamentoResponse;
import com.fiap.fiapburger.adapter.out.repository.PagamentoRepository;
import com.fiap.fiapburger.adapter.out.repository.PedidoRepository;
import com.fiap.fiapburger.adapter.out.repository.entity.PagamentoEntity;
import com.fiap.fiapburger.adapter.out.repository.entity.PedidoEntity;
import com.fiap.fiapburger.application.core.exception.ClienteNaoEncontradoException;
import com.fiap.fiapburger.application.core.exception.ExceptionsMessageEnum;
import com.fiap.fiapburger.application.ports.out.pagamento.ConsultarStatusPagamentoOutputPort;
import com.fiap.fiapburger.application.ports.out.pagamento.EfetuarPagamentoOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ConsultarStatusPagamentoAdapter implements ConsultarStatusPagamentoOutputPort {

    @Autowired
    private PagamentoRepository pagamentoRepository;

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    PagamentoMapper pagamentoMapper;

    @Override
    public ConsultarStatusPagamentoResponse consultarStatusPagamento(ConsultarStatusPagamentoResponse consultarStatusPagamentoResponse) {

        Optional<PagamentoEntity> pagamento = pagamentoRepository.findById("3"); //Tipo pagto - Mercado pago
        //Optional<PedidoEntity> pedido = pedidoRepository.findById(consultarStatusPagamentoResponse.getIdPedido());

        Optional<PedidoEntity> pedido = pedidoRepository.findById(consultarStatusPagamentoResponse.getIdPedido());
        if(pedido.isPresent()){
            consultarStatusPagamentoResponse.setTipoPagamento(pagamento.get().getNome());
            consultarStatusPagamentoResponse.setValor(pedido.get().getValor_total());
            consultarStatusPagamentoResponse.setSenha(pedido.get().getSenha());
        }else{
            throw new ClienteNaoEncontradoException(ExceptionsMessageEnum.PEDIDO_NAO_ENCONTRADO.value());
        }

        return consultarStatusPagamentoResponse;
    }
}
