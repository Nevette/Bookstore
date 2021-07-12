package com.nevette.bookstore.controllers;

import com.nevette.bookstore.dtos.BookDTO;
import com.nevette.bookstore.entities.Book;
import com.nevette.bookstore.repositories.BookRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.function.EntityResponse;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class BookControllerTest {

    private BookController bookController;
    @Mock
    private BookRepository bookRepository;

    AutoCloseable mocks;

    @BeforeEach
    public void setUp(){
    mocks = MockitoAnnotations.openMocks(this);
    bookController = new BookController(bookRepository);
    }

    @AfterEach
    public void tearDown() throws Exception {
        mocks.close();
    }

    @Test
    public void bookControllerSetsBookCorrectly(){
        BookDTO book = new BookDTO(9788375176438l, "Zbrodnia i kara", "Fiodor Dostojewski", 2017, 29.61f);
        ResponseEntity responseEntity = bookController.postBook(book);
        ArgumentCaptor<Book> captor = ArgumentCaptor.forClass(Book.class);
        verify(bookRepository, times(1)).save(captor.capture());
        Book bookResponse = captor.getValue();
        assertEquals(book.getAuthor(), bookResponse.getAuthor());
        assertEquals(book.getIsbn(), bookResponse.getIsbn());
        assertEquals(204, responseEntity.getStatusCodeValue());
    }
}
