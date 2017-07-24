package io.caster.decorator;


import java.util.ArrayList;
import java.util.List;

public class ArabicCoffee implements BaseCoffee{
    private final List<Ingredient> ingredients;
    private final float price;

    public ArabicCoffee(Size size) {
        ingredients = new ArrayList<>(1);
        ingredients.add(Ingredient.forArabicCoffee(size));
        price = size.getValue() * 1.1f;
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
