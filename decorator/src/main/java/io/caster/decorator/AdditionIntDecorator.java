package io.caster.decorator;


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
}
