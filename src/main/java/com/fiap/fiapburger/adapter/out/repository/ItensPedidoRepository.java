package com.fiap.fiapburger.adapter.out.repository;

import com.fiap.fiapburger.adapter.out.repository.entity.ItensPedidoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ItensPedidoRepository extends JpaRepository<ItensPedidoEntity, String>{
    @Query("From ItensPedidoEntity i where produto.id = :produto and pedido.id = :pedido")
    Optional<ItensPedidoEntity> buscarProdutoEPedido(String produto, String pedido);

    @Query("From ItensPedidoEntity where pedido.id = :pedido")
    List<ItensPedidoEntity> buscarItensPedidoPorId(String pedido);
}
