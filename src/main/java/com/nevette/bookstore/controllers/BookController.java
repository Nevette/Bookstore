package com.nevette.bookstore.controllers;

import com.nevette.bookstore.dtos.BookDTO;
import com.nevette.bookstore.entities.Book;
import com.nevette.bookstore.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BookController {

    private final BookRepository bookRepository;

    @Autowired
    protected BookController(BookRepository bookRepository) {
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

    @DeleteMapping("/book")
    public ResponseEntity deleteBook(@RequestParam("isbn") Long isbn){
        Book book = bookRepository.findByIsbn(isbn);
        bookRepository.delete(book);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/book")
    public BookDTO getBook(@RequestParam("isbn") Long isbn){
        Book book = bookRepository.findByIsbn(isbn);
        return new BookDTO(book.getIsbn(), book.getTitle(), book.getAuthor(), book.getReleaseYear(), book.getPrice());
    }

    @PutMapping("/book")
    public ResponseEntity updateBook(@RequestBody BookDTO request) {
        if (request.getIsbn() == null){
            return ResponseEntity.badRequest().build();
        }
        Book book = bookRepository.findByIsbn(request.getIsbn());
        if (request.getAuthor() != null){
            book.setAuthor(request.getAuthor());
        }
        if (request.getTitle() != null){
            book.setTitle(request.getTitle());
        }
        if (request.getPrice() != null){
            book.setPrice(request.getPrice());
        }
        if (request.getReleaseYear() != null){
            book.setReleaseYear(request.getReleaseYear());
        }
        bookRepository.save(book);
        return ResponseEntity.noContent().build();
    }
}
