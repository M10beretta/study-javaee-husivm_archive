package com.mber.study.javaee.husivm._12_Interceptor;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.interceptor.AroundConstruct;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptors;
import javax.interceptor.InvocationContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("12")
public class Servlet extends HttpServlet {
    @Inject
    private LiveCycleBean liveCycleBean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        liveCycleBean.method1();
        liveCycleBean.method2();
        liveCycleBean.method3();
    }
}

class MyInterceptor {
    @AroundConstruct
    private void aroundConstruct(InvocationContext context) throws Exception {
        System.out.println("before construct");
        context.proceed();
    }

    @PostConstruct
    private void postConstruct(InvocationContext context) throws Exception {
        System.out.println("after construct");
        context.proceed();
    }

    @AroundInvoke
    private Object aroundInvoke(InvocationContext context) throws Exception {
        System.out.println("before method");
        return context.proceed();
    }
}

// @Interceptors(MyInterceptor.class)
class LiveCycleBean {
    public LiveCycleBean() {
        System.out.println("constructor");
    }

    public void method1() {
        System.out.println("method1");
    }

    // @ExcludeClassInterceptors
    public void method2() {
        System.out.println("method2");
    }

    @Interceptors(MyInterceptor.class)
    public void method3() {
        System.out.println("method3");
    }
}
