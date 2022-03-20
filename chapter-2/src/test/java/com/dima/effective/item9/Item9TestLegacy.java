package com.dima.effective.item9;

import org.junit.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

@Deprecated
public class Item9TestLegacy {

    @Test
    public void firstLineOfFileIncorrectPathTest(){
        boolean isCorrectTest = false;
        try (MockedStatic<TryFinallyJavaLegacy> utilityItems = Mockito.mockStatic(TryFinallyJavaLegacy.class)) {
            utilityItems.when(() -> TryFinallyJavaLegacy.firstLineOfFile("")).thenThrow(IOException.class);
            TryFinallyJavaLegacy.firstLineOfFile("");
        }
        catch (IOException e){
            isCorrectTest = true;
        }
        assertTrue(isCorrectTest);
    }

    @Test
    public void firstLineOfFileCorrectPathTest(){
        boolean isCorrectTest = false;
        try (MockedStatic<TryFinallyJavaLegacy> utilityItems = Mockito.mockStatic(TryFinallyJavaLegacy.class)) {
            utilityItems.when(() -> TryFinallyJavaLegacy.firstLineOfFile("./pom.xml")).thenReturn("");
            TryFinallyJavaLegacy.firstLineOfFile("./pom.xml");
        }
        catch (IOException e){
            isCorrectTest = true;
        }
        assertFalse(isCorrectTest);
    }
}
