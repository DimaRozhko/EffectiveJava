package com.dima.effective.item5.singletone;

import com.dima.effective.item5.utility.UtilityLexicon;
import lombok.NonNull;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.dima.effective.item5.constants.Condition.VALID;

public class SpellCheckerSingleton {

    private final Map<String, String> dictionary = Collections.unmodifiableMap(UtilityLexicon.dictionaryCreator());

    private static final SpellCheckerSingleton INSTANCE = new SpellCheckerSingleton();

    private SpellCheckerSingleton() {}

    public static SpellCheckerSingleton getINSTANCE() {
        return INSTANCE;
    }

    public boolean isValid(String word) {
        return INSTANCE.dictionary.get(word).equals(VALID);
    }

    public List<String> suggestion(@NonNull String typo) {
        return INSTANCE.dictionary.entrySet().stream().filter(x -> typo.equals(x.getValue())).map(Map.Entry::getKey).collect(Collectors.toList());
    }
}
