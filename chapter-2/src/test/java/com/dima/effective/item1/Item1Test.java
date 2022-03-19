package com.dima.effective.item1;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Item1Test {

    @Test
    public void valueOfTrueTest(){
        assertEquals(Boolean.TRUE, Primitive.valueOf(true));
    }

    @Test
    public void valueOfFalseTest(){
        assertEquals(Boolean.FALSE, Primitive.valueOf(false));
    }
}
