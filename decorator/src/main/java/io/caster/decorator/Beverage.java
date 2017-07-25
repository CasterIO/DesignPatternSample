package io.caster.decorator;

import java.util.List;

public interface Beverage {

    List<Ingredient> getIngredients();
    float getPrice();
}
