package io.caster.decorator;


import java.util.Locale;

public final class Ingredient {

    private static final String WEIGHT = "g";
    private static final String VOLUME = "mL";

    static Ingredient forCoffee(Size size) {
        return new Ingredient("Coffee powder", size.getValue() * 10, WEIGHT);
    }

    static Ingredient forArabicCoffee(Size size) {
        return new Ingredient("Refined arabic coffee powder", size.getValue() * 8, WEIGHT);
    }

    static Ingredient cream(){
        return new Ingredient("Milk cream", 15, VOLUME);
    }

    static Ingredient almondMilk() {
        return new Ingredient("Almond milk", 15, VOLUME);
    }

    static Ingredient chocolate() {
        return new Ingredient("Chocolate", 10, VOLUME);
    }

    static Ingredient caramel() {
        return new Ingredient("Caramel", 2, VOLUME);
    }

    private final String description;

    private Ingredient(String description, float quantity, String measureUnit) {
        this.description = String.format(Locale.getDefault(),"%s (%.2f %s)", description, quantity, measureUnit);
    }

    public String getDescription() {
        return description;
    }
}
