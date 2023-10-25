package com.fiap.fiapburger.adapter.driver.api.repository;
import com.fiap.fiapburger.adapter.driver.api.model.ProdutoDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;


public interface ProdutoRepository extends JpaRepository<ProdutoDTO, UUID> {

//precisa testar

        List<ProdutoDTO> findByCategoriaId(UUID idCategoria);
}
