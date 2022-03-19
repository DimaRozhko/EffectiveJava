package com.dima.effective.item2;

import com.dima.effective.item2.builder.NutritionFacts;
import com.dima.effective.item2.hierarchicalbuilder.Calzone;
import com.dima.effective.item2.hierarchicalbuilder.NyPizza;
import com.dima.effective.item2.hierarchicalbuilder.Pizza;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Item2Test {

    @Test
    public void NutritionFactsFullTest(){
        final int SERVING_SIZE = 12;
        final int SERVING = 33;
        final int FAT = 189;
        final int CALORIES = 659;
        final int SODIUM = 6;
        final int CARBONHYDRATE = 62;
        NutritionFacts nutritionFacts = new NutritionFacts.Builder(SERVING_SIZE, SERVING).setFat(FAT)
                .setCalories(CALORIES).setSodium(SODIUM).setCarbohydrate(CARBONHYDRATE).build();
        assertEquals(SERVING_SIZE, nutritionFacts.getServingSize());
        assertEquals(SERVING, nutritionFacts.getServings());
        assertEquals(FAT, nutritionFacts.getFat());
        assertEquals(CALORIES, nutritionFacts.getCalories());
        assertEquals(SODIUM, nutritionFacts.getSodium());
        assertEquals(CARBONHYDRATE, nutritionFacts.getCarbohydrate());
    }

    @Test
    public void NutritionFactsBasicTest(){
        final int SERVING_SIZE = 12;
        final int SERVING = 33;
        NutritionFacts nutritionFacts = new NutritionFacts.Builder(SERVING_SIZE, SERVING).build();
        assertEquals(SERVING_SIZE, nutritionFacts.getServingSize());
        assertEquals(SERVING, nutritionFacts.getServings());
    }

    @Test
    public void NutritionFactsBasicAndFatTest(){
        final int SERVING_SIZE = 12;
        final int SERVING = 33;
        final int FAT = 189;
        NutritionFacts nutritionFacts = new NutritionFacts.Builder(SERVING_SIZE, SERVING).setFat(FAT).build();
        assertEquals(SERVING_SIZE, nutritionFacts.getServingSize());
        assertEquals(SERVING, nutritionFacts.getServings());
        assertEquals(FAT, nutritionFacts.getFat());
    }

    @Test
    public void NutritionFactsBasicAndCaloriesTest(){
        final int SERVING_SIZE = 12;
        final int SERVING = 33;
        final int CALORIES = 659;
        NutritionFacts nutritionFacts = new NutritionFacts.Builder(SERVING_SIZE, SERVING).setCalories(CALORIES).build();
        assertEquals(SERVING_SIZE, nutritionFacts.getServingSize());
        assertEquals(SERVING, nutritionFacts.getServings());
        assertEquals(CALORIES, nutritionFacts.getCalories());
    }

    @Test
    public void NutritionFactsBasicAndSodiumTest(){
        final int SERVING_SIZE = 12;
        final int SERVING = 33;
        final int SODIUM = 6;
        NutritionFacts nutritionFacts = new NutritionFacts.Builder(SERVING_SIZE, SERVING).setSodium(SODIUM).build();
        assertEquals(SERVING_SIZE, nutritionFacts.getServingSize());
        assertEquals(SERVING, nutritionFacts.getServings());
        assertEquals(SODIUM, nutritionFacts.getSodium());
    }

    @Test
    public void NutritionFactsBasicAndCarbonhydrateTest(){
        final int SERVING_SIZE = 12;
        final int SERVING = 33;
        final int CARBONHYDRATE = 62;
        NutritionFacts nutritionFacts = new NutritionFacts.Builder(SERVING_SIZE, SERVING).setCarbohydrate(CARBONHYDRATE).build();
        assertEquals(SERVING_SIZE, nutritionFacts.getServingSize());
        assertEquals(CARBONHYDRATE, nutritionFacts.getCarbohydrate());
    }

    @Test
    public void NyPizzaFullTest() {
        NyPizza nyPizza = new NyPizza.Builder(NyPizza.Size.SMALL)
                .addTopping(Pizza.Topping.HAM)
                .addTopping(Pizza.Topping.MUSHROOM)
                .addTopping(Pizza.Topping.ONION)
                .addTopping(Pizza.Topping.PEPPER)
                .addTopping(Pizza.Topping.SAUSAGE).build();
        assertEquals(NyPizza.Size.SMALL, nyPizza.size);
        assertEquals(Pizza.Topping.values().length, nyPizza.toppings.size());
        assertEquals(Pizza.Topping.HAM, nyPizza.toppings.toArray()[0]);
        assertEquals(Pizza.Topping.MUSHROOM, nyPizza.toppings.toArray()[1]);
        assertEquals(Pizza.Topping.ONION, nyPizza.toppings.toArray()[2]);
        assertEquals(Pizza.Topping.PEPPER, nyPizza.toppings.toArray()[3]);
        assertEquals(Pizza.Topping.SAUSAGE, nyPizza.toppings.toArray()[4]);
    }

    @Test
    public void NyPizzaFullAndHamTest() {
        NyPizza nyPizza = new NyPizza.Builder(NyPizza.Size.SMALL)
                .addTopping(Pizza.Topping.HAM)
                .addTopping(Pizza.Topping.MUSHROOM)
                .addTopping(Pizza.Topping.ONION)
                .addTopping(Pizza.Topping.PEPPER)
                .addTopping(Pizza.Topping.SAUSAGE)
                .addTopping(Pizza.Topping.HAM).build();
        assertEquals(NyPizza.Size.SMALL, nyPizza.size);
        assertEquals(Pizza.Topping.values().length, nyPizza.toppings.size());
        assertEquals(Pizza.Topping.HAM, nyPizza.toppings.toArray()[0]);
        assertEquals(Pizza.Topping.MUSHROOM, nyPizza.toppings.toArray()[1]);
        assertEquals(Pizza.Topping.ONION, nyPizza.toppings.toArray()[2]);
        assertEquals(Pizza.Topping.PEPPER, nyPizza.toppings.toArray()[3]);
        assertEquals(Pizza.Topping.SAUSAGE, nyPizza.toppings.toArray()[4]);
    }

    @Test
    public void NyPizzaHamTest() {
        NyPizza nyPizza = new NyPizza.Builder(NyPizza.Size.SMALL)
                .addTopping(Pizza.Topping.HAM).build();
        assertEquals(NyPizza.Size.SMALL, nyPizza.size);
        assertEquals(1, nyPizza.toppings.size());
        assertEquals(Pizza.Topping.HAM, nyPizza.toppings.toArray()[0]);
    }

    @Test
    public void NyPizzaMushroomTest() {
        NyPizza nyPizza = new NyPizza.Builder(NyPizza.Size.SMALL)
                .addTopping(Pizza.Topping.MUSHROOM).build();
        assertEquals(NyPizza.Size.SMALL, nyPizza.size);
        assertEquals(1, nyPizza.toppings.size());
        assertEquals(Pizza.Topping.MUSHROOM, nyPizza.toppings.toArray()[0]);
    }

    @Test
    public void NyPizzaFullOnionTest() {
        NyPizza nyPizza = new NyPizza.Builder(NyPizza.Size.SMALL)
                .addTopping(Pizza.Topping.ONION).build();
        assertEquals(NyPizza.Size.SMALL, nyPizza.size);
        assertEquals(1, nyPizza.toppings.size());
        assertEquals(Pizza.Topping.ONION, nyPizza.toppings.toArray()[0]);
    }

    @Test
    public void NyPizzaFullPepperTest() {
        NyPizza nyPizza = new NyPizza.Builder(NyPizza.Size.SMALL)
                .addTopping(Pizza.Topping.PEPPER).build();
        assertEquals(NyPizza.Size.SMALL, nyPizza.size);
        assertEquals(1, nyPizza.toppings.size());
        assertEquals(Pizza.Topping.PEPPER, nyPizza.toppings.toArray()[0]);
    }

    @Test
    public void NyPizzaFullSausageSmallTest() {
        NyPizza nyPizza = new NyPizza.Builder(NyPizza.Size.SMALL)
                .addTopping(Pizza.Topping.SAUSAGE).build();
        assertEquals(NyPizza.Size.SMALL, nyPizza.size);
        assertEquals(1, nyPizza.toppings.size());
        assertEquals(Pizza.Topping.SAUSAGE, nyPizza.toppings.toArray()[0]);
    }

    @Test
    public void NyPizzaFullSausageMediumTest() {
        NyPizza nyPizza = new NyPizza.Builder(NyPizza.Size.MEDIUM)
                .addTopping(Pizza.Topping.SAUSAGE).build();
        assertEquals(NyPizza.Size.MEDIUM, nyPizza.size);
        assertEquals(1, nyPizza.toppings.size());
        assertEquals(Pizza.Topping.SAUSAGE, nyPizza.toppings.toArray()[0]);
    }

    @Test
    public void NyPizzaFullSausageLargeTest() {
        NyPizza nyPizza = new NyPizza.Builder(NyPizza.Size.LARGE)
                .addTopping(Pizza.Topping.SAUSAGE).build();
        assertEquals(NyPizza.Size.LARGE, nyPizza.size);
        assertEquals(1, nyPizza.toppings.size());
        assertEquals(Pizza.Topping.SAUSAGE, nyPizza.toppings.toArray()[0]);
    }

    @Test
    public void CalzoneFullTest() {
        Calzone calzone = new Calzone.Builder()
                .addTopping(Pizza.Topping.HAM)
                .addTopping(Pizza.Topping.MUSHROOM)
                .addTopping(Pizza.Topping.ONION)
                .addTopping(Pizza.Topping.PEPPER)
                .addTopping(Pizza.Topping.SAUSAGE).build();
        assertEquals(Pizza.Topping.values().length, calzone.toppings.size());
        assertEquals(Pizza.Topping.HAM, calzone.toppings.toArray()[0]);
        assertEquals(Pizza.Topping.MUSHROOM, calzone.toppings.toArray()[1]);
        assertEquals(Pizza.Topping.ONION, calzone.toppings.toArray()[2]);
        assertEquals(Pizza.Topping.PEPPER, calzone.toppings.toArray()[3]);
        assertEquals(Pizza.Topping.SAUSAGE, calzone.toppings.toArray()[4]);
    }

    @Test
    public void CalzoneFullAndOnionTest() {
        Calzone calzone = new Calzone.Builder()
                .addTopping(Pizza.Topping.HAM)
                .addTopping(Pizza.Topping.MUSHROOM)
                .addTopping(Pizza.Topping.ONION)
                .addTopping(Pizza.Topping.PEPPER)
                .addTopping(Pizza.Topping.SAUSAGE)
                .addTopping(Pizza.Topping.ONION).build();
        assertEquals(Pizza.Topping.values().length, calzone.toppings.size());
        assertEquals(Pizza.Topping.HAM, calzone.toppings.toArray()[0]);
        assertEquals(Pizza.Topping.MUSHROOM, calzone.toppings.toArray()[1]);
        assertEquals(Pizza.Topping.ONION, calzone.toppings.toArray()[2]);
        assertEquals(Pizza.Topping.PEPPER, calzone.toppings.toArray()[3]);
        assertEquals(Pizza.Topping.SAUSAGE, calzone.toppings.toArray()[4]);
    }

    @Test
    public void CalzoneHamTest() {
        Calzone calzone = new Calzone.Builder()
                .addTopping(Pizza.Topping.HAM).build();
        assertEquals(1, calzone.toppings.size());
        assertEquals(Pizza.Topping.HAM, calzone.toppings.toArray()[0]);
    }

    @Test
    public void CalzonePepperTest() {
        Calzone calzone = new Calzone.Builder()
                .addTopping(Pizza.Topping.PEPPER).build();
        assertEquals(1, calzone.toppings.size());
        assertEquals(Pizza.Topping.PEPPER, calzone.toppings.toArray()[0]);
    }

    @Test
    public void CalzoneOnionTest() {
        Calzone calzone = new Calzone.Builder()
                .addTopping(Pizza.Topping.ONION).build();
        assertEquals(1, calzone.toppings.size());
        assertEquals(Pizza.Topping.ONION, calzone.toppings.toArray()[0]);
    }

    @Test
    public void CalzoneSausageTest() {
        Calzone calzone = new Calzone.Builder()
                .addTopping(Pizza.Topping.SAUSAGE).build();
        assertEquals(1, calzone.toppings.size());
        assertEquals(Pizza.Topping.SAUSAGE, calzone.toppings.toArray()[0]);
    }

    @Test
    public void CalzoneMushroomTest() {
        Calzone calzone = new Calzone.Builder()
                .addTopping(Pizza.Topping.MUSHROOM).build();
        assertEquals(1, calzone.toppings.size());
        assertEquals(Pizza.Topping.MUSHROOM, calzone.toppings.toArray()[0]);
    }
}
