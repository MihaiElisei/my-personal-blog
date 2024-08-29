package com.itschool.my_blog.repository;

import com.itschool.my_blog.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    // this repository will inherit all the methods from JpaRepository (e.g. CRUD operations)

}
