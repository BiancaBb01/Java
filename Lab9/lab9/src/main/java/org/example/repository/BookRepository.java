package org.example.repository;

import org.example.model.Book;
import org.example.util.EntityManagerUtil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;


public class BookRepository {
    private final EntityManagerUtil entityManagerUtil;


    public BookRepository(EntityManagerUtil entityManagerUtil) {
        this.entityManagerUtil = EntityManagerUtil.getInstance();
    }


    public void create(Book book) {
        EntityManager entityManager = entityManagerUtil.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(book);
        entityManager.getTransaction().commit();
        entityManager.close();
    }


    public Book findById(int id) {
        EntityManager entityManager = entityManagerUtil.getEntityManager();
        Book book = entityManager.find(Book.class, id);
        entityManager.close();
        return book;
    }


    public List<Book> findByName(String title) {
        EntityManager entityManager = entityManagerUtil.getEntityManager();
        TypedQuery<Book> query = entityManager.createNamedQuery("Book.findByName", Book.class);
        query.setParameter("title", "%" + title + "%");
        List<Book> books = query.getResultList();
        entityManager.close();
        return books;
    }
}
