package it.tiwiz.builder;


import android.support.annotation.NonNull;

class VeryComplexObject {

    private final String first;
    private final String second;
    private final String third;
    private final String fourth;

    VeryComplexObject(@NonNull String first, @NonNull String second,
                      @NonNull String third, @NonNull String fourth) {
        this.first = first;
        this.second = second;
        this.third = third;
        this.fourth = fourth;
    }

    String getFirst() {
        return first;
    }

    String getSecond() {
        return second;
    }

    String getThird() {
        return third;
    }

    String getFourth() {
        return fourth;
    }

    public static class Builder {

        private String first;
        private String second;
        private String third;
        private String fourth;

        public Builder setFirst(String first) {
            this.first = first;
            return this;
        }

        public Builder setSecond(String second) {
            this.second = second;
            return this;
        }

        public Builder setThird(String third) {
            this.third = third;
            return this;
        }

        public Builder setFourth(String fourth) {
            this.fourth = fourth;
            return this;
        }

        public VeryComplexObject build() {
            return new VeryComplexObject(first, second, third, fourth);
        }
    }
}
