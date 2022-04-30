package com.mber.study.javaee.husivm._062_Threads_pool_and_competition;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.IntStream;

@WebServlet("062")
public class Servlet extends HttpServlet {
    private final ExecutorService executorService = new ForkJoinPool();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        executorService.submit(() -> print(1));
        executorService.submit(() -> print(2));
        executorService.submit(() -> print(3));
        executorService.submit(() -> print(4));
        executorService.submit(() -> print(5));
        executorService.shutdown();
    }

    private void print(int num) {
        IntStream.range(0, 10).forEach(i -> {
            System.out.println(num);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }
}





