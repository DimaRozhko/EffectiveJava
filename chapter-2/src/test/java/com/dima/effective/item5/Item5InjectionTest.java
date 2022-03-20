package com.dima.effective.item5;

import com.dima.effective.item5.constants.Value;
import com.dima.effective.item5.injection.SpellCheckerInjection;
import com.dima.effective.item5.utility.UtilityLexicon;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static com.dima.effective.item5.constants.Condition.*;
import static com.dima.effective.item5.constants.Value.*;
import static org.junit.jupiter.api.Assertions.*;

public class Item5InjectionTest {

    @Test
    public void fireIsValidTest(){
        SpellCheckerInjection spellCheckerInjection = new SpellCheckerInjection(UtilityLexicon.dictionaryCreator());
        assertTrue(spellCheckerInjection.isValid(Value.FIRE));
    }

    @Test
    public void getIsValidTest(){
        SpellCheckerInjection spellCheckerInjection = new SpellCheckerInjection(UtilityLexicon.dictionaryCreator());
        assertFalse(spellCheckerInjection.isValid(Value.GET));
    }

    @Test
    public void cookiesIsValidTest(){
        SpellCheckerInjection spellCheckerInjection = new SpellCheckerInjection(UtilityLexicon.dictionaryCreator());
        assertTrue(spellCheckerInjection.isValid(Value.COOKIES));
    }

    @Test
    public void suggestionValidTest() {
        SpellCheckerInjection spellCheckerInjection = new SpellCheckerInjection(UtilityLexicon.dictionaryCreator());
        assertEquals(new ArrayList<String>(Arrays.asList(FIRE, COOKIES)), spellCheckerInjection.suggestion(VALID));
    }

    @Test
    public void suggestionNotValidTest() {
        SpellCheckerInjection spellCheckerInjection = new SpellCheckerInjection(UtilityLexicon.dictionaryCreator());
        assertEquals(new ArrayList<String>(Arrays.asList(GET)), spellCheckerInjection.suggestion(NOT_VALID));
    }
}
