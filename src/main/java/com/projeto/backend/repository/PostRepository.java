package com.projeto.backend.repository;

import com.projeto.backend.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    // Método opcional para buscar posts de um usuário específico
    List<Post> findByUsuarioId(Long usuarioId);
}
