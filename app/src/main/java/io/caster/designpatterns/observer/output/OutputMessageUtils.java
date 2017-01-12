package io.caster.designpatterns.observer.output;

import android.support.annotation.NonNull;

import java.util.Locale;

import io.caster.observer.Observer;

public class OutputMessageUtils {

    public static String elaborateMessageFrom(Observer observer, int data) {
        String memoryAddress = findMemoryAddressOf(observer);
        return String.format(Locale.getDefault(), "[Observable %s] received %d", memoryAddress, data);
    }

    @NonNull
    private static String findMemoryAddressOf(Observer observer) {
        String fullName = observer.toString();
        int atPosition = fullName.indexOf("@") + 1;
        return fullName.substring(atPosition);
    }
}
