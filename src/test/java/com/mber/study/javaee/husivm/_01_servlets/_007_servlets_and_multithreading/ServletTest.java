package com.mber.study.javaee.husivm._01_servlets._007_servlets_and_multithreading;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Disabled
class ServletTest {
    private boolean success;

    @BeforeEach
    public void init(){
        this.success = true;
    }

    @Test
    public void run() throws InterruptedException {
        var executorService = Executors.newFixedThreadPool(2);
        IntStream.range(0, 2).forEach(i -> executorService.submit(this::connect));
        executorService.shutdown();
        Thread.sleep(100);
        assertTrue(success);
    }

    private void connect() {
        try {
            new URL("http://localhost:8080/mber-study-javaee-husivm-1.0-SNAPSHOT/007").openConnection().getInputStream();
        } catch (IOException e) {
            success = false;
            throw new RuntimeException(e);
        }
    }
}