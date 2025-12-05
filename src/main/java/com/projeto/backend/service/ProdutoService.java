package com.projeto.backend.service;

import com.projeto.backend.model.Produto;
import com.projeto.backend.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    // LISTAR TODOS
    public List<Produto> listarTodos() {
        return produtoRepository.findAll();
    }

    // BUSCAR POR ID
    public Produto buscarPorId(Long id) {
        return produtoRepository.findById(id).orElse(null);
    }

    // CRIAR PRODUTO
    public Produto salvar(Produto produto) {
        return produtoRepository.save(produto);
    }

    // ATUALIZAR PRODUTO
    public Produto atualizar(Long id, Produto dadosAtualizados) {
        return produtoRepository.findById(id)
                .map(produto -> {
                    produto.setNome(dadosAtualizados.getNome());
                    produto.setPreco(dadosAtualizados.getPreco());
                    return produtoRepository.save(produto);
                }).orElse(null);
    }

    // DELETAR PRODUTO
    public boolean deletar(Long id) {
        return produtoRepository.findById(id)
                .map(produto -> {
                    produtoRepository.delete(produto);
                    return true;
                }).orElse(false);
    }
}
