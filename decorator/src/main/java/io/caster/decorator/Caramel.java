package io.caster.decorator;


import java.util.List;

import static io.caster.decorator.Prices.CARAMEL;

public class Caramel implements Beverage {
    private final Beverage decorated;

    public Caramel(Beverage decorated) {
        this.decorated = decorated;
    }

    @Override
    public List<Ingredient> getIngredients() {
        List<Ingredient> ingredients = decorated.getIngredients();
        ingredients.add(Ingredient.caramel());
        return ingredients;
    }

    @Override
    public float getPrice() {
        return CARAMEL.getValue() + decorated.getPrice();
    }
}
