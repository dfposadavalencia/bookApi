package com.example.book.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.book.model.Book;

public interface BookRepository extends JpaRepository<Book, Integer>, BookRepositoryCustom {

}
