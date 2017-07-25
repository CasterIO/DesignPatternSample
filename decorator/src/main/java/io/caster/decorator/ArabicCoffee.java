package io.caster.decorator;


public class ArabicCoffee extends BaseCoffee {

    public ArabicCoffee(Size size) {
        super(size, Ingredient.forArabicCoffee(size), 1.1f);
    }

}
