package io.caster.decorator;


public final class Ingredient {

    static Ingredient forCoffee(Size size) {
        return new Ingredient("Coffee powder", size.getValue() * 10);
    }

    static Ingredient forArabicCoffee(Size size) {
        return new Ingredient("Refined arabic coffee powder", size.getValue() * 8);
    }

    private final String description;
    private final float quantity;

    private Ingredient(String description, float quantity) {
        this.description = description;
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public float getQuantity() {
        return quantity;
    }
}
