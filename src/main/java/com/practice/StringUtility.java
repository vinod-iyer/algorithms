package com.practice;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;

public class StringUtility {

    public boolean hasUniqueChars(String randomString) {
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

    public boolean isPermutation(String s, String t) {
        boolean returnValue = false;
        char[] unsortedS = s.toCharArray();
        char[] unsortedT = t.toCharArray();

        char[] sortedS = sort(unsortedS);
        char[] sortedT = sort(unsortedT);
        return new String(sortedS).equals(new String(sortedT));
    }

    private char[] sort(char[] toSort) {
        Arrays.sort(toSort);
        return toSort;
    }

    public static void main(String[] args) {
        System.out.println(new StringUtility().hasUniqueChars("abcd"));
        System.out.println(new StringUtility().hasUniqueChars("abcda"));
        System.out.println(new StringUtility().hasUniqueChars("aabcd"));
        System.out.println("JGD,GDJ "+new StringUtility().isPermutation("JGD","GDJ"));
        System.out.println("J ,G "+new StringUtility().isPermutation("J","G"));
        System.out.println("JGD, JGD "+new StringUtility().isPermutation("JGD","JGD"));

    }
}
