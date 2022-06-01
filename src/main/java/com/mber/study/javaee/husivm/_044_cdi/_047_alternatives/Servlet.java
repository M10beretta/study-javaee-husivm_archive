package com.mber.study.javaee.husivm._044_cdi._047_alternatives;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

import javax.enterprise.inject.Alternative;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("047")
public class Servlet extends HttpServlet {
    @Inject
    private Person person;

    @Override
    protected void doGet(HttpServletRequest req, @NonNull HttpServletResponse resp) throws ServletException, IOException {
        person.setName("Mike");
        resp.getWriter().write(String.format("person: %s", person));
    }
}

interface Person {
    String getName();

    void setName(String name);
}

@Alternative
@ToString
class Student implements Person {
    private @Getter @Setter String name;
}

@ToString
class Worker implements Person {
    private @Getter @Setter String name;
}
