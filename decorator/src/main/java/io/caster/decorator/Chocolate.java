package io.caster.decorator;

import java.util.List;

public class Chocolate implements Beverage{
    private final Beverage decorated;

    public Chocolate(Beverage decorated) {
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
        return 1.8f + decorated.getPrice();
    }
}
