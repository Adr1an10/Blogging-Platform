package io.github.angel.raa.dto.request.category;

import io.github.angel.raa.persistence.entity.Category;

import java.util.UUID;

public record CategoryDTO(
        UUID categoryId,
        String name
)
{


    public static CategoryDTO fromCategory(Category category) {
        return new CategoryDTO(category.getCategoryId(), category.getName());
    }
}
