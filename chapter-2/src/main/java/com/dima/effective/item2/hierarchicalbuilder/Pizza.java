package com.dima.effective.item2.hierarchicalbuilder;

import java.util.EnumSet;
import java.util.Set;

public abstract class Pizza {

    public enum Topping{ HAM, MUSHROOM, ONION, PEPPER, SAUSAGE }
    public final Set<Topping> toppings;

    abstract static class Builder<T extends Builder<T>> {
        EnumSet<Topping> toppings = EnumSet.noneOf(Topping.class);
        public T addTopping (Topping topping) {
            this.toppings.add(topping);
            return self();
        }

        protected abstract T self();

        abstract Pizza build();
    }

    Pizza (Builder<?> builder) {
        toppings = builder.toppings.clone();
    }
}
