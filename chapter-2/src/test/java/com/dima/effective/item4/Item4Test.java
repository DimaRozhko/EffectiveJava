package com.dima.effective.item4;

import org.junit.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Item4Test {

    @Test
    public void isCreateObjectTrueTest(){
        boolean result = UtilityItem.isCreateObject();
        try (MockedStatic<UtilityItem> utilityItems = Mockito.mockStatic(UtilityItem.class)) {
            utilityItems.when(() -> UtilityItem.isCreateObject()).thenReturn(true);
            assertEquals(true, UtilityItem.isCreateObject());
        }
    }

    @Test
    public void isCreateObjectFalseTest(){
        boolean result = UtilityItem.isCreateObject();
        try (MockedStatic<UtilityItem> utilityItems = Mockito.mockStatic(UtilityItem.class)) {
            utilityItems.when(() -> UtilityItem.isCreateObject()).thenReturn(false);
            assertEquals(false, UtilityItem.isCreateObject());
        }
    }
}
