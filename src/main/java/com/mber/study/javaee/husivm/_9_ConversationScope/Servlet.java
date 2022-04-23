package com.mber.study.javaee.husivm._9_ConversationScope;

import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.Serializable;

@WebServlet("9")
public class Servlet extends HttpServlet {
    @Inject
    private ConversationBean conversationBean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println(conversationBean.state + "    : out");//    null : out       -1
        conversationBean.state = "1 (out)";
        conversationBean.startConversation();
        System.out.println(conversationBean.state + " : out");   // 1 (out) : out       -4
        System.out.println("middle conversation");               // middle conversation -5
        conversationBean.doJob();
        conversationBean.state = "2 (out)";
        conversationBean.endConversation();
        System.out.println(conversationBean.state + " : out");   // 2 (out) : out       -9
        conversationBean.doJob();

    }
}

@ConversationScoped
class ConversationBean implements Serializable {
    String state;

    @Inject
    Conversation conversation;

    public void startConversation() {
        System.out.println(state + "    : in");                   //    null : in        -2
        System.out.println("start conversation");                 // start conversation  -3
        conversation.begin();
        state = "2 (in)";
    }


    public void doJob(){
        System.out.println(state + "  : in");                    //    2 (in) : in       -6, 10
    }


    public void endConversation() {
        System.out.println(state + "  : in");                     //   2 (in) : in       -7
        System.out.println("end conversation");                   // end conversation    -8
        conversation.end();
    }
}