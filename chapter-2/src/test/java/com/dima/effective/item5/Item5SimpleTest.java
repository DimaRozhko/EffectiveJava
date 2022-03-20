package com.dima.effective.item5;

import com.dima.effective.item5.constants.Value;
import com.dima.effective.item5.simple.SpellChecker;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static com.dima.effective.item5.constants.Condition.NOT_VALID;
import static com.dima.effective.item5.constants.Condition.VALID;
import static com.dima.effective.item5.constants.Value.*;
import static org.junit.jupiter.api.Assertions.*;

public class Item5SimpleTest {

    @Test
    public void fireIsValidTest(){
        assertTrue(SpellChecker.isValid(Value.FIRE));
    }

    @Test
    public void getIsValidTest(){
        assertFalse(SpellChecker.isValid(Value.GET));
    }

    @Test
    public void cookiesIsValidTest(){
        assertTrue(SpellChecker.isValid(Value.COOKIES));
    }

    @Test
    public void suggestionValidTest() {
        assertEquals(new ArrayList<String>(Arrays.asList(FIRE, COOKIES)), SpellChecker.suggestion(VALID));
    }

    @Test
    public void suggestionNotValidTest() {
        assertEquals(new ArrayList<String>(Arrays.asList(GET)), SpellChecker.suggestion(NOT_VALID));
    }
}
