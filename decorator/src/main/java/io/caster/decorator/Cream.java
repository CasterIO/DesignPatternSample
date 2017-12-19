package io.caster.decorator;

import java.util.List;

import static io.caster.decorator.Prices.CREAM;


public class Cream implements Beverage {
    private final Beverage decorated;

    public Cream(Beverage decorated) {
        this.decorated = decorated;
    }

    @Override
    public List<Ingredient> getIngredients() {
        List<Ingredient> ingredients = decorated.getIngredients();
        ingredients.add(Ingredient.cream());
        return ingredients;
    }

    @Override
    public float getPrice() {
        return CREAM.getValue() + decorated.getPrice();
    }
}
