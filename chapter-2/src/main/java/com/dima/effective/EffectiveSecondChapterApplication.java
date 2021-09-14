package com.dima.effective;

import com.dima.effective.item1.Primitive;
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
    }
}
