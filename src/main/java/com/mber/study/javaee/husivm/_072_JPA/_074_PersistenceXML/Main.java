package com.mber.study.javaee.husivm._072_JPA._074_PersistenceXML;

import com.mber.study.javaee.husivm._072_JPA.Repository;


public class Main {
    public static void main(String[] args) {
        var book = new Book("The alchemist");
        try (var repository = new Repository()) {
            repository.begin();
            repository.persist(book);
            repository.commit();
        }
    }
}
