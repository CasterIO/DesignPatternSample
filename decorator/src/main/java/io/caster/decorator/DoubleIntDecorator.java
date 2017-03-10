package io.caster.decorator;


import java.util.Locale;

public class DoubleIntDecorator implements SimpleIntContainer{
    private final SimpleIntContainer decoratedItem;

    public DoubleIntDecorator(SimpleIntContainer decoratedItem) {
        this.decoratedItem = decoratedItem;
    }

    @Override
    public int getValue() {
        return decoratedItem.getValue() * 2;
    }

    @Override
    public String getFormattedValue() {
        return String.format(Locale.getDefault(), "%s * 2", decoratedItem.getFormattedValue());
    }
}
