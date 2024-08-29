package com.itschool.my_blog.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data //Lombok annotations to generate automatically all constructors all getters and all setters
@AllArgsConstructor
@NoArgsConstructor
@Entity // Annotation to tell Hibernate that this class is an entity and should be persisted in the database
@Table(name="posts") // Annotation to tell Hibernate that this entity should be mapped to the 'posts' table in the database
public class Post {

    @Id // Annotation to tell Hibernate that this field is the primary key in the table
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Annotation to tell Hibernate to generate new ids for us. GenerationType.IDENTITY will use the database's auto-increment feature (will increment the id by 1)
    private Long id;

    @NotEmpty
    @Column(unique = true)
    private String title;

    @NotEmpty
    private String description;

    @NotEmpty
    private String content;

}
