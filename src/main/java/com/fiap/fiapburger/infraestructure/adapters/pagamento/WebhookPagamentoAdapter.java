package com.fiap.fiapburger.infraestructure.adapters.pagamento;

import com.fiap.fiapburger.infraestructure.api.mappers.PagamentoMapper;
import com.fiap.fiapburger.infraestructure.api.responses.WebhookPagamentoResponse;
import com.fiap.fiapburger.infraestructure.persistence.repositories.PagamentoRepository;
import com.fiap.fiapburger.infraestructure.persistence.repositories.PedidoRepository;
import com.fiap.fiapburger.infraestructure.persistence.entities.PedidoEntity;
import com.fiap.fiapburger.application.ports.out.pagamento.WebhookPagamentoOutputPort;
import com.fiap.fiapburger.core.domain.exception.ClienteNaoEncontradoException;
import com.fiap.fiapburger.core.domain.exception.ExceptionsMessageEnum;
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

        Optional<PedidoEntity> pedido = pedidoRepository.findById(webhookPagamentoResponse.getIdPedido());
        if(pedido.isPresent()){
            pedido.get().setId_status("4");
            pedidoRepository.save(pedido.get());
        }else{
            throw new ClienteNaoEncontradoException(ExceptionsMessageEnum.PEDIDO_NAO_ENCONTRADO.value());
        }

        return webhookPagamentoResponse;
    }
}
