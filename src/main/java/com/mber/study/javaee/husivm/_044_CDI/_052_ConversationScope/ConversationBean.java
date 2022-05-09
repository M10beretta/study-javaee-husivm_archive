package com.mber.study.javaee.husivm._044_CDI._052_ConversationScope;

import lombok.Getter;
import lombok.Setter;

import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import java.io.Serializable;

@ConversationScoped
class ConversationBean implements Serializable {
    String state;
    private @Getter @Setter String st;

    @Inject
    private Conversation conversation;

    public void startConversation() {
        System.out.println("inside, start conversation start");
        System.out.printf("inside, state: %s%n", state);
        System.out.printf("inside, st   : %s%n", st);
        conversation.begin();
        System.out.println("inside, conversation.begin()");
        state = "B";
        st = "B";
        System.out.println("inside, set state - B, start conversation stop");
    }

    public void doJob() {
        System.out.printf("inside, do job, state: %s%n", state);
        System.out.printf("inside, do job, st   : %s%n", st);
    }

    public void endConversation() {
        System.out.printf("inside, end conversation start, state: %s%n", state);
        System.out.printf("inside, end conversation start, st   : %s%n", st);
        conversation.end();
        System.out.println("inside, conversation.end(), end conversation stop");
    }
}
