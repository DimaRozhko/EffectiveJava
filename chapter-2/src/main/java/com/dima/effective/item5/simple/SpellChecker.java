package com.dima.effective.item5.simple;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SpellChecker {

    private static final Map<String, String> dictionary = Collections.unmodifiableMap(UtilityLexicon.dictionaryCreator());

    private static class UtilityLexicon {

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

    private SpellChecker() {}

    public static boolean isValid(String word) {
        return dictionary.get(word).equals("valid");
    }

    public static List<String> suggestion(String typo) {
        return dictionary.values().stream()
                .filter(key -> key.equals(typo))
                .collect(Collectors.toList());
    }
}
