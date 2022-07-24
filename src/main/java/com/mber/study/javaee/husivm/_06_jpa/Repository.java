package com.mber.study.javaee.husivm._06_jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import lombok.Getter;

public class Repository implements AutoCloseable {
    private final EntityManagerFactory factory;
    @Getter
    private final EntityManager entityManager;

    public Repository() {
        this.factory = jakarta.persistence.Persistence.createEntityManagerFactory("default");
        this.entityManager = factory.createEntityManager();
    }

    public void begin() {
        entityManager.getTransaction().begin();
    }

    public void persist(Object entity) {
        entityManager.persist(entity);
    }

    public void commit() {
        entityManager.getTransaction().commit();
    }

    @Override
    public void close() {
        entityManager.close();
        factory.close();
    }
}
