package com.mber.study.javaee.husivm._044_CDI._052_ConversationScope;

import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.Serializable;

@WebServlet("052")
public class Servlet extends HttpServlet {
    @Inject
    private ConversationBean bean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        System.out.printf("outside, state: %s%n", bean.state);
        bean.state = "A";
        System.out.println("outside, set state - A");
        bean.startConversation();
        System.out.printf("outside, state: %s%n", bean.state);
        bean.doJob();
        bean.state = "C";
        System.out.println("outside, set state - C");
        bean.doJob();
        bean.state = "D";
        System.out.println("outside, set state - D");
        bean.doJob();
        bean.endConversation();
        System.out.printf("outside, state: %s%n", bean.state);
        bean.doJob();
        bean.state = "E";
        System.out.println("outside, set state - E");
        bean.doJob();
    }
}

@ConversationScoped
class ConversationBean implements Serializable {
    String state;

    @Inject
    private Conversation conversation;

    public void startConversation() {
        System.out.printf("inside, start conversation start, state: %s%n", state);
        conversation.begin();
        System.out.println("inside, conversation.begin()");
        state = "B";
        System.out.println("inside, set state - B, start conversation stop");
    }

    public void doJob() {
        System.out.printf("inside, do job, state: %s%n", state);
    }

    public void endConversation() {
        System.out.printf("inside, end conversation start, state: %s%n", state);
        conversation.end();
        System.out.println("inside, conversation.end(), end conversation stop");
    }
}