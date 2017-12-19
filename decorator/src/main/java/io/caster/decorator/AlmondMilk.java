package io.caster.decorator;

import java.util.List;

import static io.caster.decorator.Prices.ALMOND_MILK;


public class AlmondMilk implements Beverage {
    private final Beverage decorated;

    public AlmondMilk(Beverage decorated) {
        this.decorated = decorated;
    }

    @Override
    public List<Ingredient> getIngredients() {
        List<Ingredient> ingredients = decorated.getIngredients();
        ingredients.add(Ingredient.almondMilk());
        return ingredients;
    }

    @Override
    public float getPrice() {
        return ALMOND_MILK.getValue() + decorated.getPrice();
    }
}
