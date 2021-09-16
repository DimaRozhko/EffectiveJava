package com.dima.effective;

import com.dima.effective.item1.Primitive;
import com.dima.effective.item2.builder.NutritionFacts;
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
        NutritionFacts nutritionFacts = new NutritionFacts.Builder(12, 33).setFat(189).setCalories(659).setCalories(6).build();
        log.info("Item 2");
        if (nutritionFacts.getServingSize() == 12 && nutritionFacts.getServings() == 33
                && nutritionFacts.getFat() == 189 && nutritionFacts.getCalories() == 6
                && nutritionFacts.getCarbohydrate() == 0 && nutritionFacts.getSodium() == 0) {
            log.info("NutritionFacts.Builder correct");
        }
        else {
            log.error("NutritionFacts.Builder incorrect");
        }
    }
}
