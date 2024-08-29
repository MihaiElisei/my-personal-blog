package com.itschool.my_blog.services;

import com.itschool.my_blog.model.PostDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PostService {

    /**
     * Add a new post
     *
     * @param postDTO the post to add
     * @return the added post
     */
    PostDTO createPost(PostDTO postDTO);

    /**
     * Find all posts
     *
     * @return a list of all posts
     */
    List<PostDTO> getAllPosts();

    /**
     * Find a post by id
     * @param id the id of the post
     * @return the found post
     */
    PostDTO getPostById(Long id);

    /**
     * Update a post by id
     *
     * @param id  the id of the post to update
     * @param postDTO the Post object with the new values to update
     * @return the updated post
     */
    PostDTO updatePost(PostDTO postDTO, Long id);

    /**
     * Delete a user by id
     *
     * @param id the id of the post to delete
     */
    void deletePost(Long id);
}
