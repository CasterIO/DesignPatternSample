package io.caster.decorator;

public enum Size {
    XS(.25f),
    S(.5f),
    M(1f),
    L(1.5f),
    XL(2f);

    private final float value;

    Size(float value) {
        this.value = value;
    }

    public float getValue() {
        return value;
    }
}
