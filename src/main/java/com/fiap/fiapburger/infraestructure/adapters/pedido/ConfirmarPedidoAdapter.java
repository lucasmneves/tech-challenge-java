
package com.fiap.fiapburger.infraestructure.adapters.pedido;

import com.fiap.fiapburger.infraestructure.persistence.repositories.PedidoRepository;
import com.fiap.fiapburger.infraestructure.persistence.entities.PedidoEntity;
import com.fiap.fiapburger.core.domain.entities.PedidoDTO;
import com.fiap.fiapburger.core.domain.exception.ClienteNaoEncontradoException;
import com.fiap.fiapburger.core.domain.exception.ExceptionsMessageEnum;
import com.fiap.fiapburger.core.ports.out.pedido.ConfirmarPedidoOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Optional;


@Component
public class ConfirmarPedidoAdapter implements ConfirmarPedidoOutputPort {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Override
    public void confirmar(PedidoDTO pedido) {

        BigDecimal valor = new BigDecimal("0");

        Optional<PedidoEntity> pedidoEntity = pedidoRepository.findById(pedido.getId());
        if(pedidoEntity.isPresent()){
            pedidoEntity.get().setDetalhes(pedido.getDetalhes());
            pedidoEntity.get().setId_status("2");
            pedidoRepository.save(pedidoEntity.get());
        }else{
            throw new ClienteNaoEncontradoException(ExceptionsMessageEnum.PEDIDO_NAO_ENCONTRADO.value());
        }
    }
}

