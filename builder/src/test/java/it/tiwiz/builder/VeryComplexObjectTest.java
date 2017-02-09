package it.tiwiz.builder;

import junit.framework.Assert;

import org.junit.Test;


public class VeryComplexObjectTest {
    private final String FIRST = "first element";
    private final String SECOND = "second element";
    private final String THIRD = "third_element";
    private final String FOURTH = "fourth-element";

    @Test
    public void testStringsAreInCorrectOrder() throws Exception {
        VeryComplexObject obj = new VeryComplexObject(FIRST, SECOND, THIRD, FOURTH);

        Assert.assertEquals(FIRST, obj.getFirst());
        Assert.assertEquals(SECOND, obj.getSecond());
        Assert.assertEquals(THIRD, obj.getThird());
        Assert.assertEquals(FOURTH, obj.getFourth());
    }
}