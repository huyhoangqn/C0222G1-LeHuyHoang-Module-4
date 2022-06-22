package com.codegym.blog.repository;

import com.codegym.blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Transactional
public interface BlogRepository extends JpaRepository<Blog, Integer> {
    @Query(value = "select * from blogs where status_delete = 1", nativeQuery = true)
    List<Blog> findAllBlog();

    @Query(value = "select * from blogs where status_delete = 1", nativeQuery = true)
    Page<Blog> findAllBlog(Pageable pageable);

    @Modifying
    @Query(value = "INSERT INTO blogs ( author, content,date,title,category_id, status_delete) VALUES (:author," +
            " :content, :date, :title, :categoryId, 1);", nativeQuery = true)
    void save(@Param("author") String author, @Param("content") String content, @Param("date") Date date,
              @Param("title") String title, @Param("categoryId") Integer categoryId);

    @Query(value = "select * from blogs where id = :codeblog", nativeQuery = true)
    Blog findByIdBlog(@Param("codeblog") Integer id);

    @Modifying
    @Query(value = "UPDATE blogs SET author=:author, content=:content, date=:date, title:=title," +
            " category_id:=categoryId WHERE id=:id", nativeQuery = true)
    void update(@Param("author") String author, @Param("content") String content, @Param("date")
            Date date, @Param("title") String title, @Param("categoryId") Integer categoryId, @Param("id") Integer id);

    @Modifying
    @Query(value = "UPDATE blogs SET status_delete=0 WHERE id=:codeblog", nativeQuery = true)
    void delete(@Param("codeblog") Integer id);

    @Query(value = "select * from blogs where title like :title", nativeQuery = true)
    List<Blog> searchBlog(@Param("title") String title);
}
