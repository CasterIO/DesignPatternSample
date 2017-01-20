package io.caster.designpatterns.utils;


import android.support.annotation.NonNull;

public class MemoryUtils {

    @NonNull
    public static String findMemoryAddressOf(Object target) {
        String fullName = target.toString();
        int atPosition = fullName.indexOf("@") + 1;
        return fullName.substring(atPosition);
    }
}
