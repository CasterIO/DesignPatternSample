package io.caster.decorator;

import java.util.List;

import static io.caster.decorator.Prices.CHOCOLATE;

public class Chocolate implements Beverage{
    private final Beverage decorated;

    public Chocolate(Beverage decorated) {
        this.decorated = decorated;
    }

    @Override
    public List<Ingredient> getIngredients() {
        List<Ingredient> ingredients = decorated.getIngredients();
        ingredients.add(Ingredient.chocolate());
        return ingredients;
    }

    @Override
    public float getPrice() {
        return CHOCOLATE.getValue() + decorated.getPrice();
    }
}
