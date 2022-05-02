package com.mber.study.javaee.husivm._001_Servlets._005_WebServlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("005")
public class Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        var printWriter = resp.getWriter();
        printWriter.write("Hello World!");
    }
}