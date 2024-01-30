package com.fiap.fiapburger.infraestructure.api.mappers;

import com.fiap.fiapburger.infraestructure.api.requests.*;
import com.fiap.fiapburger.infraestructure.api.responses.ItensPedidoResponse;
import com.fiap.fiapburger.infraestructure.api.responses.PedidoResponse;
import com.fiap.fiapburger.infraestructure.persistence.entities.ItensPedidoEntity;
import com.fiap.fiapburger.infraestructure.persistence.entities.PedidoEntity;
import com.fiap.fiapburger.core.domain.entities.ItensPedidoDTO;
import com.fiap.fiapburger.core.domain.entities.PedidoDTO;
import com.fiap.fiapburger.core.domain.entities.ProdutoDTO;
import org.mapstruct.Mapper;

import java.math.BigDecimal;
import java.util.*;


@Mapper(componentModel = "spring")
public interface PedidoMapper {

    PedidoDTO toPedido(SalvarPedidoRequest salvarPedidoRequest);
    PedidoResponse toPedidoResponse(PedidoEntity pedidoEntity);

    static public ItensPedidoDTO adicionarItensPedido(AdicionarItensPedidoRequest adicionarItensPedidoRequest) {
        ItensPedidoDTO itensPedido = new ItensPedidoDTO();
        PedidoDTO pedido = new PedidoDTO();
        ProdutoDTO produto = new ProdutoDTO();

        pedido.setId(adicionarItensPedidoRequest.getIdPedido());
        produto.setId(adicionarItensPedidoRequest.getIdProduto());

        itensPedido.setPedido(pedido);
        itensPedido.setProduto(produto);
        return itensPedido;
    }

    static public PedidoDTO editar(AdicionarItensPedidoRequest adicionarItensPedidoRequest) {
        PedidoDTO pedidoDTO = new PedidoDTO();
        pedidoDTO.setId(adicionarItensPedidoRequest.getIdPedido());
        return pedidoDTO;
    }

    static public ItensPedidoDTO removerItensPedido(RemoverItensPedidoRequest removerItensPedidoRequest) {
        ItensPedidoDTO itensPedido = new ItensPedidoDTO();
        PedidoDTO pedido = new PedidoDTO();
        ProdutoDTO produto = new ProdutoDTO();

        pedido.setId(removerItensPedidoRequest.getIdPedido());
        produto.setId(removerItensPedidoRequest.getIdProduto());

        itensPedido.setPedido(pedido);
        itensPedido.setProduto(produto);
        return itensPedido;
    }

    static public PedidoDTO confirmarPedido(ConfirmarPedidoRequest confirmarPedidoRequest) {
        PedidoDTO pedido = new PedidoDTO();
        pedido.setId(confirmarPedidoRequest.getIdPedido());
        pedido.setDetalhes(confirmarPedidoRequest.getDetalhes());
        return pedido;
    }

    static public PedidoDTO avaliarPedido(AvaliarPedidoRequest avaliarPedidoRequest) {
        PedidoDTO pedido = new PedidoDTO();
        pedido.setId(avaliarPedidoRequest.getIdPedido());
        pedido.setId_satisfacao(avaliarPedidoRequest.getIdSatisfacao());
        return pedido;
    }

    static public List<ItensPedidoResponse> buscarItensPedidoResponse(List<ItensPedidoEntity> pedidoEntity) {
        List<ItensPedidoResponse> listItensResponse = new ArrayList<ItensPedidoResponse>();

        for(int i = 0; i < pedidoEntity.size(); i++){
            var valor = pedidoEntity.get(i).getProduto().getPreco().replace(",", "");

            ItensPedidoResponse itensResponse = new ItensPedidoResponse();
            itensResponse.setIdProduto(pedidoEntity.get(i).getProduto().getId());
            itensResponse.setNome(pedidoEntity.get(i).getProduto().getNome());
            itensResponse.setValor(BigDecimal.valueOf(Double.parseDouble(valor)));
            listItensResponse.add(itensResponse);

        }

        return listItensResponse;
    }

    static PedidoDTO atualizarStatusPedido(AtualizarStatusPedidoRequest atualizarStatusPedidoRequest) {
        PedidoDTO pedidoDTO = new PedidoDTO();
        pedidoDTO.setId_status(atualizarStatusPedidoRequest.getId_status());
        pedidoDTO.setId(atualizarStatusPedidoRequest.getId());
        return pedidoDTO;
    }


}
