package com.mber.study.javaee.husivm._072_JPA._075_EntityManager;

import com.mber.study.javaee.husivm._072_JPA.Book;
import jakarta.persistence.Persistence;


public class Main {
    public static void main(String[] args) {
        var factory = Persistence.createEntityManagerFactory("default");
        var manager = factory.createEntityManager();

        manager.getTransaction().begin();
        manager.persist(new Book("title"));
        manager.getTransaction().commit();

        manager.close();
        factory.close();
    }
}
