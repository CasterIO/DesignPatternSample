package io.caster.decorator;

public class Coffee extends BaseCoffee {

    public Coffee(Size size) {
        super(size, Ingredient.forCoffee(size), .9f);
    }

}
