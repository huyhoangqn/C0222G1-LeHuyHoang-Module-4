package com.codegym.model;

import javax.persistence.*;

@Entity(name = "blog")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "code_blog")
    private Integer codeBlog;
    @Column(name = "name_blog")
    private String nameBlog;
    @Column(name = "content_blog")
    private String contentBlog;
    @Column(name = "status_delete")
    private int statusDelete;

    public Blog() {
    }

    public Blog(int codeBlog, String nameBlog, String contentBlog, int statusDelete) {
        this.codeBlog = codeBlog;
        this.nameBlog = nameBlog;
        this.contentBlog = contentBlog;
        this.statusDelete = statusDelete;
    }

    public Integer getCodeBlog() {
        return codeBlog;
    }

    public void setCodeBlog(Integer codeBlog) {
        this.codeBlog = codeBlog;
    }

    public String getNameBlog() {
        return nameBlog;
    }

    public void setNameBlog(String nameBlog) {
        this.nameBlog = nameBlog;
    }

    public String getContentBlog() {
        return contentBlog;
    }

    public void setContentBlog(String contentBlog) {
        this.contentBlog = contentBlog;
    }

    public int getStatusDelete() {
        return statusDelete;
    }

    public void setStatusDelete(int statusDelete) {
        this.statusDelete = statusDelete;
    }
}
