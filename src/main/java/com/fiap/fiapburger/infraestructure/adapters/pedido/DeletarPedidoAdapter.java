
package com.fiap.fiapburger.infraestructure.adapters.pedido;

import com.fiap.fiapburger.infraestructure.persistence.repositories.ItensPedidoRepository;
import com.fiap.fiapburger.infraestructure.persistence.repositories.PedidoRepository;
import com.fiap.fiapburger.infraestructure.persistence.repositories.ProdutoRepository;
import com.fiap.fiapburger.infraestructure.persistence.entities.PedidoEntity;
import com.fiap.fiapburger.infraestructure.persistence.entities.ProdutoEntity;
import com.fiap.fiapburger.core.domain.exception.ClienteNaoEncontradoException;
import com.fiap.fiapburger.core.domain.exception.ExceptionsMessageEnum;
import com.fiap.fiapburger.core.ports.out.pedido.DeletarPedidoOutputPort;
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
            //todo:criar uma exception para pedido
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

