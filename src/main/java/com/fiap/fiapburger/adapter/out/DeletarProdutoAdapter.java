package com.fiap.fiapburger.adapter.out;

import com.fiap.fiapburger.adapter.out.repository.ProdutoRepository;
import com.fiap.fiapburger.application.ports.out.DeletarProdutoOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeletarProdutoAdapter implements DeletarProdutoOutputPort {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Override
    public void deletar(String id) {
        produtoRepository.deleteById(id);
    }
}