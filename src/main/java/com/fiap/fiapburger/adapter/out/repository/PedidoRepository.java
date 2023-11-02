package com.fiap.fiapburger.adapter.out.repository;

import com.fiap.fiapburger.adapter.out.repository.entity.PedidoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PedidoRepository extends JpaRepository<PedidoEntity, String>{
}
