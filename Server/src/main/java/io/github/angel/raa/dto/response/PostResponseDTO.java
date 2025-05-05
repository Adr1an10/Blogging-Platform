package io.github.angel.raa.dto.response;

import io.github.angel.raa.dto.request.category.CategoryDTO;
import io.github.angel.raa.persistence.entity.Post;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

public class PostResponseDTO {
    private UUID postId;
    private String title;
    private String slug;
    private String content;
    private Post.PostStatus status;
    private LocalDateTime publishedAt;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private UUID authorId;
    private String authorName;
    private Set<CategoryDTO> categories;

    public PostResponseDTO() {
    }

    public PostResponseDTO(UUID postId, String title, String slug, String content, Post.PostStatus status, LocalDateTime publishedAt, LocalDateTime createdAt, LocalDateTime updatedAt, UUID authorId, String authorName, Set<CategoryDTO> categories) {
        this.postId = postId;
        this.title = title;
        this.slug = slug;
        this.content = content;
        this.status = status;
        this.publishedAt = publishedAt;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.authorId = authorId;
        this.authorName = authorName;
        this.categories = categories;
    }

    public UUID getPostId() {
        return postId;
    }

    public void setPostId(UUID postId) {
        this.postId = postId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Post.PostStatus getStatus() {
        return status;
    }

    public void setStatus(Post.PostStatus status) {
        this.status = status;
    }

    public LocalDateTime getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(LocalDateTime publishedAt) {
        this.publishedAt = publishedAt;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public UUID getAuthorId() {
        return authorId;
    }

    public void setAuthorId(UUID authorId) {
        this.authorId = authorId;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public Set<CategoryDTO> getCategories() {
        return categories;
    }

    public void setCategories(Set<CategoryDTO> categories) {
        this.categories = categories;
    }

    public static PostResponseDTO fromPost(Post post) {
        return new PostResponseDTO(
                post.getPostId(),
                post.getTitle(),
                post.getSlug(),
                post.getContent(),
                post.getStatus(),
                post.getPublishedAt(),
                post.getCreatedAt(),
                post.getUpdatedAt(),
                post.getAuthorId(),
                post.getAuthor().getUsername(),
                post.getCategories().stream().map(CategoryDTO::fromCategory).collect(Collectors.toSet())
        );
    }
}
