package com.mber.study.javaee.husivm._044_CDI._049_Disposes;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("049")
public class Servlet extends HttpServlet {
    @Inject
    private Car car;

    @Override
    protected void doGet(HttpServletRequest req, @NonNull HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write(String.format("car: %s", car));
    }
}

class Producer {
    @Produces
    public Car getCar() {
        return new Car("Mazda");
    }

    public void clean(@Disposes @NonNull Car car){
        car.clean();
    }
}

@RequiredArgsConstructor
@ToString
class Car {
    private final String name;

    public void clean(){
        System.out.println("car clean");
    }
}
