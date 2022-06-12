package com.mber.study.javaee.husivm._06_jpa._086_enums;

import com.mber.study.javaee.husivm._06_jpa.Repository;

public class Main {
    public static void main(String[] args) {
        try (var repository = new Repository()) {
            repository.begin();
            repository.persist(new Student("Mike", Sex.MALE));
            repository.persist(new Student("Elen", Sex.FEMALE));
            repository.persist(new Student("Tom", Sex.ALIEN));
            repository.commit();
        }
    }
}





