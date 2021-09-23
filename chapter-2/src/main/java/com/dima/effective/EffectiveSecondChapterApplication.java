package com.dima.effective;

import com.dima.effective.item1.Primitive;
import com.dima.effective.item2.builder.NutritionFacts;
import com.dima.effective.item2.hierarchicalbuilder.Calzone;
import com.dima.effective.item2.hierarchicalbuilder.NyPizza;
import com.dima.effective.item2.hierarchicalbuilder.Pizza;
import com.dima.effective.item3.lazylaod.LazySingleton;
import com.dima.effective.item3.staticfactory.Elvis;
import com.dima.effective.item4.UtilityItem;
import lombok.extern.slf4j.Slf4j;

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
        log.info("Item 2");
        if (Elvis.getInstance() != null) {
            log.info("Elvis singleton correct");
        }
        if (LazySingleton.getInstance() != null) {
            log.info("LazySingleton correct");
        }
    }
}
