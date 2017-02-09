package it.tiwiz.builder;


import android.support.annotation.NonNull;

public class VeryComplexObject {

    private final String first;
    private final String second;
    private final String third;
    private final String fourth;

    public VeryComplexObject(@NonNull String first, @NonNull String second,
                             @NonNull String third, @NonNull String fourth) {
        this.first = first;
        this.second = second;
        this.third = third;
        this.fourth = fourth;
    }

    public String getFirst() {
        return first;
    }

    public String getSecond() {
        return second;
    }

    public String getThird() {
        return third;
    }

    public String getFourth() {
        return fourth;
    }
}
