package com.mber.study.javaee.husivm._05_bean_validation;

import lombok.experimental.UtilityClass;
import org.jetbrains.annotations.Contract;

@UtilityClass
public class StringUtil {

    @Contract(value = "null -> true", pure = true)
    public static boolean stringIsNullOrEmpty(String string) {
        return string == null || string.isEmpty();
    }

    @Contract(value = "null -> false", pure = true)
    public static boolean stringNotNullOrEmpty(String string) {
        return string != null && !string.isEmpty();
    }
}
