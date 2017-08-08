package io.caster.decorator;

import java.util.List;


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
        return 2 + decorated.getPrice();
    }
}
