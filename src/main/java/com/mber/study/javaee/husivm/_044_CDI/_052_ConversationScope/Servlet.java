package com.mber.study.javaee.husivm._044_CDI._052_ConversationScope;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("052")
public class Servlet extends HttpServlet {
    @Inject
    private ConversationBean bean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        System.out.printf("outside, state: %s%n", bean.state);
        System.out.printf("outside,    st: %s%n", bean.getSt());
        bean.state = "A";
        bean.setSt("A");
        System.out.println("outside, set state - A");
        bean.startConversation();
        System.out.printf("outside, state: %s%n", bean.state);
        System.out.printf("outside,    st: %s%n", bean.getSt());
        bean.doJob();
        bean.state = "C";
        bean.setSt("C");
        System.out.println("outside, set state - C");
        bean.doJob();
        bean.state = "D";
        bean.setSt("D");
        System.out.println("outside, set state - D");
        bean.doJob();
        bean.endConversation();
        System.out.printf("outside, state: %s%n", bean.state);
        System.out.printf("outside,    st: %s%n", bean.getSt());
        bean.doJob();
        bean.state = "E";
        bean.setSt("E");
        System.out.println("outside, set state - E");
        bean.doJob();
    }
}

