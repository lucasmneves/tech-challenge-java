package com.fiap.fiapburger.core.ports.in.pedido;

public interface DeletarPedidoInputPort {
    void deletar(String idProduto, String idPedido);
    void removerItens(String idProduto, String idPedidos);
}
