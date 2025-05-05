package io.github.angel.raa.service;

import io.github.angel.raa.dto.request.post.PostDto;
import io.github.angel.raa.dto.response.PostResponseDTO;
import io.github.angel.raa.dto.response.Response;

import java.util.List;

public interface PostService {
    Response<PostResponseDTO> createPost(PostDto postDto);
    Response<PostResponseDTO> updatePost(PostDto postDto, String slug);
    Response<PostResponseDTO> getPostBySlug(String slug);
    List<PostResponseDTO> getAllPosts();
    Response<String> deletePost(String slug);



}
