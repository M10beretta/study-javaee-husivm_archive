package com.mber.study.javaee.husivm._10_BeansAndExpressionLanguage;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/10")
public class Servlet extends HttpServlet {
    @Inject
    private MyBean myBean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var dispatcher = req.getRequestDispatcher("/jsp/index_10.jsp");
        dispatcher.forward(req, resp);
    }
}


