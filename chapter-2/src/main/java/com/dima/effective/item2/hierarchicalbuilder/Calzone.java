package com.dima.effective.item2.hierarchicalbuilder;

public class Calzone extends Pizza {

    public final boolean sauceInstance;

    public static class Builder extends Pizza.Builder<Builder> {

        private boolean sauceInstance = false;

        public Builder sauceInstance() {
            this.sauceInstance = true;
            return this;
        }

        @Override
        public Builder self() {
            return this;
        }

        @Override
        public Calzone build() {
            return new Calzone(this);
        }
    }

    private Calzone (Builder builder) {
        super(builder);
        this.sauceInstance = builder.sauceInstance;
    }
}
