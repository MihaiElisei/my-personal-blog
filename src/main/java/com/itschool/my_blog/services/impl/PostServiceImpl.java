package com.itschool.my_blog.services.impl;

import com.itschool.my_blog.entity.Post;
import com.itschool.my_blog.exception.ResourceNotFoundException;
import com.itschool.my_blog.model.PostDTO;
import com.itschool.my_blog.repository.PostRepository;
import com.itschool.my_blog.services.PostService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    /**
     * Add a new post
     *
     * @param postDTO the post to add
     * @return the added post
     */
    @Override
    public PostDTO createPost(PostDTO postDTO) {
        Post newPost = convertToPost(postDTO);
        Post createdPost = postRepository.save(newPost);
        return convertToPostDTO(createdPost);
    }

    /**
     * Find all posts
     *
     * @return a list of all posts
     */
    @Override
    public List<PostDTO> getAllPosts() {

        List<Post> allPosts = postRepository.findAll();

        return allPosts.stream()
                .map(post -> convertToPostDTO(post))
                .collect(Collectors.toList());
    }


    /**
     * Find a post by id
     * @param id the id of the post
     * @return the found post
     */
    @Override
    public PostDTO getPostById(Long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));

        return convertToPostDTO(post);
    }

    /**
     * Update a post by id
     *
     * @param id  the id of the post to update
     * @param postDTO the Post object with the new values to update
     * @return the updated post
     */
    @Override
    public PostDTO updatePost(PostDTO postDTO, Long id) {
        //get post by id from db
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));


        post.setTitle(postDTO.getTitle());
        post.setDescription(postDTO.getDescription());
        post.setContent(postDTO.getContent());
        Post updatedPost = postRepository.save(post);


        return convertToPostDTO(updatedPost);
    }

    /**
     * Delete a user by id
     *
     * @param id the id of the post to delete
     */
    @Override
    public void deletePost(Long id) {
        //get post by id from db
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));

        postRepository.deleteById(id);
    }


    // Convert PostDTO to Post Entity
    private PostDTO convertToPostDTO(Post post) {
        PostDTO postDTO = new PostDTO();
        postDTO.setId(post.getId());
        postDTO.setTitle(post.getTitle());
        postDTO.setDescription(post.getDescription());
        postDTO.setContent(post.getContent());
        return postDTO;
    }

    // Convert Post Entity to PostDTO
    private Post convertToPost(PostDTO postDTO) {
        Post post = new Post();
        post.setId(postDTO.getId());
        post.setTitle(postDTO.getTitle());
        post.setDescription(postDTO.getDescription());
        post.setContent(postDTO.getContent());
        return post;
    }
}
