package com.mber.study.javaee.husivm._06_jpa._079_generated_value;

import com.mber.study.javaee.husivm._06_jpa.Repository;

import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        var s = "Student ";
        int m = 1;
        int n = 5;
        try (var repository = new Repository()) {
            for (int i = 0; i <2; i++) {
            repository.begin();
            IntStream.range(m, n).mapToObj(k -> new StudentA(s + k)).forEach(repository::persist);
            IntStream.range(m, n).mapToObj(k -> new StudentB(s + k)).forEach(repository::persist);
            IntStream.range(m, n).mapToObj(k -> new StudentC(s + k)).forEach(repository::persist);
            IntStream.range(m, n).mapToObj(k -> new StudentD(s + k)).forEach(repository::persist);
            repository.commit();
            }
        }
    }
}
