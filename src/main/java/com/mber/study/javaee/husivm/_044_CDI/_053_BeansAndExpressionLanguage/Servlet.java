package com.mber.study.javaee.husivm._044_CDI._053_BeansAndExpressionLanguage;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Не работает с jsp если разместить MyBean.class в этом же файле, т.к. для jsp класс бина должен быть public
 */
@WebServlet("053")
public class Servlet extends HttpServlet {
    @Inject
    private MyBean myBean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var dispatcher = req.getRequestDispatcher("/053/index.jsp");
        dispatcher.forward(req, resp);
    }
}




