package com.dima.effective;

import com.dima.effective.item1.Primitive;
import com.dima.effective.item2.builder.NutritionFacts;
import com.dima.effective.item2.hierarchicalbuilder.Calzone;
import com.dima.effective.item2.hierarchicalbuilder.NyPizza;
import com.dima.effective.item2.hierarchicalbuilder.Pizza;
import com.dima.effective.item3.lazylaod.LazySingleton;
import com.dima.effective.item3.staticfactory.Elvis;
import com.dima.effective.item4.UtilityItem;
import com.dima.effective.item5.injection.SpellCheckerInjection;
import com.dima.effective.item5.simple.SpellChecker;
import com.dima.effective.item5.singletone.SpellCheckerSingleton;
import com.dima.effective.item5.utility.UtilityLexicon;
import com.dima.effective.item9.TryFinallyJavaActual;
import com.dima.effective.item9.TryFinallyJavaLegacy;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import static com.dima.effective.item5.constants.Condition.*;
import static com.dima.effective.item5.constants.Value.*;

@Slf4j
public class EffectiveSecondChapterApplication {

    public static void main(String[] args) {
        log.info("CHAPTER 2");
        log.info("Item 1");
        if (Primitive.valueOf(true) != Boolean.TRUE) {
            throw new AssertionError("Primitive.valueOf incorrect");
        }
        NutritionFacts nutritionFacts = new NutritionFacts.Builder(12, 33).setFat(189)
                .setCalories(659).setCalories(6).build();
        log.info("Item 2");
        if (!(nutritionFacts.getServingSize() == 12 && nutritionFacts.getServings() == 33
                && nutritionFacts.getFat() == 189 && nutritionFacts.getCalories() == 6
                && nutritionFacts.getCarbohydrate() == 0 && nutritionFacts.getSodium() == 0)) {
            throw new AssertionError("NutritionFacts.Builder incorrect");
        }
        NyPizza nyPizza = new NyPizza.Builder(NyPizza.Size.MEDIUM)
                .addTopping(Pizza.Topping.MUSHROOM).build();
        if (!(nyPizza.size.equals(NyPizza.Size.MEDIUM) &&
                nyPizza.toppings.contains(Pizza.Topping.MUSHROOM))) {
            throw new AssertionError("NyPizza.Builder incorrect");
        }
        Calzone calzone = new Calzone.Builder().
                sauceInstance().addTopping(Pizza.Topping.PEPPER).build();
        if (!(calzone.sauceInstance && calzone.toppings.contains(Pizza.Topping.PEPPER))) {
            throw new AssertionError("Calzone.Builder incorrect");
        }
        log.info("Item 3");
        if (Elvis.getInstance() == null) {
            throw new AssertionError("Elvis singleton incorrect");
        }
        if (LazySingleton.getInstance() == null) {
            throw new AssertionError("LazySingleton incorrect");
        }
        log.info("Item 4");
        if (UtilityItem.isCreateObject()) {
            throw new AssertionError("INCORRECT: object was created");
        }
        log.info("Item 5");
        log.info("SIMPLE CHECKER");
        if (!SpellChecker.isValid(FIRE)) {
            throw new AssertionError("SpellChecker.isValid incorrect for \"fire\"");
        }
        if (Arrays.asList(FIRE).containsAll(SpellChecker.suggestion(VALID))) {
            throw new AssertionError("SpellChecker.suggestion(\"valid\") incorrect for \"fire\"");
        }
        if (SpellChecker.isValid(GET)) {
            throw new AssertionError("SpellChecker.isValid incorrect for \"get\"");
        }
        if (!Arrays.asList(GET).containsAll(SpellChecker.suggestion(NOT_VALID))) {
            throw new AssertionError("SpellChecker.suggestion(\"valid\") incorrect for \"get\"");
        }
        log.info("SINGLETON CHECKER");
        if (!SpellCheckerSingleton.getINSTANCE().isValid(FIRE)) {
            throw new AssertionError("SpellCheckerSingleton.getINSTANCE().isValid(FIRE) incorrect for \"fire\"");
        }
        if (SpellCheckerSingleton.getINSTANCE().isValid(GET)) {
            throw new AssertionError("SpellCheckerSingleton.getINSTANCE().isValid(GET) incorrect for \"get\"");
        }
        if (!SpellCheckerSingleton.getINSTANCE().suggestion(VALID).equals(new ArrayList<String>(Arrays.asList(FIRE, COOKIES)))) {
            throw new AssertionError("SpellCheckerSingleton.getINSTANCE().suggestion(VALID) incorrect [fire, cookies]");
        }
        if (!SpellCheckerSingleton.getINSTANCE().suggestion(NOT_VALID).equals(new ArrayList<String>(Arrays.asList(GET)))) {
            throw new AssertionError("SpellCheckerSingleton.getINSTANCE().suggestion(VALID) incorrect [get]");
        }
        log.info("INJECTION CHECKER");
        SpellCheckerInjection spellCheckerInjection = new SpellCheckerInjection(UtilityLexicon.dictionaryCreator());
        if (!spellCheckerInjection.isValid(FIRE)) {
            throw new AssertionError("spellCheckerInjection.isValid(FIRE) incorrect for \"fire\"");
        }
        if (spellCheckerInjection.isValid(GET)) {
            throw new AssertionError("spellCheckerInjection.isValid(GET) incorrect for \"get\"");
        }
        if (!spellCheckerInjection.suggestion(VALID).equals(new ArrayList<String>(Arrays.asList(FIRE, COOKIES)))) {
            throw new AssertionError("spellCheckerInjection.suggestion(VALID) incorrect [fire, cookies]");
        }
        if (!spellCheckerInjection.suggestion(NOT_VALID).equals(new ArrayList<String>(Arrays.asList(GET)))) {
            throw new AssertionError("spellCheckerInjection.suggestion(NOT_VALID) incorrect [get]");
        }
        log.info("Item 9");
        log.info("LEGACY");
        try {
            TryFinallyJavaLegacy.firstLineOfFile("");
            throw new AssertionError("TryFinallyJavaLegacy.firstLineOfFile(\"\") incorrect");
        }
        catch (IOException e) {
        }
        try {
            TryFinallyJavaLegacy.firstLineOfFile("./pom.xml");
        }
        catch (IOException e) {
            throw new AssertionError("TryFinallyJavaLegacy.firstLineOfFile(\"/pom.xml\") incorrect");
        }
        log.info("ACTUAL");
        try {
            TryFinallyJavaActual.firstLineOfFile("");
            throw new AssertionError("TryFinallyJavaActual.firstLineOfFile(\"\") incorrect");
        }
        catch (IOException e) {
        }
        try {
            TryFinallyJavaActual.firstLineOfFile("./pom.xml");
        }
        catch (IOException e) {
            throw new AssertionError("TryFinallyJavaActual.firstLineOfFile(\"/pom.xml\") incorrect");
        }
    }
}
