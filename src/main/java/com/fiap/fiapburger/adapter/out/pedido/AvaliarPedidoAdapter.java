
package com.fiap.fiapburger.adapter.out.pedido;

import com.fiap.fiapburger.adapter.out.repository.PedidoRepository;
import com.fiap.fiapburger.adapter.out.repository.entity.PedidoEntity;
import com.fiap.fiapburger.application.core.domain.PedidoDTO;
import com.fiap.fiapburger.application.core.exception.ClienteNaoEncontradoException;
import com.fiap.fiapburger.application.core.exception.ExceptionsMessageEnum;
import com.fiap.fiapburger.application.ports.out.pedido.AvaliarPedidoOutputPort;
import com.fiap.fiapburger.application.ports.out.pedido.ConfirmarPedidoOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Optional;


@Component
public class AvaliarPedidoAdapter implements AvaliarPedidoOutputPort {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Override
    public void avaliar(PedidoDTO pedido) {

        Optional<PedidoEntity> pedidoEntity = pedidoRepository.findById(pedido.getId());
        if(pedidoEntity.isPresent()){
            pedidoEntity.get().setId_satisfacao(pedido.getId_satisfacao());
            pedidoRepository.save(pedidoEntity.get());
        }else{
            throw new ClienteNaoEncontradoException(ExceptionsMessageEnum.PEDIDO_NAO_ENCONTRADO.value());
        }
    }
}

