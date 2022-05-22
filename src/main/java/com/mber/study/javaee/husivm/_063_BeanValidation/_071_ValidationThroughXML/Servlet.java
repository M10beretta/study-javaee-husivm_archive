package com.mber.study.javaee.husivm._063_BeanValidation._071_ValidationThroughXML;

import lombok.Builder;
import lombok.ToString;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Validator;

import static com.mber.study.javaee.husivm._063_BeanValidation.ValidationUtil.checkValidation;

@WebServlet("071")
public class Servlet extends HttpServlet {
    @Inject
    private Validator validator;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        var person = Person.builder().build();
        checkValidation(validator.validate(person), person.toString());
    }
}

@Builder
@ToString
class Person {
    private String name;
    private int age;
}