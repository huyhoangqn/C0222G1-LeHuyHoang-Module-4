package com.example.demo.repository;


import com.example.demo.model.Blog;
import com.example.demo.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Integer> {
    Page<Blog> findAllByTitleContaining(String title, Pageable pageable);

    List<Blog> findAllByCategory(Category category);

    @Query(value = "select * from blogs where title like :title", nativeQuery = true)
    List<Blog> search(@Param("title") String title);

}
