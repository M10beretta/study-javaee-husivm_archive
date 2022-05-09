package com.mber.study.javaee.husivm._044_CDI._052_ConversationScope_fail;

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
        printOutsideAndInsideStates();
        initBean("A");
        printOutsideAndInsideStates();

        bean.startConversation();

        printOutsideAndInsideStates();
        initBean("C");
        printOutsideAndInsideStates();
        initBean("D");
        printOutsideAndInsideStates();

        bean.endConversation();

        printOutsideAndInsideStates();
        initBean("E");
        printOutsideAndInsideStates();
    }


    private void initBean(String s) {
        bean.state = s;
        bean.setSt(s);
        System.out.println("outside, set state - " + s);
    }

    private void printOutsideAndInsideStates() {
        printOutsideStates();
        bean.printInsideStates();
    }

    private void printOutsideStates() {
        System.out.printf("outside, state: %s%n", bean.state);
        System.out.printf("outside,    st: %s%n", bean.getSt());
    }
}

