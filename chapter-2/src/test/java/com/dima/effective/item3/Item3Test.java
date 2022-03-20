package com.dima.effective.item3;

import com.dima.effective.item3.lazylaod.LazySingleton;
import com.dima.effective.item3.staticfactory.Elvis;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class Item3Test {

    @Test
    public void lazySingletonTest(){
        assertNotEquals(null, LazySingleton.getInstance());
    }

    @Test
    public void elvisTest(){
        assertNotEquals(null, Elvis.getInstance());
    }
}
