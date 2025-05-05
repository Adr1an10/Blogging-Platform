package io.github.angel.raa.dto.request.post;

import jakarta.validation.constraints.NotBlank;

public record CreatePost(
        @NotBlank(message = "Title is required")
        String title,
        @NotBlank(message = "Content is required")
        String content
) {
}
