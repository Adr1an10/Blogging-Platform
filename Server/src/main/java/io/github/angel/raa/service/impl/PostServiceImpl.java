package io.github.angel.raa.service.impl;

import io.github.angel.raa.dto.request.post.PostDto;
import io.github.angel.raa.dto.response.PostResponseDTO;
import io.github.angel.raa.dto.response.Response;
import io.github.angel.raa.exception.DuplicateSlugException;
import io.github.angel.raa.exception.DuplicateTitleException;
import io.github.angel.raa.persistence.entity.Category;
import io.github.angel.raa.persistence.entity.Post;
import io.github.angel.raa.persistence.repository.CategoryRepository;
import io.github.angel.raa.persistence.repository.PostRepository;
import io.github.angel.raa.service.AuthenticationService;
import io.github.angel.raa.service.PostService;
import io.github.angel.raa.utils.Slugify;
import jakarta.transaction.Transactional;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;
    private final AuthenticationService authenticationService;
    private final CategoryRepository categoryRepository;

    public PostServiceImpl(PostRepository postRepository, AuthenticationService authenticationService, CategoryRepository categoryRepository) {
        this.postRepository = postRepository;
        this.authenticationService = authenticationService;
        this.categoryRepository = categoryRepository;
    }

    @Transactional
    @Override
    public Response<PostResponseDTO> createPost(@NotNull PostDto postDto) {
        validateUniqueTitleAndSlug(postDto.title(), Slugify.slugify(postDto.title()));
        Post post = new Post();
        mapDtoToPost(postDto, post);
        PostResponseDTO dto = mapEntityToDto( postRepository.save(post));
        return Response.<PostResponseDTO>builder()
                .message("Post created successfully")
                .success(true)
                .code(201)
                .data(dto)
                .timestamp(LocalDateTime.now())
                .buildResponse();

    }



    @Override
    public Response<PostResponseDTO> updatePost(PostDto postDto, String slug) {
        return null;
    }

    @Override
    public Response<PostResponseDTO> getPostBySlug(String slug) {
        return null;
    }

    @Override
    public List<PostResponseDTO> getAllPosts() {
        return List.of();
    }

    @Override
    public Response<String> deletePost(String slug) {
        return null;
    }
    private void mapDtoToPost(@NotNull PostDto postDto, @NotNull Post post) {
        UUID currentUserId = authenticationService.getCurrentUserId();
        String slug = Slugify.slugify(postDto.title());
        post.setTitle(postDto.title());
        post.setSlug(slug);
        post.setContent(postDto.content());
        try {
            post.setStatus(postDto.status());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid status: " + postDto.status());
        }
        post.setAuthorId(currentUserId);
        if (postDto.categoryIds() != null) {
            Set<Category> categories = postDto.categoryIds().stream()
                    .map(categoryId -> categoryRepository.findById(categoryId)
                            .orElseThrow(() -> new IllegalArgumentException("Category not found with id: " + categoryId)))
                    .collect(Collectors.toSet());
            post.setCategories(categories);
        } else {
            post.setCategories(new HashSet<>());
        }
        if (post.getStatus() == Post.PostStatus.PUBLISHED && post.getPublishedAt() == null) {
            post.setPublishedAt(LocalDateTime.now());
        }
    }

    private void validateUniqueTitle(String title) {
        if (postRepository.existsByTitle(title)) {
            throw new DuplicateTitleException("Title already exists: " + title);
        }
    }

    private void validateUniqueSlug(String slug) {
        if (postRepository.existsBySlug(slug)) {
            throw new DuplicateSlugException("Slug already exists: " + slug);
        }
    }

    private void validateUniqueTitleAndSlug(String title, String slug) {
        validateUniqueTitle(title);
        validateUniqueSlug(slug);
    }

    private PostResponseDTO mapEntityToDto(Post save) {
        return PostResponseDTO.fromPost(save);
    }


}
