package com.mber.study.javaee.husivm._044_CDI._051_BeanScopes;

import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("051")
public class Servlet extends HttpServlet {
    @Inject
    private MyBean bean;
    @Inject
    private ChangeMyBean change;

    @Override
    protected void doGet(HttpServletRequest req, @NotNull HttpServletResponse resp) throws ServletException, IOException {
        bean.setI(5);
        change.changeI();
        resp.getWriter().write("i: " + bean.getI());

    }
}

//@ApplicationScoped
//@SessionScoped
//@RequestScoped
//@ConversationScoped
@Dependent
class MyBean {
    private @Getter @Setter int i;
}

class ChangeMyBean {
    @Inject
    private MyBean myBean;

    public void changeI() {
        myBean.setI(2);
    }
}

