package com.dima.effective.item5.singletone;

import com.dima.effective.item5.utility.UtilityLexicon;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SpellCheckerSingleton {

    private final Map<String, String> dictionary = Collections.unmodifiableMap(UtilityLexicon.dictionaryCreator());

    private static final SpellCheckerSingleton INSTANCE = new SpellCheckerSingleton();

    private SpellCheckerSingleton() {}

    public static SpellCheckerSingleton getINSTANCE() {
        return INSTANCE;
    }

    public static boolean isValid(String word) {
        return INSTANCE.dictionary.get(word).equals("valid");
    }

    public static List<String> suggestion(String typo) {
        return INSTANCE.dictionary.values().stream()
                .filter(key -> key.equals(typo))
                .collect(Collectors.toList());
    }
}
