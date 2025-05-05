package io.github.angel.raa.dto.request.post;

import io.github.angel.raa.persistence.entity.Post;
import jakarta.validation.constraints.NotBlank;

import java.util.Set;
import java.util.UUID;

public record PostDto(
        @NotBlank(message = "Title is required")
        String title,
        @NotBlank(message = "Content is required")
        String content,
        Post.PostStatus status,
        Set<UUID> categoryIds

) {
}
