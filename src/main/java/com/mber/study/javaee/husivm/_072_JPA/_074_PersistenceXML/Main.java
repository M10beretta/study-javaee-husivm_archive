package com.mber.study.javaee.husivm._072_JPA._074_PersistenceXML;

import com.mber.study.javaee.husivm._072_JPA.Book;
import jakarta.persistence.Persistence;


public class Main {
    public static void main(String[] args) {
        var factory = Persistence.createEntityManagerFactory("default");
        var manager = factory.createEntityManager();

        var book = new Book();
        book.setTitle("The alchemist");

        var transaction = manager.getTransaction();
        transaction.begin();
        manager.persist(book);
        transaction.commit();

        manager.close();
        factory.close();
    }
}
