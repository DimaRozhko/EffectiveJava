package com.dima.effective.item3.staticfactory;

public class Elvis {

    private static final Elvis elvis = new Elvis();

    private Elvis() {}

    public static Elvis getInstance() {
        return Elvis.elvis;
    }
}
