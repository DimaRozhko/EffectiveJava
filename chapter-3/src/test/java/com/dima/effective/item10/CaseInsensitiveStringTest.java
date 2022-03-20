package com.dima.effective.item10;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CaseInsensitiveStringTest {

    private CaseInsensitiveString caseInsensitiveStringFirst = new CaseInsensitiveString("First");
    private CaseInsensitiveString caseInsensitiveStringFirstUpper = new CaseInsensitiveString("FIRST");
    private CaseInsensitiveString caseInsensitiveStringFirstLower = new CaseInsensitiveString("first");

    @Test
    public void reflexionTest() {
        assertTrue(this.caseInsensitiveStringFirst.equals(this.caseInsensitiveStringFirst));
    }

    @Test
    public void upperAndLowerEqualUpperTest() {
        assertTrue(this.caseInsensitiveStringFirst.equals(this.caseInsensitiveStringFirstUpper));
    }

    @Test
    public void upperEqualUpperAndLowerTest() {
        assertTrue(this.caseInsensitiveStringFirstUpper.equals(this.caseInsensitiveStringFirst));
    }

    @Test
    public void upperAndLowerEqualLowerTest() {
        assertTrue(this.caseInsensitiveStringFirst.equals(this.caseInsensitiveStringFirstLower));
    }

    @Test
    public void lowerEqualUpperAndLowerTest() {
        assertTrue(this.caseInsensitiveStringFirstLower.equals(this.caseInsensitiveStringFirst));
    }

    @Test
    public void upperEqualLowerTest() {
        assertTrue(this.caseInsensitiveStringFirstUpper.equals(this.caseInsensitiveStringFirstLower));
    }

    @Test
    public void lowerEqualUpperTest() {
        assertTrue(this.caseInsensitiveStringFirstLower.equals(this.caseInsensitiveStringFirstUpper));
    }

    @Test
    public void upperAndLowerEqualNullTest() {
        assertFalse(this.caseInsensitiveStringFirst.equals(null));
    }

    @Test
    public void upperEqualNullTest() {
        assertFalse(this.caseInsensitiveStringFirstUpper.equals(null));
    }

    @Test
    public void lowerEqualNullTest() {
        assertFalse(this.caseInsensitiveStringFirstLower.equals(null));
    }
}
