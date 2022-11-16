package com.example.book.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.example.book.model.Book;

@Repository
public class BookRepositoryImpl implements BookRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Book> findByCriteria(Book book) {

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Book> criteriaQuery = criteriaBuilder.createQuery(Book.class);
    
        Root<Book> rootBook = criteriaQuery.from(Book.class);
        List<Predicate> predicates = new ArrayList<>();
        
        if (book.getName() != null) {
            predicates.add(criteriaBuilder.equal(rootBook.get("name"), book.getName()));
        }
        if (book.getCategory() != null) {
            predicates.add(criteriaBuilder.equal(rootBook.get("category"), book.getCategory()));
        }
        if (book.getAuthor() != null) {
            predicates.add(criteriaBuilder.equal(rootBook.get("author"), book.getAuthor()));
        }
        criteriaQuery.where(predicates.toArray(new Predicate[0]));
    
        return entityManager.createQuery(criteriaQuery).getResultList();
    }
}
