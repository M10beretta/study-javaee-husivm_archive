package com.mber.study.javaee.husivm._11_LiveCycleBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/11")
public class Servlet extends HttpServlet {
    @Inject
    private LiveCycleBean liveCycleBean;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        liveCycleBean.method1();
        liveCycleBean.method2();
    }
}

class LiveCycleBean {

    public LiveCycleBean() {
        System.out.println("constructor");          // 1
    }

    @PostConstruct
    public void postConstruct(){
        System.out.println("postConstruct");        // 2
    }

    @AroundInvoke
    public Object aroundInvoke(InvocationContext context) throws Exception {
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
    public void preDestroy(){
        System.out.println("preDestroy");           // 7
    }
}
