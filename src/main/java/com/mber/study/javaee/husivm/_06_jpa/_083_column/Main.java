package com.mber.study.javaee.husivm._06_jpa._083_column;

import com.mber.study.javaee.husivm._06_jpa.Repository;

import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        try (var repository = new Repository()) {
            repository.begin();
            IntStream.range(1, 5).mapToObj(i -> new Student("name " + i, "surname " + i)).forEach(repository::persist);
            repository.commit();
        }
    }
}





