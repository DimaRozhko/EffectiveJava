package com.dima.effective.item5.utility;

import java.util.HashMap;
import java.util.Map;

import static com.dima.effective.item5.constants.Condition.*;
import static com.dima.effective.item5.constants.Value.*;

public class UtilityLexicon {

    private UtilityLexicon () {
        throw new AssertionError("Utility object 'UtilityLexicon' created");
    }

    public static Map<String, String> dictionaryCreator() {
        Map<String, String> dictionary = new HashMap<>();
        dictionary.put(FIRE, VALID);
        dictionary.put(COOKIES, VALID);
        dictionary.put(GET, NOT_VALID);
        return dictionary;
    }
}
