package com.mber.study.javaee.husivm._9_ConversationScope;

import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.Serializable;

@WebServlet("/9")
public class Servlet extends HttpServlet {
    @Inject
    private ConversationBean conversationBean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println(conversationBean.i);
        conversationBean.i = 1;
        conversationBean.startConversation();
        System.out.println(conversationBean.i);
        System.out.println("middle conversation");
        conversationBean.i = 3;
        conversationBean.endConversation();
        System.out.println(conversationBean.i);
    }
}

@ConversationScoped
class ConversationBean implements Serializable {
    int i;

    @Inject
    Conversation conversation;

    public void startConversation() {
        System.out.println(i);
        System.out.println("start conversation");
        conversation.begin();
        i = 2;
    }

    public void endConversation() {
        System.out.println("end conversation");
        conversation.end();
    }
}