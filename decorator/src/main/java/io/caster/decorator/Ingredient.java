package io.caster.decorator;


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

    private final String description;
    private final float quantity;
    private final String measureUnit;

    private Ingredient(String description, float quantity, String measureUnit) {
        this.description = description;
        this.quantity = quantity;
        this.measureUnit = measureUnit;
    }

    public String getDescription() {
        return description;
    }

    public String getQuantity() {
        return quantity + " " + measureUnit;
    }
}
