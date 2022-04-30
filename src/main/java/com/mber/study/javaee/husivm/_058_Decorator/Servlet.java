package com.mber.study.javaee.husivm._058_Decorator;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("058")
public class Servlet extends HttpServlet {
    @Inject
    private Parent parent;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        parent.print();
    }
}

interface Parent {
    void print();
}

class Child implements Parent {
    @Override
    public void print() {
        System.out.println("print");
    }
}

/**
 * Добавить информацию в beans.xml <br>{@code <decorators><class> <class></decorators>}
 */
@Decorator
class MyDecorator implements Parent {
    @Inject @Delegate
    private Parent parent;

    @Override
    public void print() {
        System.out.println("before print");
        parent.print();
    }
}