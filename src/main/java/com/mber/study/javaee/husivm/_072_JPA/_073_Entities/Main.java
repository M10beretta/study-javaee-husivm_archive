package com.mber.study.javaee.husivm._072_JPA._073_Entities;

import com.mber.study.javaee.husivm._072_JPA.Student;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        var factory = Persistence.createEntityManagerFactory("default");
        var manager = factory.createEntityManager();

        var student = new Student();
        student.setName("Mike");
        student.setBirthday(LocalDate.of(2000,1,1));

        var transaction = manager.getTransaction();
        transaction.begin();
        manager.persist(student);
        transaction.commit();

        manager.close();
        factory.close();
    }
}
