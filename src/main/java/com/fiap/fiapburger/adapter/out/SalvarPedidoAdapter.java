package com.fiap.fiapburger.adapter.out;

import com.fiap.fiapburger.adapter.out.repository.ClienteRepository;
import com.fiap.fiapburger.adapter.out.repository.PedidoRepository;
import com.fiap.fiapburger.adapter.out.repository.mapper.ClienteEntityMapper;
import com.fiap.fiapburger.adapter.out.repository.mapper.PedidoEntityMapper;
import com.fiap.fiapburger.application.core.domain.ClienteDTO;
import com.fiap.fiapburger.application.core.domain.PedidoDTO;
import com.fiap.fiapburger.application.ports.out.SalvarClienteOutputPort;
import com.fiap.fiapburger.application.ports.out.SalvarPedidoOutputPort;
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
