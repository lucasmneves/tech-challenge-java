package com.fiap.fiapburger.adapter.out.pedido;

import com.fiap.fiapburger.adapter.out.repository.PedidoRepository;
import com.fiap.fiapburger.adapter.out.repository.entity.PedidoEntity;
import com.fiap.fiapburger.adapter.out.repository.mapper.PedidoEntityMapper;
import com.fiap.fiapburger.core.domain.entities.PedidoDTO;
import com.fiap.fiapburger.core.ports.out.pedido.SalvarPedidoOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class SalvarPedidoAdapter implements SalvarPedidoOutputPort {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private PedidoEntityMapper pedidoEntityMapper;

    @Override
    public PedidoEntity salvar(PedidoDTO pedido) {
        List<PedidoEntity> listaPedidos = pedidoRepository.findAll();
        var pedidoEntity = pedidoEntityMapper.toPedidoEntity(pedido);
        pedidoEntity.setSenha(listaPedidos.size() + 1);
        return pedidoRepository.save(pedidoEntity);
    }
}
