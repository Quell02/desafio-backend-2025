package com.projeto.backend.controller;

import com.projeto.backend.model.Post;
import com.projeto.backend.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private PostService postService;

    // Listar todos os posts
    @GetMapping
    public List<Post> getAllPosts() {
        return postService.getAllPosts();
    }

    // Listar posts de um usuário específico
    @GetMapping("/usuario/{usuarioId}")
    public List<Post> getPostsByUsuario(@PathVariable Long usuarioId) {
        return postService.getPostsByUsuarioId(usuarioId);
    }

    // Buscar post por id
    @GetMapping("/{id}")
    public ResponseEntity<Post> getPostById(@PathVariable Long id) {
        return postService.getPostById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Criar novo post
    @PostMapping
    public Post createPost(@RequestBody Post post) {
        return postService.savePost(post);
    }

    // Atualizar post
    @PutMapping("/{id}")
    public ResponseEntity<Post> updatePost(@PathVariable Long id, @RequestBody Post postDetails) {
        return postService.getPostById(id)
                .map(post -> {
                    post.setTitulo(postDetails.getTitulo());
                    post.setConteudo(postDetails.getConteudo());
                    post.setUsuario(postDetails.getUsuario());
                    Post updated = postService.savePost(post);
                    return ResponseEntity.ok(updated);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // Deletar post
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable Long id) {
        return postService.getPostById(id)
                .map(post -> {
                    postService.deletePost(id);
                    return ResponseEntity.noContent().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
