package com.mber.study.javaee.husivm._063_BeanValidation;

import lombok.experimental.UtilityClass;
import org.jetbrains.annotations.Contract;

@UtilityClass
public class StringUtil {

    @Contract(value = "null -> true", pure = true)
    public static boolean stringIsNullOrEmpty(String string) {
        return string == null || string.isEmpty();
    }
}
