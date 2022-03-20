package com.dima.effective.item5.simple;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.dima.effective.item5.constants.Condition.*;
import static com.dima.effective.item5.constants.Value.*;

public class SpellChecker {

    private static final Map<String, String> dictionary = Collections.unmodifiableMap(UtilityLexicon.dictionaryCreator());

    private static class UtilityLexicon {

        private static Map<String, String> dictionary;

        private UtilityLexicon () {
            throw new AssertionError();
        }

        public static Map<String, String> dictionaryCreator() {
            UtilityLexicon.dictionary = new HashMap<>();
            UtilityLexicon.dictionary.put(FIRE, VALID);
            UtilityLexicon.dictionary.put(GET, NOT_VALID);
            UtilityLexicon.dictionary.put(COOKIES, VALID);
            return UtilityLexicon.dictionary;
        }

    }

    private SpellChecker() {}

    public static boolean isValid(String word) {
        return dictionary.get(word).equals(VALID);
    }

    public static List<String> suggestion(String typo) {
        return dictionary.entrySet().stream().filter(x -> typo.equals(x.getValue())).map(Map.Entry::getKey).collect(Collectors.toList());
    }
}
