
package com.fiap.fiapburger.adapter.out.pedido;

import com.fiap.fiapburger.adapter.out.repository.ClienteRepository;
import com.fiap.fiapburger.adapter.out.repository.ItensPedidoRepository;
import com.fiap.fiapburger.adapter.out.repository.PedidoRepository;
import com.fiap.fiapburger.adapter.out.repository.ProdutoRepository;
import com.fiap.fiapburger.adapter.out.repository.entity.ItensPedidoEntity;
import com.fiap.fiapburger.adapter.out.repository.entity.PedidoEntity;
import com.fiap.fiapburger.adapter.out.repository.entity.ProdutoEntity;
import com.fiap.fiapburger.application.core.domain.ItensPedidoDTO;
import com.fiap.fiapburger.application.core.exception.ClienteNaoEncontradoException;
import com.fiap.fiapburger.application.core.exception.ExceptionsMessageEnum;
import com.fiap.fiapburger.application.ports.out.cliente.DeletarClienteOutputPort;
import com.fiap.fiapburger.application.ports.out.pedido.DeletarPedidoOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
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
        var itensPedido = itensPedidoRepository.buscarProdutoEPedido(idProduto, idPedido);
        if(!itensPedido.isEmpty()){
            itensPedidoRepository.deleteById(itensPedido.get(0).getId());
        }else{
            throw new ClienteNaoEncontradoException(ExceptionsMessageEnum.PEDIDO_NAO_ENCONTRADO.value());
        }
    }

    @Override
    public void deletar(String idProduto, String idPedido) {
        String valorStr;
        BigDecimal valor = new BigDecimal("0");

        Optional<ProdutoEntity> produtoEntity = produtoRepository.findById(idProduto);
        if(produtoEntity.isPresent()){
            valorStr = produtoEntity.get().getPreco().replace(",", "");
            valor = BigDecimal.valueOf(Double.parseDouble(valorStr));
        }else{
            throw new ClienteNaoEncontradoException(ExceptionsMessageEnum.PRODUTO_NAO_ENCONTRADO.value());
        }

        Optional<PedidoEntity> pedidoEntity = pedidoRepository.findById(idPedido);
        if(pedidoEntity.isPresent()){
            pedidoEntity.get().setValor_total(pedidoEntity.get().getValor_total().subtract(valor));
            pedidoRepository.save(pedidoEntity.get());
        }else{
            throw new ClienteNaoEncontradoException(ExceptionsMessageEnum.PEDIDO_NAO_ENCONTRADO.value());
        }
    }
}

