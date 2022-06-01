package com.mber.study.javaee.husivm._001_servlets._011_gzip;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.zip.GZIPOutputStream;

@WebServlet("011")
public class Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getHeader("Accept-Encoding").contains("gzip")) {
            var printWriter = new PrintWriter(new GZIPOutputStream(resp.getOutputStream()));
            printWriter.write("hello world");
        }
    }
}
