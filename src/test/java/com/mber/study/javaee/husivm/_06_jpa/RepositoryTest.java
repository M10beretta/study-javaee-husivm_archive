package com.mber.study.javaee.husivm._06_jpa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RepositoryTest {
    @Test
    void load() {
        Assertions.assertDoesNotThrow(() -> {
            try (var ignored = new Repository()) {
                System.out.println("Repository loaded");
            }
        });
    }
}