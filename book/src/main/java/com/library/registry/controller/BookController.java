package com.library.registry.controller;

import com.library.registry.model.Book;
import com.library.registry.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RequestMapping(value = "/book")
@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping
    public ResponseEntity<?> addBook(@RequestBody Book book) {
        return bookService.addBook(book);
    }

    @GetMapping("/list")
    public ResponseEntity<?> listBooks() {
        return bookService.listBooks();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> fetchBookById(@PathVariable int id) {
        return bookService.fetchBookById(id);
    }

    // create a delete later

}
