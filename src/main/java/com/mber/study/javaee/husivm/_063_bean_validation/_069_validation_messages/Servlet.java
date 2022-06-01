package com.mber.study.javaee.husivm._063_bean_validation._069_validation_messages;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.*;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.net.MalformedURLException;
import java.util.Objects;

import static com.mber.study.javaee.husivm._063_bean_validation.ValidationUtil.checkValidation;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@WebServlet("069")
public class Servlet extends HttpServlet {
    @Inject
    private Validator validator;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        checkValidation(validator.validateValue(Person.class, "url", "http://host.com:23"));
    }
}

@Getter
@Setter
@ToString
class Person {
    @URL(port = 22)
    private String url;
}

@Constraint(validatedBy = URLValidator.class)
@Target(FIELD)
@Retention(RUNTIME)
@interface URL {
    String message() default "{javax.validation.url.port.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    int port() default -1;

}

class URLValidator implements ConstraintValidator<URL, String>{
    private int port;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (Objects.isNull(value)) {
            return false;
        }
        java.net.URL url;
        try {
            url = new java.net.URL(value);
        } catch (MalformedURLException e) {
            return false;
        }
        return port == -1 || port == url.getPort();
    }

    @Override
    public void initialize(@NonNull URL constraintAnnotation) {
        port = constraintAnnotation.port();
    }
}