package com.fiap.fiapburger.adapter.out.pagamento;

import com.fiap.fiapburger.adapter.in.controller.mapper.PagamentoMapper;
import com.fiap.fiapburger.adapter.in.controller.response.WebhookPagamentoResponse;
import com.fiap.fiapburger.adapter.out.repository.PagamentoRepository;
import com.fiap.fiapburger.adapter.out.repository.PedidoRepository;
import com.fiap.fiapburger.adapter.out.repository.entity.PagamentoEntity;
import com.fiap.fiapburger.adapter.out.repository.entity.PedidoEntity;
import com.fiap.fiapburger.application.core.exception.ClienteNaoEncontradoException;
import com.fiap.fiapburger.application.core.exception.ExceptionsMessageEnum;
import com.fiap.fiapburger.application.ports.out.pagamento.WebhookPagamentoOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class WebhookPagamentoAdapter implements WebhookPagamentoOutputPort {

    @Autowired
    private PagamentoRepository pagamentoRepository;

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    PagamentoMapper pagamentoMapper;

    @Override
    public WebhookPagamentoResponse webhookPagamento(WebhookPagamentoResponse webhookPagamentoResponse) {

        Optional<PagamentoEntity> pagamento = pagamentoRepository.findById("3"); //Tipo pagto - Mercado pago
        //Optional<PedidoEntity> pedido = pedidoRepository.findById(consultarStatusPagamentoResponse.getIdPedido());

        Optional<PedidoEntity> pedido = pedidoRepository.findById(webhookPagamentoResponse.getIdPedido());
        if(pedido.isPresent()){
            webhookPagamentoResponse.setTipoPagamento(pagamento.get().getNome());
            webhookPagamentoResponse.setValor(pedido.get().getValor_total());
            webhookPagamentoResponse.setSenha(pedido.get().getSenha());
        }else{
            throw new ClienteNaoEncontradoException(ExceptionsMessageEnum.PEDIDO_NAO_ENCONTRADO.value());
        }

        return webhookPagamentoResponse;
    }
}
