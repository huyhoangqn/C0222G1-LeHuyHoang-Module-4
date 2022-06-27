package com.codegym.book.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "borrow_book")
public class BorrowBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private long code;
    @ManyToOne
    @JoinColumn(name = "book_id", referencedColumnName = "id")
    private Book book;

    public BorrowBook() {
    }

    public BorrowBook(int id, long code, Book book) {
        this.id = id;
        this.code = code;
        this.book = book;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }


}
