package io.caster.decorator;


public class BaseIntContainer implements SimpleIntContainer{

    private final int value;

    public BaseIntContainer(int value) {
        this.value = value;
    }

    @Override
    public int getValue() {
        return value;
    }
}
