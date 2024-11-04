package com.alexey.crudapp.controller;

import com.alexey.crudapp.model.Label;
import com.alexey.crudapp.model.Post;
import com.alexey.crudapp.model.Status;
import com.alexey.crudapp.repository.PostRepository;
import com.alexey.crudapp.repository.gson.GsonPostRepositoryImpl;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class PostController {
    private final PostRepository postRepository;

    public PostController() {
        this.postRepository = new GsonPostRepositoryImpl();
    }

    public Post createPost(String title, String content, List<Label> labels) {
        Post post = new Post();
        post.setTitle(title);
        post.setContent(content);
        post.setLabels(labels);
        post.setStatus(Status.ACTIVE);
        return postRepository.create(post);
    }

    public Post updatePost(int id, String title, String content, List<Label> labels) {
        Post post = getPostById(id);
        post.setTitle(title);
        post.setContent(content);
        post.setLabels(labels);
        return postRepository.update(post);
    }

    public Post getPostById(int id) {
        return postRepository.getById(id);
    }

    public List<Post> getAllPost() {
        return postRepository.getAll();
    }

    public void deletePostById(int id) {
        postRepository.deleteById(id);
    }
}
