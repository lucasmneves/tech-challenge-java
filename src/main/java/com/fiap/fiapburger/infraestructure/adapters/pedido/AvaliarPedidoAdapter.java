
package com.fiap.fiapburger.infraestructure.adapters.pedido;

import com.fiap.fiapburger.infraestructure.persistence.repositories.PedidoRepository;
import com.fiap.fiapburger.infraestructure.persistence.entities.PedidoEntity;
import com.fiap.fiapburger.core.domain.entities.PedidoDTO;
import com.fiap.fiapburger.core.domain.exception.ClienteNaoEncontradoException;
import com.fiap.fiapburger.core.domain.exception.ExceptionsMessageEnum;
import com.fiap.fiapburger.core.ports.out.pedido.AvaliarPedidoOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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

