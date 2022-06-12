package com.mber.study.javaee.husivm._06_jpa._088_how_to_map_collections;

import com.mber.study.javaee.husivm._06_jpa.Repository;

public class Main {
    public static void main(String[] args) {
        try (var repository = new Repository()) {
            repository.begin();
            repository.persist(new Student("Mike"));
            repository.persist(new Student("Elen"));
            repository.commit();
        }
    }
}





