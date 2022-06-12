package com.mber.study.javaee.husivm._06_jpa._087_access_type;

import com.mber.study.javaee.husivm._06_jpa.Repository;

public class Main {
    public static void main(String[] args) {
        try (var repository = new Repository()) {
            repository.begin();
            repository.persist(new Student("Mike"));
            repository.persist(new Student("Elen"));
            repository.persist(new Student("Tom"));
            repository.commit();
        }
    }
}





