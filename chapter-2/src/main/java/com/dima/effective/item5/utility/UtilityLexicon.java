package com.dima.effective.item5.utility;

import java.util.HashMap;
import java.util.Map;

public class UtilityLexicon {
    private static Map<String, String> dictionary;

    private UtilityLexicon () {
        throw new AssertionError();
    }

    public static Map<String, String> dictionaryCreator() {
        UtilityLexicon.dictionary = new HashMap<>();
        UtilityLexicon.dictionary.put("fire", "valid");
        UtilityLexicon.dictionary.put("get", "not");
        return UtilityLexicon.dictionary;
    }
}
