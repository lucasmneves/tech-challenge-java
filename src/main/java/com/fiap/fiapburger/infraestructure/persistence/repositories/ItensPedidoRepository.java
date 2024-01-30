package com.fiap.fiapburger.infraestructure.persistence.repositories;

import com.fiap.fiapburger.infraestructure.persistence.entities.ItensPedidoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ItensPedidoRepository extends JpaRepository<ItensPedidoEntity, String>{
    @Query("From ItensPedidoEntity i where produto.id = :produto and pedido.id = :pedido")
    List<ItensPedidoEntity> buscarProdutoEPedido(String produto, String pedido);
    @Query("From ItensPedidoEntity where pedido.id = :pedido")
    List<ItensPedidoEntity> buscarItensPedidoPorId(String pedido);
}
