package com.codegym.book.controller;

import com.codegym.book.exception.BookException;
import com.codegym.book.model.service.IBookService;
import com.codegym.book.model.service.IBorrowBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class BookController {
    @Autowired
    IBookService bookService;
    @Autowired
    IBorrowBookService borrowBookService;

    @GetMapping(value = "/home")
    public String home() {
        return "book/home";
    }

    @GetMapping(value = "/list")
    public String findAll(Model model) {
        model.addAttribute("books", bookService.findAll());
        return "book/list";
    }

    @GetMapping(value = "/borrow/{id}")
    public String selectedBook(@PathVariable int id, RedirectAttributes redirectAttributes) throws BookException {
        String message = borrowBookService.createNewBorrow(id);
        redirectAttributes.addFlashAttribute("msg", message);
        return "redirect:/list";
    }

    @GetMapping(value = "/return")
    public String selectedBook(@RequestParam int idBook,
                               @RequestParam long code,
                               RedirectAttributes redirectAttributes) throws BookException {
        String message = bookService.returnBook(idBook, code);
        redirectAttributes.addFlashAttribute("msg", message);
        return "redirect:/list";
    }

    @ExceptionHandler(BookException.class)
    public ModelAndView bookException(Exception ex) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("msg", ex.getMessage());
        mav.addObject("books", bookService.findAll());
        mav.setViewName("book/list");
        return mav;
    }

}
