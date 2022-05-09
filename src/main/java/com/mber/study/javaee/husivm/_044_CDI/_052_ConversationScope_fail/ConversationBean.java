package com.mber.study.javaee.husivm._044_CDI._052_ConversationScope_fail;

import lombok.Getter;
import lombok.Setter;

import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import java.io.Serializable;

@ConversationScoped
public class ConversationBean implements Serializable {
    String state;
    private @Getter @Setter String st;

    @Inject
    private Conversation conversation;

    public void startConversation() {
        System.out.println("inside , ______________________startConversation() begin");
        printInsideStates();
        conversation.begin("1");
        System.out.println("inside , conversation.begin()");
        state = "B";
        st = "B";
        System.out.println("inside , set state - B");
        System.out.println("inside , ______________________startConversation() end");
    }

    public void printInsideStates() {
        System.out.printf("inside , state: %s%n", state);
        System.out.printf("inside , st   : %s%n", st);
    }

    public void endConversation() {
        System.out.println("inside , ______________________endConversation() begin");
        printInsideStates();
        conversation.end();
        System.out.println("inside , conversation.end()");
        System.out.println("inside , ______________________endConversation() end");
    }
}
