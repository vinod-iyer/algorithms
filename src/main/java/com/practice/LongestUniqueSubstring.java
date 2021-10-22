package com.practice;

import java.util.HashSet;
import java.util.Set;

public class LongestUniqueSubstring {

    private static int getMaxLengthOfTheUniqueSubstring(String input) {

        if (input == null || input.isBlank()) {
            return -1;
        }

        if (input.length() == 1) {
            return 1;
        }

        int maxSoFar = Integer.MIN_VALUE;
        int leftPointer = 0, rightPointer = 0;

        Set<Character> uniqueChars = new HashSet<>();

        while (rightPointer < input.length()) {
            if (!uniqueChars.contains(input.charAt(rightPointer))) {
                uniqueChars.add(input.charAt(rightPointer));
                rightPointer +=1;
                maxSoFar = Math.max(uniqueChars.size(), maxSoFar);
            } else {
                uniqueChars.remove(input.charAt(leftPointer));
                leftPointer += 1;
            }
        }
        return maxSoFar;
    }

    public int getLengthOfLongestUniqueSubstring(String input) {
        boolean[] occurenceArray = new boolean[128];
        int lengthOfSubstring = 0;
        int maxLengthSoFar = 0;
        int substringIndex = 1;

        for (int index = 0; index < input.length(); ++index) {
            int asciiOfChar = (int) input.charAt(index);
            if (occurenceArray[asciiOfChar]) {
                print(substringIndex++, lengthOfSubstring);
                if (maxLengthSoFar < lengthOfSubstring) {
                    maxLengthSoFar = lengthOfSubstring;
                }
                occurenceArray = new boolean[128];
                occurenceArray[asciiOfChar] = true;
                lengthOfSubstring = 1;
            } else {
                occurenceArray[asciiOfChar] = true;
                lengthOfSubstring++;
            }
        }
        print(substringIndex++, lengthOfSubstring);
        if (maxLengthSoFar < lengthOfSubstring) {
            maxLengthSoFar = lengthOfSubstring;
        }
        return maxLengthSoFar;
    }

    private void print(int substringIndex, int lengthOfSubstring) {
        System.out.println("Size of substring [" + substringIndex + "]" + lengthOfSubstring);
    }


    public static void main(String[] args) {
        System.out.println(new LongestUniqueSubstring().getLengthOfLongestUniqueSubstring("JGDJEPHABCH"));
        System.out.println(new LongestUniqueSubstring().getLengthOfLongestUniqueSubstring("JGDJEPHABCHABCDEFGIJ"));
        System.out.println(new LongestUniqueSubstring().getLengthOfLongestUniqueSubstring("JGDJ"));
        System.out.println(new LongestUniqueSubstring().getLengthOfLongestUniqueSubstring("JJ"));
        System.out.println(new LongestUniqueSubstring().getLengthOfLongestUniqueSubstring("J"));
        System.out.println(new LongestUniqueSubstring().getLengthOfLongestUniqueSubstring("abcbcaabbc"));

        System.out.println( getMaxLengthOfTheUniqueSubstring("JGDJEPHABCHABCDEFGIJ"));
    }
}
