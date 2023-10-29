package com.fiap.fiapburger.adapter.out;

import com.fiap.fiapburger.adapter.out.repository.ClienteRepository;
import com.fiap.fiapburger.adapter.out.repository.ItensPedidoRepository;
import com.fiap.fiapburger.adapter.out.repository.PedidoRepository;
import com.fiap.fiapburger.adapter.out.repository.ProdutoRepository;
import com.fiap.fiapburger.adapter.out.repository.entity.PedidoEntity;
import com.fiap.fiapburger.adapter.out.repository.entity.ProdutoEntity;
import com.fiap.fiapburger.application.core.domain.ItensPedidoDTO;
import com.fiap.fiapburger.application.core.exception.ClienteNaoEncontradoException;
import com.fiap.fiapburger.application.core.exception.ExceptionsMessageEnum;
import com.fiap.fiapburger.application.ports.out.DeletarClienteOutputPort;
import com.fiap.fiapburger.application.ports.out.DeletarPedidoOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Optional;

@Component
public class DeletarPedidoAdapter implements DeletarPedidoOutputPort {

    @Autowired
    ItensPedidoRepository itensPedidoRepository;

    @Autowired
    PedidoRepository pedidoRepository;

    @Autowired
    ProdutoRepository produtoRepository;

    @Override
    public void removerItens(String idProduto, String idPedido) {
        var itensPedido = itensPedidoRepository.findById("1bde1a43-3d9c-42dc-b502-da7be7681611");
        if(itensPedido.isPresent()){
            itensPedidoRepository.deleteById("1bde1a43-3d9c-42dc-b502-da7be7681611");
        }else{
            throw new ClienteNaoEncontradoException(ExceptionsMessageEnum.CLIENTE_NAO_ENCONTRADO.value());
        }
    }

    @Override
    public void deletar(String idProduto, String idPedido) {

        BigDecimal valor = new BigDecimal("0");

        Optional<ProdutoEntity> produtoEntity = produtoRepository.findById(idProduto);
        if(produtoEntity.isPresent()){
            valor = produtoEntity.get().getPreco();
        }else{
            throw new ClienteNaoEncontradoException(ExceptionsMessageEnum.CLIENTE_NAO_ENCONTRADO.value());
        }

        Optional<PedidoEntity> pedidoEntity = pedidoRepository.findById(idPedido);
        if(pedidoEntity.isPresent()){
            pedidoEntity.get().setValor_total(pedidoEntity.get().getValor_total().subtract(valor));
            pedidoRepository.save(pedidoEntity.get());
        }else{
            throw new ClienteNaoEncontradoException(ExceptionsMessageEnum.CLIENTE_NAO_ENCONTRADO.value());
        }
    }
}
