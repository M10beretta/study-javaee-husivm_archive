package com.mber.study.javaee.husivm._072_jpa._074_persistence_xml;

import com.mber.study.javaee.husivm._072_jpa.Repository;


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
