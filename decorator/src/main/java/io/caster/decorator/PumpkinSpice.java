package io.caster.decorator;

import java.util.List;

import static io.caster.decorator.Prices.*;

public class PumpkinSpice implements Beverage{

    private final Beverage internal;

    public PumpkinSpice(Beverage internal) {
        this.internal = internal;
    }

    @Override
    public List<Ingredient> getIngredients() {
        List<Ingredient> ingredients = internal.getIngredients();
        ingredients.add(Ingredient.pumpkinSpice());
        return ingredients;
    }

    @Override
    public float getPrice() {
        return internal.getPrice() + PUMPKIN_SPICE.getValue();
    }
}
