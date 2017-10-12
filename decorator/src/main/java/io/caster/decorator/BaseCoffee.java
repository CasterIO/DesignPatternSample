package io.caster.decorator;

import java.util.ArrayList;
import java.util.List;



public abstract class BaseCoffee implements Beverage{
    private final List<Ingredient> ingredients;
    private final float price;

    BaseCoffee(Size size, Ingredient ingredient, Prices priceCoefficient) {
        ingredients = new ArrayList<>(1);
        ingredients.add(ingredient);
        price = priceCoefficient.withSize(size);
    }

    @Override
    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    @Override
    public float getPrice() {
        return price;
    }
}
