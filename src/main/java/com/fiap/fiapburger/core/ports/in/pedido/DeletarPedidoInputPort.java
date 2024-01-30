package com.fiap.fiapburger.core.ports.in.pedido;

import com.fiap.fiapburger.infraestructure.api.requests.RemoverItensPedidoRequest;

public interface DeletarPedidoInputPort {
    void deletar(RemoverItensPedidoRequest itensPedidoRequest);
    void removerItens(String idProduto, String idPedidos);
}
