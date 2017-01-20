package io.caster.designpatterns.observer.output;

import java.util.Locale;

import io.caster.designpatterns.utils.MemoryUtils;
import io.caster.observer.Observer;

public class OutputMessageUtils {

    public static String elaborateMessageFrom(Observer observer, int data) {
        String memoryAddress = MemoryUtils.findMemoryAddressOf(observer);
        return String.format(Locale.getDefault(), "[Observable %s] received %d", memoryAddress, data);
    }
}
