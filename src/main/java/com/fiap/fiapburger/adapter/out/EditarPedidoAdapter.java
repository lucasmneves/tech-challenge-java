package com.fiap.fiapburger.adapter.out;

import com.fiap.fiapburger.adapter.out.repository.ItensPedidoRepository;
import com.fiap.fiapburger.adapter.out.repository.PedidoRepository;
import com.fiap.fiapburger.adapter.out.repository.mapper.ItensPedidoEntityMapper;
import com.fiap.fiapburger.adapter.out.repository.mapper.PedidoEntityMapper;
import com.fiap.fiapburger.application.core.domain.ItensPedidoDTO;
import com.fiap.fiapburger.application.core.domain.PedidoDTO;
import com.fiap.fiapburger.application.ports.out.EditarPedidoOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class EditarPedidoAdapter implements EditarPedidoOutputPort {

    @Autowired
    private ItensPedidoRepository itensPedidoRepository;

    @Autowired
    private ItensPedidoEntityMapper itensPedidoEntityMapper;

    @Override
    public void editar(ItensPedidoDTO itensPedido) {
        var itensPedidoEntity = itensPedidoEntityMapper.toItensPedidoEntity(itensPedido);
        itensPedidoRepository.save(itensPedidoEntity);
    }
}
