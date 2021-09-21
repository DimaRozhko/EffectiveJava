package com.dima.effective.item3.lazylaod;

public class LazySingleton {

    private static volatile LazySingleton lazySingleton = null;

    LazySingleton() {}

    public static synchronized LazySingleton getInstance() {
        if (lazySingleton == null) {
            LazySingleton.lazySingleton = new LazySingleton();
        }
        return lazySingleton;
    }
}
