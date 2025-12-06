package com.projeto.backend.service;

import com.projeto.backend.model.Post;
import com.projeto.backend.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    // Listar todos os posts
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    // Listar posts de um usuário específico
    public List<Post> getPostsByUsuarioId(Long usuarioId) {
        return postRepository.findByUsuarioId(usuarioId);
    }

    // Buscar post por id
    public Optional<Post> getPostById(Long id) {
        return postRepository.findById(id);
    }

    // Criar ou atualizar post
    public Post savePost(Post post) {
        return postRepository.save(post);
    }

    // Deletar post
    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }
}
