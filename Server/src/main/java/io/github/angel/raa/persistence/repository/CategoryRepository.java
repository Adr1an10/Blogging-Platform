package io.github.angel.raa.persistence.repository;

import io.github.angel.raa.persistence.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface CategoryRepository extends JpaRepository<Category, UUID> {
    Boolean existsBySlug(String slug);
    Optional<Category> findBySlug(String slug);
    Boolean existsByName(String name);
    Optional<Category> findByName(String name);

}
