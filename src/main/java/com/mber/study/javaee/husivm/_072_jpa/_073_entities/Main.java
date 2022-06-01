package com.mber.study.javaee.husivm._072_jpa._073_entities;

import jakarta.persistence.Persistence;


public class Main {
    public static void main(String[] args) {
        var mike = new Student("Mike");
        var factory = Persistence.createEntityManagerFactory("default");
        var manager = factory.createEntityManager();
        var transaction = manager.getTransaction();
        transaction.begin();
        manager.persist(mike);
        transaction.commit();
        manager.close();
        factory.close();
    }
}
