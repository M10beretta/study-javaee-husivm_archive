package com.mber.study.javaee.husivm._044_CDI._054_LiveCycleBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("054")
public class Servlet extends HttpServlet {
    @Inject
    private LiveCycleBean liveCycleBean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        liveCycleBean.method1();
        liveCycleBean.method2();
    }
}

class LiveCycleBean {

    public LiveCycleBean() {
        System.out.println("constructor");          // 1
    }

    @PostConstruct
    private void postConstruct() {
        System.out.println("after construct");      // 2
    }

    @AroundInvoke
    private Object aroundInvoke(InvocationContext context) throws Exception {
        System.out.println("before method");        // 3, 5
        return context.proceed();
    }

    public void method1() {
        System.out.println("method1");              // 4
    }

    public void method2() {
        System.out.println("method2");              // 6
    }

    @PreDestroy
    private void preDestroy() {
        System.out.println("before destroy");        // 7
    }
}
