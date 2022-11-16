package com.example.book.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.book.model.Book;
import com.example.book.repository.BookRepository;

@Service
public class BookService {
    
    @Autowired
    private BookRepository bookRepository;

    public List<Book> findByCriteria(Book book) {
        if (book.getName() == null && book.getCategory() == null && book.getAuthor() == null) {
            return new ArrayList<Book>();
        }
        return bookRepository.findByCriteria(book);
    }
    
}
