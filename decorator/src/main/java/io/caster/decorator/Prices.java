package io.caster.decorator;


public enum Prices {
    COFFEE(.9f),
    ARABIC_COFFEE(1.1f),
    CREAM(.5f),
    CARAMEL(1.4f),
    CHOCOLATE(1.8f),
    ALMOND_MILK(2f);

    private final float value;

    Prices(float value) {
        this.value = value;
    }

    public float getValue() {
        return value;
    }

    public float withSize(Size size) {
        return value * size.getValue();
    }
}
