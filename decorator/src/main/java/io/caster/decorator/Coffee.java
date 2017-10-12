package io.caster.decorator;

import static io.caster.decorator.Prices.COFFEE;

public class Coffee extends BaseCoffee {

    public Coffee(Size size) {
        super(size, Ingredient.forCoffee(size), COFFEE);
    }

}
