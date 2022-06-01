package com.mber.study.javaee.husivm._044_cdi._057_interceptors_binding;


import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InterceptorBinding;
import javax.interceptor.InvocationContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;


@WebServlet("057")
public class Servlet extends HttpServlet {
    @Inject
    InterceptorService service;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        service.doJob();
    }
}

@First
class InterceptorService {
    @Second
    public void doJob() {
        System.out.println("do job");
    }
}

@InterceptorBinding
@Target({METHOD, TYPE})
@Retention(RUNTIME)
@interface First {

}

@InterceptorBinding
@Target({METHOD, TYPE})
@Retention(RUNTIME)
@interface Second {

}

/**
 * Добавить информацию в beans.xml <br>{@code <interceptors><class> <class></interceptors>}
 */
@Interceptor
@First
class InterceptorOne {
    @AroundInvoke
    private Object aroundInvoke(InvocationContext context) throws Exception {
        System.out.println("one");
        return context.proceed();
    }
}

@Interceptor
@First
class InterceptorTwo {
    @AroundInvoke
    private Object aroundInvoke(InvocationContext context) throws Exception {
        System.out.println("two");
        return context.proceed();
    }
}

@Interceptor
@Second
class InterceptorThree {
    @AroundInvoke
    private Object aroundInvoke(InvocationContext context) throws Exception {
        System.out.println("three");
        return context.proceed();
    }
}

@Interceptor
@Second
class InterceptorFour {
    @AroundInvoke
    private Object aroundInvoke(InvocationContext context) throws Exception {
        System.out.println("four");
        return context.proceed();
    }
}

