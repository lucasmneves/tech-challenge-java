package com.fiap.fiapburger.adapter.out.pedido;

import com.fiap.fiapburger.adapter.out.repository.PedidoRepository;
import com.fiap.fiapburger.adapter.out.repository.mapper.PedidoEntityMapper;
import com.fiap.fiapburger.application.core.domain.PedidoDTO;
import com.fiap.fiapburger.application.ports.out.pedido.SalvarPedidoOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class SalvarPedidoAdapter implements SalvarPedidoOutputPort {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private PedidoEntityMapper pedidoEntityMapper;

    @Override
    public void salvar(PedidoDTO pedido) {
        var pedidoEntity = pedidoEntityMapper.toPedidoEntity(pedido);
        pedidoRepository.save(pedidoEntity);
    }
}
