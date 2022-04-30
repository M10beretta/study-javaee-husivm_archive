package com.mber.study.javaee.husivm._052_ConversationScope;

import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.Serializable;

@WebServlet("52")
public class Servlet extends HttpServlet {
    @Inject
    private ConversationBean bean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println(bean.state + "    : out"); //    null : out       -1
        bean.state = "1 (out)";
        bean.startConversation();
        System.out.println(bean.state + " : out");    // 1 (out) : out       -4
        System.out.println("middle conversation");    // middle conversation -5
        bean.doJob();
        bean.state = "2 (out)";
        bean.endConversation();
        System.out.println(bean.state + " : out");    // 2 (out) : out       -9
        bean.doJob();
    }
}

@ConversationScoped
class ConversationBean implements Serializable {
    String state;

    @Inject
    Conversation conversation;

    public void startConversation() {
        System.out.println(state + "    : in");        // null : in           -2
        System.out.println("start conversation");      // start conversation  -3
        conversation.begin();
        state = "2 (in)";
    }

    public void doJob(){
        System.out.println(state + "  : in");          // 2 (in) : in         -6, 10
    }

    public void endConversation() {
        System.out.println(state + "  : in");          // 2 (in) : in         -7
        System.out.println("end conversation");        // end conversation    -8
        conversation.end();
    }
}