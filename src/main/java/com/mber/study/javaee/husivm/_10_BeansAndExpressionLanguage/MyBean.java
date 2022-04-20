package com.mber.study.javaee.husivm._10_BeansAndExpressionLanguage;

import lombok.Getter;
import lombok.Setter;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@Getter
@Setter
@Named
@ApplicationScoped
public class MyBean { // myBean
    private String s = "Hi";
}
