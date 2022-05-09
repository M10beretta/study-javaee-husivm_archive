package com.mber.study.javaee.husivm._044_CDI._046_Qualifiers;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.jetbrains.annotations.NotNull;

import javax.inject.Inject;
import javax.inject.Qualifier;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@WebServlet("046")
public class Servlet extends HttpServlet {
    @Inject
    @StudentAnnotation
    private Person personS;
    @Inject
    private Person personW;


    @Override
    protected void doGet(HttpServletRequest req, @NotNull HttpServletResponse resp) throws ServletException, IOException {
        personS.setName("Mike");
        resp.getWriter().write(String.format("""
                personS: %s
                personW: %s
                """, personS, personW));
    }
}

interface Person {
    String getName();

    void setName(String name);
}

@StudentAnnotation
@ToString
class Student implements Person {
    private @Getter @Setter String name;
}

@ToString
class Worker implements Person {
    private @Getter @Setter String name;
}

@Qualifier
@Retention(RUNTIME)
@Target({FIELD, TYPE})
@interface StudentAnnotation {
}