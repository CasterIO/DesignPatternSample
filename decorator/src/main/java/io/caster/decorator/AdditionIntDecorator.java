package io.caster.decorator;


import java.util.Locale;

public class AdditionIntDecorator implements SimpleIntContainer{
    private final SimpleIntContainer decoratedItem;
    private final int plusValue;

    public AdditionIntDecorator(SimpleIntContainer decoratedItem, int plusValue) {
        this.decoratedItem = decoratedItem;
        this.plusValue = plusValue;
    }

    @Override
    public int getValue() {
        return decoratedItem.getValue() + plusValue;
    }

    @Override
    public String getFormattedValue() {
        return String.format(Locale.getDefault(), "%s + %d", decoratedItem.getFormattedValue(), plusValue);
    }
}
