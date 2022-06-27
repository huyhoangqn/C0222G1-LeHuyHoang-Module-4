package com.codegym.book.model.service.impl;

import com.codegym.book.model.Repository.BookRepository;
import com.codegym.book.model.Repository.BorrowBookRepository;
import com.codegym.book.model.entity.Book;
import com.codegym.book.model.entity.BorrowBook;
import com.codegym.book.exception.BookException;
import com.codegym.book.model.service.IBorrowBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class BorrowBookService implements IBorrowBookService {
    @Autowired
    BorrowBookRepository borrowBookRepository;
    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<BorrowBook> findAll() {
        return borrowBookRepository.findAll();
    }

    @Override
    public BorrowBook findById(Integer id) {
        return borrowBookRepository.findById(id).orElse(null);
    }

    @Override
    public BorrowBook findByCode(Long code) {
        return borrowBookRepository.findAllByCode(code);
    }

    @Override
    public void save(BorrowBook borrowBook) {
        borrowBookRepository.save(borrowBook);
    }

    @Override
    public String createNewBorrow(int idBook) throws BookException {
        Book book = bookRepository.findById(idBook).orElse(null);
        if (book == null) {
            throw new BookException("Sách không tồn tại");
        }
        if (book.getQuantity() > 0) {
            book.setQuantity(book.getQuantity() - 1);
            long code = genCode(book);
            BorrowBook borrowBook = new BorrowBook(0, code, book);
            borrowBookRepository.save(borrowBook);
            return "Mượn sách thành công với mã " + code;
        } else {
            throw new BookException("Sách đã cho mượn hết");
        }
    }

    public long genCode(Book book) {
        BorrowBook borrowBook = null;
        long code;
        do {
             code = gen();
            borrowBook = borrowBookRepository.findAllByCodeAndBook(code,book);
        }while (borrowBook!=null);

        return code;
    }

    public long gen() {
        Random r = new Random(System.currentTimeMillis());
        return ((1 + r.nextInt(2)) * 10000 + r.nextInt(10000));
    }

}
