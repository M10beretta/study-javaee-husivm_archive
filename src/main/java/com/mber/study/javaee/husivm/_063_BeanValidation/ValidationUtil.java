package com.mber.study.javaee.husivm._063_BeanValidation;


import lombok.experimental.UtilityClass;
import org.jetbrains.annotations.NotNull;

import javax.validation.ConstraintViolation;
import java.util.Set;

@UtilityClass
public class ValidationUtil {

    public <T extends ConstraintViolation<?>> void checkValidation(@NotNull Set<T> validate, String prefix) {
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

    public <T extends ConstraintViolation<?>> void checkValidation(Set<T> validate) {
        checkValidation(validate, "");
    }
}


