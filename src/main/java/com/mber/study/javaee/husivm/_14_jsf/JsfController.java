package com.mber.study.javaee.husivm._14_jsf;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@Named
@ApplicationScoped
public class JsfController {

    public String on173() {
        return "/14_jsf/173_hello_world/index.xhtml";
    }
    public String on174() {
        return "/14_jsf/174_anatomy/index.xhtml";
    }
}
