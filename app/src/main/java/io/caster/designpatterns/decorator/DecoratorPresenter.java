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

class DecoratorPresenter {
    private Size size = null;
    private Beverage beverage;

    void pickSize(Size size) {
        this.size = size;
    }

    void pickCoffee() {
        checkSize();
        beverage = new Coffee(size);
    }

    private void checkSize() {
        if (size == null) {
            throw new IllegalStateException("Size has not been picked yet!");
        }
    }

    void pickArabicCoffee() {
        checkSize();
        beverage = new ArabicCoffee(size);
    }

    void addAlmondMilk() {
        checkCoffee();
        beverage = new AlmondMilk(beverage);
    }

    private void checkCoffee() {
        if (beverage == null) {
            throw new IllegalStateException("Coffee has not been picked yet!");
        }
    }

    void addCaramel() {
        checkCoffee();
        beverage = new Caramel(beverage);
    }

    void addChocolate() {
        checkCoffee();
        beverage = new Chocolate(beverage);
    }

    void addCream() {
        checkCoffee();
        beverage = new Caramel(beverage);
    }

    void clear() {
        size = null;
        beverage = null;
    }

    String getCoffeeDescription() {
        StringBuilder builder = new StringBuilder(getFormattedPrice());

        for (Ingredient current : beverage.getIngredients()) {
            builder.append("\n");
            builder.append(current.getDescription());
        }

        return builder.toString();
    }

    private String getFormattedPrice() {
        return String.format(Locale.getDefault(), "Current price: %.2f", beverage.getPrice());
    }

}
