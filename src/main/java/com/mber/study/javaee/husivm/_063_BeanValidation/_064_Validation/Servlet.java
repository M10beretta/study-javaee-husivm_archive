package com.mber.study.javaee.husivm._063_BeanValidation._064_Validation;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Set;

@WebServlet("064")
public class Servlet extends HttpServlet {

    @Inject
    private Person person;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        person.setName("Mike56");
        person.setAge(12);

        var validatorFactory = Validation.buildDefaultValidatorFactory();
        var validator = validatorFactory.getValidator();
        var validate = validator.validate(person);

        checkValidation(validate, person.toString());

        var name = validator.validateProperty(person, "name");
        checkValidation(name, "person name");

        var valueA = validator.validateValue(Person.class, "name", "Tom");
        var valueB = validator.validateValue(Person.class, "name", "Hank Moody");
        checkValidation(valueA, "name Tom");
        checkValidation(valueB, "name Hank Moody");

        //<editor-fold desc="fail to NotNull">
        try {
            var setName = Person.class.getMethod("setName", String.class);
            var executableValidator = validator.forExecutables();
            var violations = executableValidator.validateParameters(Person.class, setName, new Object[]{null});
            if (violations.isEmpty()) {
                System.out.println("violations is empty");
            } else {
                System.out.println("violations isn't empty");
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        //</editor-fold>

        validatorFactory.close();
    }


    private void checkValidation(Set<ConstraintViolation<Person>> validate, String prefix) {
        if (!validate.isEmpty()) {
            System.out.printf("%s not valid, size - %s%n", prefix, validate.size());
        } else {
            System.out.printf("%s is valid%n", prefix);
        }
        validate.forEach(x -> System.out.printf("""
                Message: %s
                InvalidValue: %s
                """, x.getMessage(), x.getInvalidValue()));
        System.out.println("------------------");
    }
}

@Getter
@Setter
@ToString
class Person {
    @Pattern(regexp = "^[A-Za-z]+$")
    private String name;
    @Min(18)
    private int age;

    //<editor-fold desc="fail to NotNull">
    @NotNull
    public String getName() {
        return name;
    }

    public void setName(@NotNull String name) {
        this.name = name;
    }
    //</editor-fold>
}

