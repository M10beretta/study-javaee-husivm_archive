package com.mber.study.javaee.husivm._063_BeanValidation._068_InheritanceAndValidation;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Validator;
import javax.validation.constraints.NotNull;

import static com.mber.study.javaee.husivm._063_BeanValidation.ValidationUtil.checkValidation;

@WebServlet("068")
public class Servlet extends HttpServlet {
    @Inject
    private Validator validator;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        checkValidation(validator.validateValue(Child.class, "name", "Mike"));
        checkValidation(validator.validateValue(Child.class, "name", null));
    }
}

@Getter
@Setter
@ToString
class Person {
    @NotNull
    private String name;
}

class Child extends Person {
}

