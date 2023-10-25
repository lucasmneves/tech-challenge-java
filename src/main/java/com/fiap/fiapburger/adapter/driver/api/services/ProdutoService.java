package com.fiap.fiapburger.adapter.driver.api.services;

import com.fiap.fiapburger.adapter.driver.api.model.ProdutoDTO;
import com.fiap.fiapburger.adapter.driver.api.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    private ProdutoDTO convertToDTO(Produto produto) {
        return new ProdutoDTO(produto.getId(), produto.getNome(), produto.getDescricao(), produto.getPreco(), produto.getCategoria());
    }

    // Converter ProdutoDTO para a entidade Produto
    private Produto convertToEntity(ProdutoDTO produtoDTO) {
        return new Produto(produtoDTO.getId(), produtoDTO.getNome(), produtoDTO.getDescricao(), produtoDTO.getPreco(), produtoDTO.getCategoria());
    }

    public List<ProdutoDTO> listarTodos() {
        return produtoRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public ProdutoDTO buscarPorId(UUID id) {
        Optional<Produto> produto = produtoRepository.findById(id);
        return produto.map(this::convertToDTO).orElse(null);
    }

    public List<ProdutoDTO> buscarPorCategoria(UUID idCategoria) {
        return produtoRepository.findByCategoriaId(idCategoria)
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public ProdutoDTO salvar(ProdutoDTO produtoDTO) {
        Produto produto = produtoRepository.save(convertToEntity(produtoDTO));
        return convertToDTO(produto);
    }

    public ProdutoDTO atualizar(UUID id, ProdutoDTO produtoDTO) {
        if (produtoRepository.existsById(id)) {
            Produto produto = convertToEntity(produtoDTO);
            produto.setId(id); // Garanta que o produto atualizado tenha o ID fornecido
            return convertToDTO(produtoRepository.save(produto));
        } else {
            return null;
        }
    }

    public void deletar(UUID id) {
        produtoRepository.deleteById(id);
    }
}
