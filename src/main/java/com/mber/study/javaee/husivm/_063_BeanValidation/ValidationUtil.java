package com.mber.study.javaee.husivm._063_BeanValidation;

import lombok.NonNull;
import lombok.experimental.UtilityClass;

import javax.validation.ConstraintViolation;
import java.util.Set;

@UtilityClass
public class ValidationUtil {

    public static <T extends ConstraintViolation<?>> void checkValidation(@NonNull Set<T> validate, String prefix) {
        if (!validate.isEmpty()) {
            String className = validate.stream().toList().get(0).getRootBeanClass().getName();
            System.out.printf("Not valid %s (%s)    %s%n", prefix, validate.size(), className);
        } else {
            System.out.printf("Is valid %s%n", prefix);
        }
        validate.forEach(x -> System.out.printf("""
                Message: %s
                InvalidValue: %s
                                
                """, x.getMessage(), x.getInvalidValue()));
    }

    public static <T extends ConstraintViolation<?>> void checkValidation(Set<T> validate) {
        checkValidation(validate, "");
    }
}


