package io.caster.designpatterns.decorator;


import java.util.Locale;

import io.caster.decorator.AlmondMilk;
import io.caster.decorator.ArabicCoffee;
import io.caster.decorator.Beverage;
import io.caster.decorator.Caramel;
import io.caster.decorator.Chocolate;
import io.caster.decorator.Coffee;
import io.caster.decorator.Ingredient;
import io.caster.decorator.Size;

public class DecoratorPresenter {
    private Size size = null;
    private Beverage beverage;

    public void pickSize(Size size) {
        this.size = size;
    }

    public void pickCoffee() {
        checkSize();
        beverage = new Coffee(size);
    }

    private void checkSize() {
        if (size == null) {
            throw new IllegalStateException("Size has not been picked yet!");
        }
    }

    public void pickArabicCoffee() {
        checkSize();
        beverage = new ArabicCoffee(size);
    }

    public void addAlmondMilk() {
        checkCoffee();
        beverage = new AlmondMilk(beverage);
    }

    private void checkCoffee() {
        if (beverage == null) {
            throw new IllegalStateException("Coffee has not been picked yet!");
        }
    }

    public void addCaramel() {
        checkCoffee();
        beverage = new Caramel(beverage);
    }

    public void addChocolate() {
        checkCoffee();
        beverage = new Chocolate(beverage);
    }

    public void addCream() {
        checkCoffee();
        beverage = new Caramel(beverage);
    }

    public void clear() {
        size = null;
        beverage = null;
    }

    public String getCoffeeDescription() {
        StringBuilder builder = new StringBuilder(getFormattedPrice());

        for (Ingredient current : beverage.getIngredients()) {
            builder.append(current.getDescription());
            builder.append("\n");
        }

        return builder.toString();
    }

    private String getFormattedPrice() {
        return String.format(Locale.getDefault(), "Current price: %.2f", beverage.getPrice());
    }

}
