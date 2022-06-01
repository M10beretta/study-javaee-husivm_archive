package com.mber.study.javaee.husivm._063_bean_validation._066_custom_validator;

import com.mber.study.javaee.husivm._063_bean_validation.ValidationUtil;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.*;
import javax.validation.constraints.NotNull;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.net.MalformedURLException;
import java.net.URL;

import static com.mber.study.javaee.husivm._063_bean_validation.StringUtil.stringIsNullOrEmpty;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@WebServlet("066")
public class Servlet extends HttpServlet {
    @Inject
    private Validator validator;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        var siteA = validator.validateValue(Person.class, "siteA", "http://somesyte.com");
        var siteB = validator.validateValue(Person.class, "siteB", "https://mysite.com");
        var siteC = validator.validateValue(Person.class, "siteC", "http://mysite.com");
        var siteD = validator.validateValue(Person.class, "siteD", "ftp://mysite.com:22");
        ValidationUtil.checkValidation(siteA, "siteA");
        ValidationUtil.checkValidation(siteB, "siteB");
        ValidationUtil.checkValidation(siteC, "siteC");
        ValidationUtil.checkValidation(siteD, "siteD");
    }
}

@Getter
@Setter
class Person {
    @CheckSiteUrl(protocol = "mysite.com")
    private String siteA;
    @CheckSiteUrl(protocol = "http")
    private String siteB;
    @CheckSiteUrl(host = "mysite.com")
    private String siteC;
    @CheckSiteUrl(protocol = "http", port = 21)
    @NotNull
    private String siteD;
}

@Constraint(validatedBy = CheckSiteLogic.class)
@Target(FIELD)
@Retention(RUNTIME)
@interface CheckSiteUrl {
    String message() default "Wrong URL";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String protocol() default "";

    String host() default "";

    int port() default -1;
}


class CheckSiteLogic implements ConstraintValidator<CheckSiteUrl, String> {
    private String protocol;
    private String host;
    private int port;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (stringIsNullOrEmpty(value)) {
            return true;
        }

        URL url;
        try {
            url = new URL(value);
        } catch (MalformedURLException e) {
            return false;
        }

        boolean valid = true;
        if (!stringIsNullOrEmpty(protocol) && !protocol.equals(url.getProtocol())) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Protocol invalid").addConstraintViolation();
            valid = false;
        }
        if (!stringIsNullOrEmpty(host) && !host.equals(url.getHost())) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Host invalid").addConstraintViolation();
            valid = false;
        }
        if (port != -1 && port != url.getPort()) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Port invalid").addConstraintViolation();
            valid = false;
        }
        return valid;
    }

    @Override
    public void initialize(@NonNull CheckSiteUrl constraintAnnotation) {
        protocol = constraintAnnotation.protocol();
        host = constraintAnnotation.host();
        port = constraintAnnotation.port();
    }
}
