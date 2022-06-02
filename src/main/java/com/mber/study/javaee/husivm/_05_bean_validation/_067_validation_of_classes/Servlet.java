package com.mber.study.javaee.husivm._05_bean_validation._067_validation_of_classes;

import lombok.*;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.*;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.time.LocalDate;

import static com.mber.study.javaee.husivm._05_bean_validation.ValidationUtil.checkValidation;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@WebServlet("067")
public class Servlet extends HttpServlet {
    @Inject
    private Validator validator;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        LocalDate dateBefore = LocalDate.of(2000, 1, 1);
        LocalDate dateAfter = LocalDate.of(2070, 1, 1);

        var personA = Person.builder().birthDate(dateBefore).deathDate(dateAfter).build();
        var personB = Person.builder().birthDate(dateBefore).deathDate(dateBefore).build();
        var personC = Person.builder().birthDate(dateAfter).deathDate(dateBefore).build();

        checkValidation(validator.validate(personA), personA.toString());
        checkValidation(validator.validate(personB), personB.toString());
        checkValidation(validator.validate(personC), personC.toString());
    }
}

@ChronDates
@Builder
@Getter
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
