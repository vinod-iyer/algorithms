package com.practice;

public class LongestUniqueSubstring {
    public int getLengthOfLongestUniqueSubstring(String input) {
        boolean[] occurenceArray = new boolean[128];
        int lengthOfSubstring = 0;
        int maxLengthSoFar = 0;
        for (int index = 0; index < input.length(); ++index) {
            int asciiOfChar = (int) input.charAt(index);

            if (occurenceArray[asciiOfChar]) {
                System.out.println("Size of substrings " + lengthOfSubstring);
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
        if (maxLengthSoFar < lengthOfSubstring) {
            maxLengthSoFar = lengthOfSubstring;
        }
        return maxLengthSoFar;
    }

    public static void main(String[] args) {
        System.out.println(new LongestUniqueSubstring().getLengthOfLongestUniqueSubstring("JGDJEPHABCH"));
        System.out.println(new LongestUniqueSubstring().getLengthOfLongestUniqueSubstring("JGDJEPHABCHABCDEFGIJ"));
        System.out.println(new LongestUniqueSubstring().getLengthOfLongestUniqueSubstring("JGDJ"));
        System.out.println(new LongestUniqueSubstring().getLengthOfLongestUniqueSubstring("JJ"));
        System.out.println(new LongestUniqueSubstring().getLengthOfLongestUniqueSubstring("J"));
    }
}
