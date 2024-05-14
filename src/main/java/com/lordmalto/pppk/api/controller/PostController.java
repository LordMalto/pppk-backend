package com.lordmalto.pppk.api.controller;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.lordmalto.pppk.api.model.Post;
import com.lordmalto.pppk.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/post")
public class PostController {

    private PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }


    @GetMapping("/{id}")
    public Optional<Post> getPostById(@PathVariable("id") Long id) {
        return postService.findPostById(id);
    }

    @GetMapping
    public List<Post> getAllPosts() {
        return postService.findAllPosts();
    }

    @PostMapping()
    public Post createPost(@RequestBody Post post) {
        return postService.savePost(post);
    }

    @PutMapping
    public Post updatePost(@RequestBody Post post) {
        return postService.updatePost(post);
    }

    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable("id") Long id) {
        postService.deletePost(id);
    }

}
