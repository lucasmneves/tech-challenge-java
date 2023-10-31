package com.fiap.fiapburger.adapter.out.repository;

import com.fiap.fiapburger.adapter.out.repository.entity.ProdutoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProdutoRepository extends JpaRepository<ProdutoEntity, String> {

    @Query("SELECT p FROM ProdutoEntity p LEFT JOIN FETCH p.categoria WHERE p.id = :id")
    Optional<ProdutoEntity> findByIdWithCategoria(String id);
}