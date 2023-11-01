package com.fiap.fiapburger.adapter.out.repository;

import com.fiap.fiapburger.adapter.in.controller.response.ProdutoResponse;
import com.fiap.fiapburger.adapter.out.repository.entity.ProdutoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProdutoRepository extends JpaRepository<ProdutoEntity, String> {
    Optional<ProdutoEntity> findByNome(String nome);

    @Query("SELECT new com.fiap.fiapburger.adapter.in.controller.response.ProdutoResponse(p.id, p.nome,c.nome,p.descricao,p.preco) FROM ProdutoCCatEntity p JOIN p.categoria c")
    List<ProdutoResponse> findAllProdutosComCategoria();

    @Query("SELECT new com.fiap.fiapburger.adapter.out.repository.entity.ProdutoEntity(p.id, p.nome,p.descricao,p.url_imagem,p.preco,c.nome) FROM ProdutoCCatEntity p JOIN p.categoria c  WHERE p.id = :id")
    Optional<ProdutoEntity> findById(String id);

}


