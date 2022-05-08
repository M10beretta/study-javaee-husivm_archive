package com.mber.study.javaee.husivm._001_Servlets._015_AsynchronousServlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "015", asyncSupported = true)
public class Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var asyncContext = req.getAsyncContext();
        asyncContext.start(() -> {
            //wait event
        });
        asyncContext.complete();
    }
}
