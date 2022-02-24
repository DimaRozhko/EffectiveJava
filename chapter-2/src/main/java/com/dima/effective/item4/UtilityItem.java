package com.dima.effective.item4;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.util.stream.Stream;

public class UtilityItem {

    private UtilityItem () {
        throw new AssertionError("Utility object 'UtilityItem' created");
    }

    public static boolean isCreateObject() {
        try {
            Constructor<?>[] constructors = UtilityItem.class.getDeclaredConstructors();
            if (Stream.of(constructors).filter(x -> Modifier.isPublic(x.getModifiers())).count() == 0){
                constructors[0].setAccessible(true);
                constructors[0].newInstance();
            }
        }
        catch (Throwable throwable) {
            return false;
        }
        return true;
    }
}
