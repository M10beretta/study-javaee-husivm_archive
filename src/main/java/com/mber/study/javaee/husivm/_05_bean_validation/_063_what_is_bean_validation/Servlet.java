package com.mber.study.javaee.husivm._05_bean_validation._063_what_is_bean_validation;

import lombok.Getter;
import lombok.Setter;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.*;
import java.time.LocalDate;

@WebServlet("063")
public class Servlet extends HttpServlet {
    @Inject
    private Person person;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        person.setAge(12);
        System.out.println(person.getAge());
    }
}

@Getter
@Setter
class Person {
    @NotNull
    @Pattern.List({
            @Pattern(regexp = "[a-zA-Z]+"),
            @Pattern(regexp = "")})
    private String name;
    @Min(18)
    private int age;
    @Size(min = 10, max = 200)
    String description;
    @Past
    LocalDate birthDate;
    @Future
    LocalDate retirementDate;

    String surname;

    @NotNull
    public String getSurname() {
        return surname;
    }

    public Person setSurname(@NotNull @Pattern(regexp = "[A-z]") String surname) {
        this.surname = surname;
        return this;
    }
}

