package io.caster.decorator;



public class DoubleIntDecorator implements SimpleIntContainer{
    private final SimpleIntContainer decoratedItem;

    public DoubleIntDecorator(SimpleIntContainer decoratedItem) {
        this.decoratedItem = decoratedItem;
    }

    @Override
    public int getValue() {
        return decoratedItem.getValue() * 2;
    }
}
