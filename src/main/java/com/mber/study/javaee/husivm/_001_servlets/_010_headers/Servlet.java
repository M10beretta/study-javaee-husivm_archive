package com.mber.study.javaee.husivm._001_servlets._010_headers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("010")
public class Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var headerNames = req.getHeaderNames();

        while (headerNames.hasMoreElements()){
            var nextElement = headerNames.nextElement();
            System.out.printf("%s = %s%n", nextElement, req.getHeader(nextElement));
        }

        System.out.printf("AuthType: %s%n", req.getAuthType());
        System.out.printf("ContentLength: %s%n", req.getContentLength());
        System.out.printf("ContentType: %s%n", req.getContentType());
        System.out.printf("Method: %s%n", req.getMethod());
        System.out.printf("Protocol: %s%n", req.getProtocol());
    }
}
