package com.mber.study.javaee.husivm._072_JPA._077_Table;

import com.mber.study.javaee.husivm._072_JPA.Repository;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        var mike = new Student("Mike", LocalDate.of(2000, 1, 1));
        mike.setCountry("USA");
        mike.setCity("California");
        mike.setPhone("123");
        try (var repository = new Repository()) {
            repository.begin();
            repository.persist(mike);
            repository.commit();
        }
    }
}
