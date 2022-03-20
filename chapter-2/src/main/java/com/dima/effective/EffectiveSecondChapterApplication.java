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
        if (Primitive.valueOf(true) == Boolean.TRUE) {
            log.info("Primitive.valueOf correct");
        }
        else {
            log.error("Primitive.valueOf incorrect");
        }
        NutritionFacts nutritionFacts = new NutritionFacts.Builder(12, 33).setFat(189)
                .setCalories(659).setCalories(6).build();
        log.info("Item 2");
        if (nutritionFacts.getServingSize() == 12 && nutritionFacts.getServings() == 33
                && nutritionFacts.getFat() == 189 && nutritionFacts.getCalories() == 6
                && nutritionFacts.getCarbohydrate() == 0 && nutritionFacts.getSodium() == 0) {
            log.info("NutritionFacts.Builder correct");
        }
        else {
            log.error("NutritionFacts.Builder incorrect");
        }
        NyPizza nyPizza = new NyPizza.Builder(NyPizza.Size.MEDIUM)
                .addTopping(Pizza.Topping.MUSHROOM).build();
        if (nyPizza.size.equals(NyPizza.Size.MEDIUM) &&
                nyPizza.toppings.contains(Pizza.Topping.MUSHROOM)) {
            log.info("NyPizza.Builder correct");
        }
        Calzone calzone = new Calzone.Builder().
                sauceInstance().addTopping(Pizza.Topping.PEPPER).build();
        if (calzone.sauceInstance && calzone.toppings.contains(Pizza.Topping.PEPPER)) {
            log.info("Calzone.Builder correct");
        }
        log.info("Item 3");
        if (Elvis.getInstance() != null) {
            log.info("Elvis singleton correct");
        }
        if (LazySingleton.getInstance() != null) {
            log.info("LazySingleton correct");
        }
        log.info("Item 4");
        if (!UtilityItem.isCreateObject()) {
            log.info("CORRECT: object was created");
        }
        else{
            log.info("INCORRECT: object was created");
        }
        log.info("Item 5");
        log.info("SIMPLE CHECKER");
        if (SpellChecker.isValid(FIRE)) {
            log.info("SpellChecker.isValid correct for \"fire\"");
        }
        if (!Arrays.asList(FIRE).containsAll(SpellChecker.suggestion(VALID))) {
            log.info("SpellChecker.suggestion(\"valid\") correct for \"fire\"");
        }
        if (!SpellChecker.isValid(GET)) {
            log.info("SpellChecker.isValid correct for \"get\"");
        }
        if (Arrays.asList(GET).containsAll(SpellChecker.suggestion(NOT_VALID))) {
            log.info("SpellChecker.suggestion(\"valid\") correct for \"get\"");
        }
        log.info("SINGLETON CHECKER");
        if (SpellCheckerSingleton.getINSTANCE().isValid(FIRE)) {
            log.info("SpellCheckerSingleton.getINSTANCE().isValid(FIRE) correct for \"fire\"");
        }
        if (!SpellCheckerSingleton.getINSTANCE().isValid(GET)) {
            log.info("SpellCheckerSingleton.getINSTANCE().isValid(GET) correct for \"get\"");
        }
        if (SpellCheckerSingleton.getINSTANCE().suggestion(VALID).equals(new ArrayList<String>(Arrays.asList(FIRE, COOKIES)))) {
            log.info("SpellCheckerSingleton.getINSTANCE().suggestion(VALID) correct [fire, cookies]");
        }
        if (SpellCheckerSingleton.getINSTANCE().suggestion(NOT_VALID).equals(new ArrayList<String>(Arrays.asList(GET)))) {
            log.info("SpellCheckerSingleton.getINSTANCE().suggestion(VALID) correct [get]");
        }
        log.info("INJECTION CHECKER");
        SpellCheckerInjection spellCheckerInjection = new SpellCheckerInjection(UtilityLexicon.dictionaryCreator());
        if (spellCheckerInjection.isValid(FIRE)) {
            log.info("spellCheckerInjection.isValid(FIRE) correct for \"fire\"");
        }
        if (!spellCheckerInjection.isValid(GET)) {
            log.info("spellCheckerInjection.isValid(GET) correct for \"get\"");
        }
        if (spellCheckerInjection.suggestion(VALID).equals(new ArrayList<String>(Arrays.asList(FIRE, COOKIES)))) {
            log.info("spellCheckerInjection.suggestion(VALID) correct [fire, cookies]");
        }
        if (spellCheckerInjection.suggestion(NOT_VALID).equals(new ArrayList<String>(Arrays.asList(GET)))) {
            log.info("spellCheckerInjection.suggestion(NOT_VALID) correct [get]");
        }
        log.info("Item 9");
        log.info("LEGACY");
        try {
            TryFinallyJavaLegacy.firstLineOfFile("");
            log.info("TryFinallyJavaLegacy.firstLineOfFile(\"\") incorrect");
        }
        catch (IOException e) {
            log.info("TryFinallyJavaLegacy.firstLineOfFile(\"\") correct");
        }
        try {
            TryFinallyJavaLegacy.firstLineOfFile("./pom.xml");
            log.info("TryFinallyJavaLegacy.firstLineOfFile(\"/pom.xml\") correct");
        }
        catch (IOException e) {
            log.info("TryFinallyJavaLegacy.firstLineOfFile(\"/pom.xml\") incorrect");
        }
        log.info("ACTUAL");
        try {
            TryFinallyJavaActual.firstLineOfFile("");
            log.info("TryFinallyJavaActual.firstLineOfFile(\"\") incorrect");
        }
        catch (IOException e) {
            log.info("TryFinallyJavaActual.firstLineOfFile(\"\") correct");
        }
        try {
            TryFinallyJavaActual.firstLineOfFile("./pom.xml");
            log.info("TryFinallyJavaActual.firstLineOfFile(\"/pom.xml\") correct");
        }
        catch (IOException e) {
            log.info("TryFinallyJavaActual.firstLineOfFile(\"/pom.xml\") incorrect");
        }
    }
}
