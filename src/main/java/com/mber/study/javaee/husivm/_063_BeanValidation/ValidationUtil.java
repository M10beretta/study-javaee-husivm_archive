package com.mber.study.javaee.husivm._063_BeanValidation;

import lombok.experimental.UtilityClass;

import javax.validation.ConstraintViolation;
import java.util.Objects;
import java.util.Set;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@UtilityClass
public class ValidationUtil {

    public static <T extends ConstraintViolation<?>> void checkValidation(Set<T> validate, String prefix) {
        if (Objects.isNull(validate) || validate.isEmpty()) {
            System.out.printf("%nIs valid:  %s%n", prefix);
            return;
        }

        var notValidClasses = validate.stream()
                .map(x -> x.getRootBeanClass())
                .map(Class::getName)
                .distinct()
                .map(ValidationUtil::cutClassName)
                .filter(StringUtil::stringNotNullOrEmpty)
                .toList();

        var errorMessages = validate.stream()
                .map(ValidationUtil::getValidationMessage)
                .collect(Collectors.joining(""));

        System.out.println(String.format("%nNot valid: %s (%s)%n", prefix, validate.size())
                           + errorMessages
                           + String.format("  classes: %s", notValidClasses));
    }

    public static <T extends ConstraintViolation<?>> void checkValidation(Set<T> validate) {
        checkValidation(validate, "<noname>");
    }

    private static String cutClassName(String className) {
        return Pattern.compile("[\\w]+.[\\w]+$")
                .matcher(className)
                .results()
                .map(MatchResult::group)
                .findAny()
                .orElse("");
    }

    private static String getValidationMessage(ConstraintViolation<?> x) {
        return String.format("""
                  message: %s
                  value:   %s
                """, x.getMessage(), x.getInvalidValue());
    }
}


