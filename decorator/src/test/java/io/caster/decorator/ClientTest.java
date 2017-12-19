package io.caster.decorator;

import org.junit.Test;

import static io.caster.decorator.Prices.ALMOND_MILK;
import static io.caster.decorator.Prices.ARABIC_COFFEE;
import static io.caster.decorator.Prices.CARAMEL;
import static io.caster.decorator.Prices.CHOCOLATE;
import static io.caster.decorator.Prices.COFFEE;
import static io.caster.decorator.Prices.PUMPKIN_SPICE;
import static io.caster.decorator.Size.M;
import static org.assertj.core.api.Assertions.assertThat;


public class ClientTest {

    @Test
    public void first_client() throws Exception {
        Beverage test = new Coffee(M);
        assertThat(test.getPrice())
                .isEqualTo(COFFEE.withSize(M));
    }

    @Test
    public void second_client() throws Exception {
        Beverage test = new AlmondMilk(new ArabicCoffee(M));
        float expectedPrice = ALMOND_MILK.getValue() + ARABIC_COFFEE.withSize(M);
        assertThat(test.getPrice())
                .isEqualTo(expectedPrice);
    }

    @Test
    public void third_client() throws Exception {
        Beverage test = new Chocolate(
                new Caramel(
                        new AlmondMilk(
                                new Coffee(M)
                        )
                )
        );

        float expectedPrice = CHOCOLATE.getValue() +
                CARAMEL.getValue() + ALMOND_MILK.getValue() +
                COFFEE.withSize(M);

        assertThat(test.getPrice())
                .isEqualTo(expectedPrice);
    }

    @Test
    public void fourth_client() throws Exception {
        Beverage test = new PumpkinSpice(
                new Chocolate(
                        new ArabicCoffee(M)
                )
        );

        float expectedPrice = PUMPKIN_SPICE.getValue() + CHOCOLATE.getValue()
                + ARABIC_COFFEE.withSize(M);

        assertThat(test.getPrice()).isEqualTo(expectedPrice);
    }
}
