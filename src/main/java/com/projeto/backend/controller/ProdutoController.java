package com.projeto.backend.controller;

import com.projeto.backend.model.Produto;
import com.projeto.backend.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
@CrossOrigin(origins = "*") // libera para o frontend
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    // ➤ LISTAR TODOS
    @GetMapping
    public List<Produto> listarTodos() {
        return produtoService.listarTodos();
    }

    // ➤ BUSCAR POR ID
    @GetMapping("/{id}")
    public ResponseEntity<Produto> buscarPorId(@PathVariable Long id) {
        Produto produto = produtoService.buscarPorId(id);
        if (produto != null) {
            return ResponseEntity.ok(produto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // ➤ CRIAR PRODUTO
    @PostMapping
    public Produto criar(@RequestBody Produto produto) {
        return produtoService.salvar(produto);
    }

    // ➤ ATUALIZAR PRODUTO
    @PutMapping("/{id}")
    public ResponseEntity<Produto> atualizar(@PathVariable Long id, @RequestBody Produto dados) {
        Produto atualizado = produtoService.atualizar(id, dados);
        if (atualizado != null) {
            return ResponseEntity.ok(atualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // ➤ DELETAR PRODUTO
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        boolean removido = produtoService.deletar(id);
        if (removido) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
