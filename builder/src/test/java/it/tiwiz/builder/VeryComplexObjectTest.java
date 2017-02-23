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

    @Test
    public void testBuilderCreatesCorrectlyTheObject() throws Exception {
        VeryComplexObject obj = new VeryComplexObject.Builder()
                .setSecond(SECOND)
                .setFourth(FOURTH)
                .setFirst(FIRST)
                .setThird(THIRD)
                .build();

        Assert.assertEquals(FIRST, obj.getFirst());
        Assert.assertEquals(SECOND, obj.getSecond());
        Assert.assertEquals(THIRD, obj.getThird());
        Assert.assertEquals(FOURTH, obj.getFourth());
    }

    @Test
    public void testBuilderCreatesCorrectlyTheObjectWithNoFluidApiUsage() throws Exception {
        VeryComplexObject.Builder builder = new VeryComplexObject.Builder();
        builder.setSecond(SECOND);
        builder.setFourth(FOURTH);
        builder.setFirst(FIRST);
        builder.setThird(THIRD);
        VeryComplexObject obj = builder.build();

        Assert.assertEquals(FIRST, obj.getFirst());
        Assert.assertEquals(SECOND, obj.getSecond());
        Assert.assertEquals(THIRD, obj.getThird());
        Assert.assertEquals(FOURTH, obj.getFourth());
    }
}