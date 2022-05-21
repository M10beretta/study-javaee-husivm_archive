package com.mber.study.javaee.husivm._063_BeanValidation._067_ValidationOfClasses;

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
import java.time.LocalDate;

import static com.mber.study.javaee.husivm._063_BeanValidation.ValidationUtil.checkValidation;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@WebServlet("067")
public class Servlet extends HttpServlet {
    @Inject
    private Validator validator;
    @Inject
    private Person mike;
    @Inject
    private Person hank;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        LocalDate dateA = LocalDate.of(2000, 1, 1);
        LocalDate dateB = LocalDate.of(2070, 1, 1);

        constructPerson(mike, dateA, dateB);
        constructPerson(hank, dateB, dateA);

        checkValidation(validator.validate(mike), mike.toString());
        checkValidation(validator.validate(hank), mike.toString());
    }

    private void constructPerson(@NonNull Person mike, LocalDate dateA, LocalDate dateB) {
        mike.setBirthDate(dateA);
        mike.setDeathDate(dateB);
    }
}

@ChronDates
@Getter
@Setter
@ToString
class Person {
    private LocalDate birthDate;
    private LocalDate deathDate;
}

@Constraint(validatedBy = CheckChronologicalDates.class)
@Target(TYPE)
@Retention(RUNTIME)
@interface ChronDates {
    String message() default "dates invalid";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

class CheckChronologicalDates implements ConstraintValidator<ChronDates, Person> {
    @Override
    public boolean isValid(@NonNull Person person, ConstraintValidatorContext context) {
        return person.getBirthDate().isBefore(person.getDeathDate());
    }
}
