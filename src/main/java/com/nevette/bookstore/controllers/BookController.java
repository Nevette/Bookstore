package com.nevette.bookstore.controllers;

import com.nevette.bookstore.dtos.BookDTO;
import com.nevette.bookstore.entities.Book;
import com.nevette.bookstore.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class BookController {

    private final BookRepository bookRepository;

    @Autowired
    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @PostMapping("/book")
    public ResponseEntity postBook(@RequestBody BookDTO request) {
        Book book = new Book();
        book.setIsbn(request.getIsbn());
        book.setAuthor(request.getAuthor());
        book.setTitle(request.getTitle());
        book.setReleaseYear(request.getReleaseYear());
        book.setPrice(request.getPrice());
        bookRepository.save(book);
        return ResponseEntity.noContent().build();
    }
}
