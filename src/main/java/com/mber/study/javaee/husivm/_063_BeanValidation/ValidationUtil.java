package com.mber.study.javaee.husivm._063_BeanValidation;

import lombok.experimental.UtilityClass;
import org.jetbrains.annotations.Contract;

import javax.validation.ConstraintViolation;
import java.util.Objects;
import java.util.Set;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@UtilityClass
public class ValidationUtil {

    public static <T extends ConstraintViolation<?>> void checkValidation(Set<T> validate, String prefix) {
        var sb = new StringBuilder();

        if (Objects.isNull(validate) || validate.isEmpty()) {
            sb.append(String.format("Is valid:  %s%n", prefix));
        } else {
            var errorMessages = validate.stream()
                    .map(ValidationUtil::getValidationMessage)
                    .collect(Collectors.joining("\n"));

            var notValidClasses = validate.stream()
                    .map(x -> x.getRootBeanClass())
                    .map(Class::getName)
                    .distinct()
                    .map(ValidationUtil::cutClassName)
                    .filter(StringUtil::stringNotNullOrEmpty)
                    .toList();

            sb.append(String.format("""
                            %s
                            %s
                            %s
                            """,
                    String.format("Not valid: %s (%s)", prefix, validate.size()),
                    errorMessages,
                    String.format("\s\sclasses: %s", notValidClasses)));
        }
        System.out.println(sb);
    }

    public static <T extends ConstraintViolation<?>> void checkValidation(Set<T> validate) {
        checkValidation(validate, "<noname>");
    }

    @Contract("_ -> !null")
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
                \s\smessage: %s
                \s\svalue:   %s""", x.getMessage(), x.getInvalidValue());
    }
}


