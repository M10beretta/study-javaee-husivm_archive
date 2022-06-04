package com.mber.study.javaee.husivm._14_jsf._177_inputs;


import lombok.Getter;
import lombok.Setter;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.util.Optional;

@Named
@RequestScoped
public class Main177 {
    @Getter
    @Setter
    private String text;

    public void print() {
        System.out.println(Optional.of(text).orElse(""));
    }
}
