package com.mber.study.javaee.husivm._044_CDI._047_Alternatives;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.jetbrains.annotations.NotNull;

import javax.enterprise.inject.Alternative;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("047")
@NoArgsConstructor
public class Servlet extends HttpServlet {
    @Inject
    private Person person;

    @Override
    protected void doGet(HttpServletRequest req, @NotNull HttpServletResponse resp) throws ServletException, IOException {
        person.setName("Mike");
        resp.getWriter().write(String.format("personS: %s", person));
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
