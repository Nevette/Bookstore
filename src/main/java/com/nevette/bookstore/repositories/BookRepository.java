package com.nevette.bookstore.repositories;

import com.nevette.bookstore.entities.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Integer> {
    Book findByIsbn(Book book);
}
