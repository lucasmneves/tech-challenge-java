package com.fiap.fiapburger.adapter.out.pedido;

import com.fiap.fiapburger.adapter.out.repository.ItensPedidoRepository;
import com.fiap.fiapburger.adapter.out.repository.PedidoRepository;
import com.fiap.fiapburger.adapter.out.repository.ProdutoRepository;
import com.fiap.fiapburger.adapter.out.repository.entity.PedidoEntity;
import com.fiap.fiapburger.adapter.out.repository.entity.ProdutoEntity;
import com.fiap.fiapburger.adapter.out.repository.mapper.ItensPedidoEntityMapper;
import com.fiap.fiapburger.application.core.domain.ItensPedidoDTO;
import com.fiap.fiapburger.application.core.domain.PedidoDTO;
import com.fiap.fiapburger.application.core.exception.ClienteNaoEncontradoException;
import com.fiap.fiapburger.application.core.exception.ExceptionsMessageEnum;
import com.fiap.fiapburger.application.ports.out.pedido.EditarPedidoOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;
import java.util.Optional;


@Component
public class EditarPedidoAdapter implements EditarPedidoOutputPort {

    @Autowired
    private ItensPedidoRepository itensPedidoRepository;

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private ItensPedidoEntityMapper itensPedidoEntityMapper;

    @Override
    public void adicionarItens(ItensPedidoDTO itensPedido) {
        var itensPedidoEntity = itensPedidoEntityMapper.toItensPedidoEntity(itensPedido);
        itensPedidoRepository.save(itensPedidoEntity);
    }

    @Override
    public void editar(PedidoDTO pedido, ItensPedidoDTO itensPedidoDTO) {

        BigDecimal valor = new BigDecimal("0");

        Optional<ProdutoEntity> produtoEntity = produtoRepository.findById(Long.valueOf(itensPedidoDTO.getProduto()));
        if (produtoEntity.isPresent()) {
            valor = produtoEntity.get().getPreco();
        } else {
            throw new ClienteNaoEncontradoException(ExceptionsMessageEnum.CLIENTE_NAO_ENCONTRADO.value());
        }

        Optional<PedidoEntity> pedidoEntity = pedidoRepository.findById(pedido.getId());
        if (pedidoEntity.isPresent()) {
            pedidoEntity.get().setValor_total(pedidoEntity.get().getValor_total().add(valor));
            pedidoRepository.save(pedidoEntity.get());
        } else {
            throw new ClienteNaoEncontradoException(ExceptionsMessageEnum.CLIENTE_NAO_ENCONTRADO.value());
        }
    }

    @Override
    public void atualizarStatusPedido(PedidoDTO pedidoDTO) {
        pedidoRepository.findById(pedidoDTO.getId())
                .map(pedidoEntity -> {
                    pedidoEntity.setId_status(pedidoDTO.getId_status());
                    if (Objects.equals(pedidoDTO.getId_status(), "7")
                            && Objects.equals(pedidoEntity.getId_pagamento(),"0")) {
                        throw new RuntimeException("Pagamento não realizado!");
                    } else if (Objects.equals(pedidoDTO.getId_status(), "7")) {
                        pedidoEntity.setData_hora_fim(new Date());
                    }
                    return pedidoEntity;
                })
                .map(pedidoRepository::save)
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado!"));
    }
}

