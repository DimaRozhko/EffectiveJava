package com.dima.effective.item5.injection;

import com.dima.effective.item5.utility.UtilityLexicon;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SpellCheckerInjection {

    private final Map<String, String> dictionary;

    public SpellCheckerInjection(UtilityLexicon utilityLexicon) {
        this.dictionary = Collections.unmodifiableMap(UtilityLexicon.dictionaryCreator());
    }

    public boolean isValid(String word) {
        return this.dictionary.get(word).equals("valid");
    }

    public List<String> suggestion(String typo) {
        return this.dictionary.values().stream()
                .filter(key -> key.equals(typo))
                .collect(Collectors.toList());
    }
}
