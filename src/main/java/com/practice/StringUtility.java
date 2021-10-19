package com.practice;

import java.util.concurrent.atomic.AtomicBoolean;

public class StringUtility {

    private boolean hasUniqueChars(String randomString) {
        final boolean[] occurrenceArray = new boolean[128];
        final AtomicBoolean returnBoolean = new AtomicBoolean(true);
        randomString.chars().forEach(character -> {
            if (occurrenceArray[(int) character])
                returnBoolean.getAndSet(false);
            else {
                occurrenceArray[(int) character] = true;
            }
        });

        return returnBoolean.get();
    }

    public static void main(String[] args) {
        System.out.println(new StringUtility().hasUniqueChars("abcd"));
        System.out.println(new StringUtility().hasUniqueChars("abcda"));
        System.out.println(new StringUtility().hasUniqueChars("aabcd"));
    }
}
