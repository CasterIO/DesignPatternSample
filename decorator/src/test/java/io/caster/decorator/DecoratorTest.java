package io.caster.decorator;

import org.junit.Test;

import java.util.Locale;

import static org.junit.Assert.assertEquals;


public class DecoratorTest {
    private static final int BASE_VALUE = 3;
    private static final int ADDITIONAL_VALUE = 2;
    private static final int DOUBLE_COEFF = 2;

    private final SimpleIntContainer base = new BaseIntContainer(BASE_VALUE);

    @Test
    public void decoratingItemWithAdditionReturnsCorrectValue() throws Exception {
        SimpleIntContainer decorator = new AdditionIntDecorator(base, ADDITIONAL_VALUE);

        assertEquals(BASE_VALUE + ADDITIONAL_VALUE, decorator.getValue());
    }

    @Test
    public void decoratingItemWithDoubleReturnsCorrectValue() throws Exception {
        SimpleIntContainer decorator = new DoubleIntDecorator(base);

        assertEquals(BASE_VALUE * DOUBLE_COEFF, decorator.getValue());
    }

    @Test
    public void decoratingItemsWithAdditionAndDoubleReturnsTheCorrectValue() throws Exception {
        SimpleIntContainer additionDecorator = new AdditionIntDecorator(base, ADDITIONAL_VALUE);
        SimpleIntContainer doubleDecorator = new DoubleIntDecorator(additionDecorator);

        final int expectedValue = DOUBLE_COEFF * (BASE_VALUE + ADDITIONAL_VALUE);
        assertEquals(expectedValue, doubleDecorator.getValue());
    }

    @Test
    public void decoratingItemWithDoubleAndAdditionReturnsTheCorrectValue() throws Exception {
        SimpleIntContainer doubleDecorator = new DoubleIntDecorator(base);
        SimpleIntContainer additionDecorator = new AdditionIntDecorator(doubleDecorator, ADDITIONAL_VALUE);

        final int expectedValue = ADDITIONAL_VALUE + (BASE_VALUE * DOUBLE_COEFF);
        assertEquals(expectedValue, additionDecorator.getValue());
    }

    @Test
    public void decoratingItemWithAdditionShowsCorrectString() throws Exception {
        SimpleIntContainer decorator = new AdditionIntDecorator(base, ADDITIONAL_VALUE);
        String expectedValue = String.format(Locale.getDefault(), "%d + %d", BASE_VALUE, ADDITIONAL_VALUE);

        assertEquals(expectedValue, decorator.getFormattedValue());
    }

    @Test
    public void decoratingWithDoubleShowsCorrectString() throws Exception {
        SimpleIntContainer doubleDecorator = new DoubleIntDecorator(base);
        String expectedValue = String.format(Locale.getDefault(), "%d * %d", BASE_VALUE, DOUBLE_COEFF);

        assertEquals(expectedValue, doubleDecorator.getFormattedValue());
    }

    @Test
    public void decoratingItemsWithAdditionAndDoubleShowsCorrectString() throws Exception {
        SimpleIntContainer additionDecorator = new AdditionIntDecorator(base, ADDITIONAL_VALUE);
        SimpleIntContainer doubleDecorator = new DoubleIntDecorator(additionDecorator);
        String expectedValue = String.format(Locale.getDefault(), "%d + %d * %d", BASE_VALUE, ADDITIONAL_VALUE, DOUBLE_COEFF);

        assertEquals(expectedValue, doubleDecorator.getFormattedValue());
    }

    @Test
    public void decoratingItemWithDoubleAndAdditionShowsCorrectString() throws Exception {
        SimpleIntContainer doubleDecorator = new DoubleIntDecorator(base);
        SimpleIntContainer additionDecorator = new AdditionIntDecorator(doubleDecorator, ADDITIONAL_VALUE);
        String expectedValue = String.format(Locale.getDefault(), "%d * %d + %d", BASE_VALUE, DOUBLE_COEFF, ADDITIONAL_VALUE);

        assertEquals(expectedValue, additionDecorator.getFormattedValue());
    }

}
