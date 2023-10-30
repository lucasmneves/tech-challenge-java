package com.fiap.fiapburger.adapter.in.controller.mapper;

import com.fiap.fiapburger.adapter.in.controller.request.AdicionarItensPedidoRequest;
import com.fiap.fiapburger.adapter.in.controller.request.ConfirmarPedidoRequest;
import com.fiap.fiapburger.adapter.in.controller.request.RemoverItensPedidoRequest;
import com.fiap.fiapburger.adapter.in.controller.request.SalvarPedidoRequest;
import com.fiap.fiapburger.adapter.in.controller.response.PedidoResponse;
import com.fiap.fiapburger.adapter.out.repository.entity.PedidoEntity;
import com.fiap.fiapburger.application.core.domain.ItensPedidoDTO;
import com.fiap.fiapburger.application.core.domain.PedidoDTO;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface PedidoMapper {

    PedidoDTO toPedido(SalvarPedidoRequest salvarPedidoRequest);
    PedidoResponse toPedidoResponse(PedidoEntity pedidoEntity);

    static public ItensPedidoDTO adicionarItensPedido(AdicionarItensPedidoRequest adicionarItensPedidoRequest) {
        ItensPedidoDTO itensPedido = new ItensPedidoDTO();
        itensPedido.setPedido(adicionarItensPedidoRequest.getIdPedido());
        itensPedido.setProduto(adicionarItensPedidoRequest.getIdProduto());
        return itensPedido;
    }

    static public PedidoDTO editar(AdicionarItensPedidoRequest adicionarItensPedidoRequest) {
        PedidoDTO pedidoDTO = new PedidoDTO();
        pedidoDTO.setId(adicionarItensPedidoRequest.getIdPedido());
        return pedidoDTO;
    }

    static public ItensPedidoDTO removerItensPedido(RemoverItensPedidoRequest removerItensPedidoRequest) {
        ItensPedidoDTO itensPedido = new ItensPedidoDTO();
        itensPedido.setPedido(removerItensPedidoRequest.getIdPedido());
        itensPedido.setProduto(removerItensPedidoRequest.getIdProduto());
        return itensPedido;
    }

    static public PedidoDTO confirmarPedido(ConfirmarPedidoRequest confirmarPedidoRequest) {
        PedidoDTO pedido = new PedidoDTO();

        pedido.setId(confirmarPedidoRequest.getIdPedido());
        pedido.setDetalhes(confirmarPedidoRequest.getDetalhes());

        return pedido;
    }
}
