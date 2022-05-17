package com.mber.study.javaee.husivm._063_BeanValidation._065_CustomCompositeValodator;

import com.mber.study.javaee.husivm._063_BeanValidation.ValidationUtil;
import lombok.Getter;
import lombok.Setter;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.Validator;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@WebServlet("065")
public class Servlet extends HttpServlet {
    @Inject
    private Validator validator;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        var emailA = validator.validateValue(Person.class, "email", "mymail@gmail.com");
        var emailB = validator.validateValue(Person.class, "email", "mymail@gmail.ru");
        ValidationUtil.checkValidation(emailA, "mymail@gmail.com");
        ValidationUtil.checkValidation(emailB, "mymail@gmail.ru");
    }
}

@Getter
@Setter
class Person {
    @CheckEmail
    private String email;
}

@NotNull
@Size(min = 7)
@Pattern(regexp = "^[A-Za-z0-9]+@[a-z]+\\.com$")
@Constraint(validatedBy = {})
@Target(FIELD)
@Retention(RUNTIME)
@interface CheckEmail {
    String message() default "Email address doesn`t look good";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}



