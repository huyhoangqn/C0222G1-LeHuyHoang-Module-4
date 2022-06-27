package com.codegym.book.model.service;

import com.codegym.book.exception.BookException;
import com.codegym.book.model.entity.BorrowBook;

import java.util.List;

public interface IBorrowBookService {
    List<BorrowBook> findAll();

    BorrowBook findById(Integer id);

    BorrowBook findByCode(Long code);

    void save(BorrowBook borrowBook);

    String createNewBorrow(int idBook) throws BookException;
}
