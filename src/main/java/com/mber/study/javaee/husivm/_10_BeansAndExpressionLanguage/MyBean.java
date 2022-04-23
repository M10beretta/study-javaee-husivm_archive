package com.mber.study.javaee.husivm._10_BeansAndExpressionLanguage;

import lombok.Getter;

import javax.inject.Named;

@Named
public class MyBean { // myBean
    private final @Getter String s = "Hi";
}
