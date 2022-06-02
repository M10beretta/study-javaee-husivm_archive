package com.mber.study.javaee.husivm._04_cdi._053_beans_and_expression_language;

import lombok.Getter;

import javax.inject.Named;


@Named
public class MyBean { // myBean
    private final @Getter String s = "Hi";
}
