package com.mber.study.javaee.husivm._060_OpenWebBeans;

import org.apache.webbeans.config.WebBeansContext;
import org.apache.webbeans.spi.ContainerLifecycle;

import javax.enterprise.inject.spi.Bean;
import javax.inject.Inject;
import javax.inject.Named;

public class Main {

    public static void main(String[] args) {
        var lifecycle = WebBeansContext.currentInstance().getService(ContainerLifecycle.class);
        lifecycle.startApplication(null);

        var beanManager = lifecycle.getBeanManager();
        Bean<?> bean = beanManager.getBeans("mainContainer").iterator().next();

        var container = (MainContainer)lifecycle.getBeanManager().getReference(bean, MainContainer.class, beanManager.createCreationalContext(bean));
        container.runBean();

        lifecycle.startApplication(null);



    }
}

@Named
class MainContainer {
    @Inject
    private MyBean bean;

    public void runBean() {
        bean.print();
    }
}

class MyBean {
    public void print() {
        System.out.println("hi");
    }
}

