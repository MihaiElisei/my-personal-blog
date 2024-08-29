package com.itschool.my_blog.controller;

import com.itschool.my_blog.model.PostDTO;
import com.itschool.my_blog.services.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/posts")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) { // Constructor-based dependency injection. It injects the PostService bean into the PostController
        this.postService = postService;
    }

    // Show form to create a new post
    @GetMapping("/new")
    public String showCreatePostForm(Model model) {
        model.addAttribute("post", new PostDTO());
        return "create_post";
    }

    // Handle form submission to create a new post
    @PostMapping
    public String createPost(@ModelAttribute("post") PostDTO postDTO) {
        postService.createPost(postDTO);
        return "redirect:/posts";
    }

    // Show all posts
    @GetMapping
    public String getAllPosts(Model model) {
        List<PostDTO> posts = postService.getAllPosts();
        model.addAttribute("posts", posts);
        return "posts";
    }

    // Show form to update a post
    @GetMapping("/edit/{id}")
    public String showEditPostForm(@PathVariable("id") Long id, Model model) {
        PostDTO postDTO = postService.getPostById(id);
        model.addAttribute("post", postDTO);
        return "edit_post";
    }

    // Handle form submission to update a post
    @PostMapping("/edit/{id}")
    public String updatePost(@PathVariable("id") Long id, @ModelAttribute("post") PostDTO postDTO) {
        postService.updatePost(postDTO, id);
        return "redirect:/posts";
    }

    // Handle request to delete a post
    @GetMapping("/delete/{id}")
    public String deletePostById(@PathVariable("id") Long id) {
        postService.deletePost(id);
        return "redirect:/posts";
    }
}
