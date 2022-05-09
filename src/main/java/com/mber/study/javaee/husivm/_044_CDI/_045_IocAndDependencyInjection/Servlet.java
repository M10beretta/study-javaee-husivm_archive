package com.mber.study.javaee.husivm._044_CDI._045_IocAndDependencyInjection;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.jetbrains.annotations.NotNull;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("045")
@NoArgsConstructor
public class Servlet extends HttpServlet {
    @Inject
    private Student studentF;

    private Student studentC;

    @Inject
    public Servlet(Student studentC) {
        this.studentC = studentC;
    }

    private Student studentS;

    @Inject
    public void setStudentS(Student studentS) {
        this.studentS = studentS;
    }

    @Override
    protected void doGet(HttpServletRequest req, @NotNull HttpServletResponse resp) throws ServletException, IOException {
        studentF.setName("Mike");
        studentC.setName("Elen");
        resp.getWriter().write(String.format("""
                studentF: %s
                studentC: %s
                studentS: %s
                """, studentF, studentC, studentS));
    }
}

@Getter
@Setter
@ToString
class Student {
    private String name;
}