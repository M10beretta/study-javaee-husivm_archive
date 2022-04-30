package com.mber.study.javaee.husivm._061_Specialise;

import javax.enterprise.inject.Specializes;
import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("061")
public class Servlet extends HttpServlet {
    @Inject
    private A a;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        a.print();
    }
}

interface A{
    void print();
}

class B implements A{
    @Override
    public void print() {
        System.out.println("B");


    }
}

@Specializes
class C extends B{
    @Override
    public void print() {
        System.out.println("C");
    }
}