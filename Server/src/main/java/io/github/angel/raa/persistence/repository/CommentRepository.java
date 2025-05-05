package io.github.angel.raa.persistence.repository;

import io.github.angel.raa.persistence.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface CommentRepository extends JpaRepository<Comment, UUID>{
    List<Comment> findByPostId(UUID postId);
    List<Comment> findByAuthorId(UUID authorId);
    // Find all top-level comments for a post (comments without a parent)
    List<Comment> findByPostIdAndParentCommentIsNull(UUID postId);

}
