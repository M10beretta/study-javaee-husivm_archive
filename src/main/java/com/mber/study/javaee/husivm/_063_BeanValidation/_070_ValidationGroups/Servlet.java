package com.mber.study.javaee.husivm._063_BeanValidation._070_ValidationGroups;

import lombok.Builder;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Validator;
import javax.validation.constraints.NotNull;
import javax.validation.groups.Default;

import static com.mber.study.javaee.husivm._063_BeanValidation.ValidationUtil.checkValidation;

@WebServlet("070")
public class Servlet extends HttpServlet {
    @Inject
    private Validator validator;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        var person = Person.builder().build();
        checkValidation(validator.validate(person), "default groups");
        checkValidation(validator.validate(person, MyGroupFirst.class), "group first");
        checkValidation(validator.validate(person, MyGroupSecond.class), "group second");
    }
}

@Builder
class Person {
    @NotNull(message = "field A")
    private String fieldA;
    @NotNull(message = "field B", groups = MyGroupFirst.class)
    private String fieldB;
    @NotNull(message = "field C", groups = MyGroupSecond.class)
    private String fieldC;
    @NotNull(message = "field D", groups = {MyGroupSecond.class, MyGroupFirst.class, Default.class})
    private String fieldD;
}

interface MyGroupFirst {
}

interface MyGroupSecond {
}

