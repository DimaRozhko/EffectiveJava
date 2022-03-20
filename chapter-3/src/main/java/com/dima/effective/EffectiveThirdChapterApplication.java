package com.dima.effective;

import com.dima.effective.item10.CaseInsensitiveString;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EffectiveThirdChapterApplication {

    public static void main(String[] args) {
        log.info("CHAPTER 3");
        log.info("Item 10 start");
        CaseInsensitiveString caseInsensitiveStringFirst = new CaseInsensitiveString("First");
        CaseInsensitiveString caseInsensitiveStringFirstUpper = new CaseInsensitiveString("FIRST");
        CaseInsensitiveString caseInsensitiveStringFirstLower = new CaseInsensitiveString("first");
        if (!caseInsensitiveStringFirst.equals(caseInsensitiveStringFirst)) {
            throw new AssertionError("INSENSITIVE CHECK: First equal First (reflexion)");
        }
        if (!caseInsensitiveStringFirst.equals(caseInsensitiveStringFirstUpper)) {
            throw new AssertionError("INSENSITIVE CHECK: First equal FIRST");
        }
        if (!caseInsensitiveStringFirstUpper.equals(caseInsensitiveStringFirst)) {
            throw new AssertionError("INSENSITIVE CHECK: FIRST equal First");
        }
        if (!caseInsensitiveStringFirstLower.equals(caseInsensitiveStringFirstUpper)) {
            throw new AssertionError("INSENSITIVE CHECK: first equal FIRST");
        }
        if (!caseInsensitiveStringFirstUpper.equals(caseInsensitiveStringFirstLower)) {
            throw new AssertionError("INSENSITIVE CHECK: FIRST equal first");
        }
        if (!caseInsensitiveStringFirstLower.equals(caseInsensitiveStringFirst)) {
            throw new AssertionError("INSENSITIVE CHECK: first equal First");
        }
        if (!caseInsensitiveStringFirst.equals(caseInsensitiveStringFirstLower)) {
            throw new AssertionError("INSENSITIVE CHECK: First equal first");
        }
        log.info("Item 10 stop");
    }
}
