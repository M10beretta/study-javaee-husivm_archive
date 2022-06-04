package com.mber.study.javaee.husivm._06_jpa._081_embedable;

import com.mber.study.javaee.husivm._06_jpa.Repository;

import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        try (var repository = new Repository()) {
            repository.begin();
            IntStream.range(1, 5).mapToObj(i -> new StudentA("name " + i, "surname " + i, 20)).forEach(repository::persist);
            IntStream.range(1, 5).mapToObj(i -> new StudentB("name " + i, "surname " + i, 20)).forEach(repository::persist);
            repository.commit();
        }
    }
}


