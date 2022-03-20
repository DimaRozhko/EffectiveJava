package com.dima.effective.item5.injection;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.dima.effective.item5.constants.Condition.VALID;

public class SpellCheckerInjection {

    private final Map<String, String> dictionary;

    public SpellCheckerInjection(Map<String, String> dictionary) {
        this.dictionary = dictionary;
    }

    public boolean isValid(String word) {
        return this.dictionary.get(word).equals(VALID);
    }

    public List<String> suggestion(String typo) {
        return dictionary.entrySet().stream().filter(x -> typo.equals(x.getValue())).map(Map.Entry::getKey).collect(Collectors.toList());
    }
}
