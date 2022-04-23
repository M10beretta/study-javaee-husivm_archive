package com.mber.study.javaee.husivm._13_InterceptorsChain;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptors;
import javax.interceptor.InvocationContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("13")
public class Servlet extends HttpServlet {
    @Inject
    InterceptorService service;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        service.doJob();
    }
}

@Interceptors({InterceptorOne.class, InterceptorTwo.class})
class InterceptorService{
    @Interceptors({InterceptorThree.class, InterceptorFour.class})
    public void doJob(){
        System.out.println("do job");
    }
}

class InterceptorOne {
    @AroundInvoke
    private Object aroundInvoke(InvocationContext context) throws Exception{
        System.out.println("one");
        return context.proceed();
    }
}

class InterceptorTwo {
    @AroundInvoke
    private Object aroundInvoke(InvocationContext context) throws Exception{
        System.out.println("two");
        return context.proceed();
    }
}

class InterceptorThree {
    @AroundInvoke
    private Object aroundInvoke(InvocationContext context) throws Exception{
        System.out.println("three");
        return context.proceed();
    }
}

class InterceptorFour {
    @AroundInvoke
    private Object aroundInvoke(InvocationContext context) throws Exception{
        System.out.println("four");
        return context.proceed();
    }
}



