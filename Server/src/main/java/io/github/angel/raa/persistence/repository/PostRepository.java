package io.github.angel.raa.persistence.repository;

import io.github.angel.raa.persistence.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PostRepository extends  JpaRepository<Post, UUID>{
    Optional<Post> findByTitle(String title);
    Optional<Post> findBySlug(String slug);
    boolean existsByTitle(String title);
    boolean existsBySlug(String slug);
    List<Post> findByStatus(Post.PostStatus status);
    List<Post> findByAuthorId(UUID authorId);
    List<Post> findByCategoriesCategoryId(UUID categoryId);

}

