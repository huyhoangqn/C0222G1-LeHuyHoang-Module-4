package com.codegym.repository;

import com.codegym.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface IBlogRepository extends JpaRepository<Blog, Integer> {
    @Query(value = "select * from blog where status_delete = 1", nativeQuery = true)
    List<Blog> findAllBlog();

    @Modifying
    @Query(value = "INSERT INTO blog ( content_blog, name_blog, status_delete) VALUES (:nameblog, :contentblog,1);", nativeQuery = true)
    void save(@Param("nameblog") String nameblog, @Param("contentblog") String contentblog);

    @Query(value = "select * from blog where code_blog = :codeblog", nativeQuery = true)
    Blog findByIdBlog(@Param("codeblog") Integer codeBlog);

    @Modifying
    @Query(value = "UPDATE blog SET name_blog=:nameblog, content_blog=:contentblog WHERE code_blog=:codeblog", nativeQuery = true)
    void update(@Param("nameblog") String nameBlog, @Param("contentblog") String contentBlog, @Param("codeblog") Integer codeblog);

    @Modifying
    @Query(value = "UPDATE blog SET status_delete=0 WHERE code_blog=:codeblog", nativeQuery = true)
    void delete(@Param("codeblog") Integer codeBlog);

    @Query(value = "select * from blog where name_blog like :nameblog", nativeQuery = true)
    List<Blog> searchBlog(@Param("nameblog") String nameBlog);
}
