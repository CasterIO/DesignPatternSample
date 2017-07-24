package io.caster.decorator;

import java.util.ArrayList;
import java.util.List;

public class Coffee implements BaseCoffee{
    private final List<Ingredient> ingredients;
    private final float price;

    public Coffee(Size size) {
        ingredients = new ArrayList<>(1);
        ingredients.add(Ingredient.forCoffee(size));
        price = size.getValue() * 0.9f;
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
