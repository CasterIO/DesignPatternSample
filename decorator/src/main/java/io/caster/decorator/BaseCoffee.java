package io.caster.decorator;

import java.util.ArrayList;
import java.util.List;



public abstract class BaseCoffee implements Beverage{
    private final List<Ingredient> ingredients;
    private final float price;

    BaseCoffee(Size size, Ingredient ingredient, float priceCoefficient) {
        ingredients = new ArrayList<>(1);
        ingredients.add(ingredient);
        price = size.getValue() * priceCoefficient;
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
