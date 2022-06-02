package com.mber.study.javaee.husivm._14_jsf;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@Named
@ApplicationScoped
public class JsfController {

    public String on173() {
        return "/14_jsf/173/hello_world.xhtml";
    }
}
