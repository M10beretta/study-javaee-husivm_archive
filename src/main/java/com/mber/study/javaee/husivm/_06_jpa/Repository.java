package com.mber.study.javaee.husivm._06_jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import lombok.Getter;

public class Repository implements AutoCloseable {
    private final EntityManagerFactory factory;
    @Getter
    private final EntityManager manager;

    public Repository() {
        this.factory = jakarta.persistence.Persistence.createEntityManagerFactory("default");
        this.manager = factory.createEntityManager();
    }

    public void begin() {
        manager.getTransaction().begin();
    }

    public void persist(Object entity) {
        manager.persist(entity);
    }

    public void commit() {
        manager.getTransaction().commit();
    }

    @Override
    public void close() {
        manager.close();
        factory.close();
    }
}
