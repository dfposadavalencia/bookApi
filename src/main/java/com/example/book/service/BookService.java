package com.example.book.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.example.book.dto.BookFilter;
import com.example.book.exception.NoContentException;
import com.example.book.model.Book;
import com.example.book.repository.BookRepository;

@Service
public class BookService {
    
    @Autowired
    private BookRepository bookRepository;

    public List<Book> findByCriteria(BookFilter book) {
        if (book.getName() == null && book.getCategory() == null && book.getAuthor() == null) {
            throw new NoContentException();
        }
        return bookRepository.findByCriteria(book);
    }
}
