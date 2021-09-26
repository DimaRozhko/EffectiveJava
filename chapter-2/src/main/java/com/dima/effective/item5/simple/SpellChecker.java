package com.dima.effective.item5.simple;

import com.dima.effective.item5.utility.UtilityLexicon;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SpellChecker {

    private static final Map<String, String> dictionary = Collections.unmodifiableMap(UtilityLexicon.dictionaryCreator());

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
