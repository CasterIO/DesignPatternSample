package io.caster.decorator;


import static io.caster.decorator.Prices.ARABIC_COFFEE;

public class ArabicCoffee extends BaseCoffee {

    public ArabicCoffee(Size size) {
        super(size, Ingredient.forArabicCoffee(size), ARABIC_COFFEE);
    }

}
