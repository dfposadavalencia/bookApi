package com.example.book.repository;

import java.util.List;

import com.example.book.model.Book;

public interface BookRepositoryCustom {

    List<Book> findByCriteria(Book book);
}
