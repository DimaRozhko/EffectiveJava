package com.dima.effective.item9;

import org.junit.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class Item9TestActual {

    @Test
    public void firstLineOfFileIncorrectPathTest(){
        boolean isCorrectTest = false;
        try (MockedStatic<TryFinallyJavaActual> utilityItems = Mockito.mockStatic(TryFinallyJavaActual.class)) {
                utilityItems.when(() -> TryFinallyJavaActual.firstLineOfFile("")).thenThrow(IOException.class);
            TryFinallyJavaActual.firstLineOfFile("");
        }
        catch (IOException e){
            isCorrectTest = true;
        }
        assertTrue(isCorrectTest);
    }

    @Test
    public void firstLineOfFileCorrectPathTest(){
        boolean isCorrectTest = false;
        try (MockedStatic<TryFinallyJavaActual> utilityItems = Mockito.mockStatic(TryFinallyJavaActual.class)) {
            utilityItems.when(() -> TryFinallyJavaActual.firstLineOfFile("./pom.xml")).thenReturn("");
            TryFinallyJavaActual.firstLineOfFile("./pom.xml");
        }
        catch (IOException e){
            isCorrectTest = true;
        }
        assertFalse(isCorrectTest);
    }
}
