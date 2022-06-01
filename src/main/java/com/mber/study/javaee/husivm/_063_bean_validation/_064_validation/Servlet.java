package com.mber.study.javaee.husivm._063_bean_validation._064_validation;

import lombok.Builder;
import lombok.ToString;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Validation;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import static com.mber.study.javaee.husivm._063_bean_validation.ValidationUtil.checkValidation;

@WebServlet("064")
public class Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        var person = Person.builder().name("Mike22").age(12).build();

        var validatorFactory = Validation.buildDefaultValidatorFactory();
        var validator = validatorFactory.getValidator();
        var validate = validator.validate(person);
        checkValidation(validate, person.toString());

        checkValidation(validator.validateProperty(person, "name"), "property name " + person);
        checkValidation(validator.validateValue(Person.class, "name", "Tom"), "name Tom");
        checkValidation(validator.validateValue(Person.class, "name", "Hank Moody"), "name Hank Moody");

        person.setName(null);
        checkValidation(validator.validate(person), person.toString());

        validatorFactory.close();
    }
}

@Builder
@ToString
class Person {
    @Pattern(regexp = "^[A-Za-z]+$")
    private String name;
    @Min(18)
    private int age;

    @NotNull
    public String getName() {
        return name;
    }

    public void setName(@NotNull/*not used*/ String name) {
        this.name = name;
    }
}