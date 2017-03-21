package io.caster.decorator;


public class BaseIntContainer implements SimpleIntContainer{

    private final int value;
    private final String formattedValue;

    public BaseIntContainer(int value) {
        this.value = value;
        formattedValue = String.valueOf(value);
    }

    @Override
    public int getValue() {
        return value;
    }

    @Override
    public String getFormattedValue() {
        return formattedValue;
    }
}
