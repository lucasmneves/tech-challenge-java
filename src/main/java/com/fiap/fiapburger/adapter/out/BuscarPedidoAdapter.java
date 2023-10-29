package com.fiap.fiapburger.adapter.out;

import com.fiap.fiapburger.adapter.in.controller.mapper.ClienteMapper;
import com.fiap.fiapburger.adapter.in.controller.mapper.PedidoMapper;
import com.fiap.fiapburger.adapter.in.controller.response.ClienteResponse;
import com.fiap.fiapburger.adapter.in.controller.response.PedidoResponse;
import com.fiap.fiapburger.adapter.out.repository.ClienteRepository;
import com.fiap.fiapburger.adapter.out.repository.PedidoRepository;
import com.fiap.fiapburger.adapter.out.repository.entity.ClienteEntity;
import com.fiap.fiapburger.adapter.out.repository.entity.PedidoEntity;
import com.fiap.fiapburger.application.core.exception.ClienteNaoEncontradoException;
import com.fiap.fiapburger.application.core.exception.ExceptionsMessageEnum;
import com.fiap.fiapburger.application.ports.out.BuscarClienteOutputPort;
import com.fiap.fiapburger.application.ports.out.BuscarPedidoOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class BuscarPedidoAdapter implements BuscarPedidoOutputPort {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    PedidoMapper pedidoMapper;

    @Override
    public PedidoResponse buscar(String id) {

        System.out.print("teste: " + id);
        Optional<PedidoEntity> pedido = pedidoRepository.findById(id);

        if(pedido.isPresent()){
            return pedidoMapper.toPedidoResponse(pedido.get());
        }else{
            throw new ClienteNaoEncontradoException(ExceptionsMessageEnum.CLIENTE_NAO_ENCONTRADO.value());
        }
    }


}
