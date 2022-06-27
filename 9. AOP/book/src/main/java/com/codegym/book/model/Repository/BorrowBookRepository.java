package com.codegym.book.model.Repository;

import com.codegym.book.model.entity.Book;
import com.codegym.book.model.entity.BorrowBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BorrowBookRepository extends JpaRepository<BorrowBook, Integer> {
    BorrowBook findAllByCode(long code);

    BorrowBook findAllByCodeAndBook(long code, Book book);
}
