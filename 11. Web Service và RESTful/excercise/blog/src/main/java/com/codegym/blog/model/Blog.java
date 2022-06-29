package com.codegym.blog.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "blog")
@Setter
@Getter
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;

    public Blog() {
    }

    public Blog(Long id, String content) {
        this.id = id;
        this.content = content;
    }
}
