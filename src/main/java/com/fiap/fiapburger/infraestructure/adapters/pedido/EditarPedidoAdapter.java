
package com.fiap.fiapburger.infraestructure.adapters.pedido;

import com.fiap.fiapburger.infraestructure.persistence.repositories.ItensPedidoRepository;
import com.fiap.fiapburger.infraestructure.persistence.repositories.PedidoRepository;
import com.fiap.fiapburger.infraestructure.persistence.repositories.ProdutoRepository;
import com.fiap.fiapburger.infraestructure.persistence.entities.PedidoEntity;
import com.fiap.fiapburger.infraestructure.persistence.entities.ProdutoEntity;
import com.fiap.fiapburger.infraestructure.persistence.mapper.ItensPedidoEntityMapper;
import com.fiap.fiapburger.core.domain.entities.ItensPedidoDTO;
import com.fiap.fiapburger.core.domain.entities.PedidoDTO;
import com.fiap.fiapburger.core.domain.exception.ClienteNaoEncontradoException;
import com.fiap.fiapburger.core.domain.exception.ExceptionsMessageEnum;
import com.fiap.fiapburger.core.ports.out.pedido.EditarPedidoOutputPort;
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
        String valorStr;
        BigDecimal valor = new BigDecimal("0");

        Optional<ProdutoEntity> produtoEntity = produtoRepository.findById(itensPedidoDTO.getProduto().getId());
        if(produtoEntity.isPresent()){
            valorStr = produtoEntity.get().getPreco().replace(",", "");
            valor = BigDecimal.valueOf(Double.parseDouble(valorStr));
        }else{
            throw new ClienteNaoEncontradoException(ExceptionsMessageEnum.PRODUTO_NAO_ENCONTRADO.value());
        }

        Optional<PedidoEntity> pedidoEntity = pedidoRepository.findById(pedido.getId());
        if(pedidoEntity.isPresent()){
            pedidoEntity.get().setValor_total(pedidoEntity.get().getValor_total().add(valor));
            pedidoRepository.save(pedidoEntity.get());
        }else{
            throw new ClienteNaoEncontradoException(ExceptionsMessageEnum.PEDIDO_NAO_ENCONTRADO.value());
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

