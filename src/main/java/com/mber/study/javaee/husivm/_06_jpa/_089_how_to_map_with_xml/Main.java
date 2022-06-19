package com.mber.study.javaee.husivm._06_jpa._089_how_to_map_with_xml;

import com.mber.study.javaee.husivm._06_jpa.Repository;

public class Main {
    public static void main(String[] args) {
        try (var repository = new Repository()) {
            repository.begin();
            repository.persist(new Student(1, "Mike"));
            repository.persist(new Student(2, "Helen"));
            repository.commit();
        }
    }
}
